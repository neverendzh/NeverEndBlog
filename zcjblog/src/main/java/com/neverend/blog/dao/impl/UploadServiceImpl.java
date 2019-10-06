package com.neverend.blog.dao.impl;

import com.google.gson.Gson;
import com.neverend.blog.dao.QiNiuKeyDao;
import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.QiNiuKey;
import com.neverend.blog.exception.ServiceException;
import com.neverend.blog.moudel.Code;
import com.neverend.blog.moudel.ErrorMsg;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.moudel.UploadFileMsg;
import com.neverend.blog.security.CustomerFilterChainDefinition;
import com.neverend.blog.service.AccountServiceMyzcj;
import com.neverend.blog.service.UploadService;
import com.neverend.blog.util.email.qiniu.Etag;
import com.neverend.blog.util.email.redis.RedisUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.persistent.FileRecorder;
import com.qiniu.util.Auth;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 上传文件实现类
 */
@Service
public class UploadServiceImpl implements UploadService {
    private Logger logger = LoggerFactory.getLogger(CustomerFilterChainDefinition.class);
    @Autowired
    private QiNiuKeyDao qiNiuKeyDao;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private AccountServiceMyzcj accountServiceMyzcj;

    private static final String qiNiuKeyred = "qiNiuKey";

    /**
     * 上传图片
     *
     * @param multipartFile
     * @return
     */
    @Override
    public UploadFileMsg uploadimg(MultipartFile multipartFile) {
        UploadFileMsg uploadFileMsg = new UploadFileMsg();
        QiNiuKey qiNiuKey = getqiniukey("0");
        Subject subject = SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();
        if (qiNiuKey != null) {
            if (account != null && account.getBeiYongEr().equals("管理员")) {
                Configuration cfg = new Configuration(Region.huanan());
                String key = hashName(multipartFile);
                Auth auth = Auth.create(qiNiuKey.getAk(), qiNiuKey.getSk());
                String upToken = auth.uploadToken(qiNiuKey.getQiNiuName());
                String localTempDir = Paths.get(System.getenv("java.io.tmpdir"), qiNiuKey.getQiNiuName()).toString();
                try {
                    FileRecorder fileRecorder = new FileRecorder(localTempDir);
                    UploadManager uploadManager = new UploadManager(cfg, fileRecorder);
                    Response response = uploadManager.put(multipartFile.getBytes(), key, upToken);
                    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                    String encodedFileName = URLEncoder.encode(putRet.key, "utf-8").replace("+", "%20");
                    String publicUrl = String.format("%s/%s", qiNiuKey.getYuMing(), encodedFileName);
                    redisUtil.set(account.getId(), publicUrl);
                    uploadFileMsg.setUrl(publicUrl);
                    uploadFileMsg.setUploaded("1");
                    uploadFileMsg.setFileName(putRet.key);
                    return uploadFileMsg;
                } catch (IOException ex) {
                    logger.error(ex.getMessage());
                    return seErroMsg(uploadFileMsg, ex);
                }
            } else {
                return seErroMsg(uploadFileMsg, new ServiceException("您没有无权限"));
            }
        } else {
            logger.error("获取七牛 ak sk 失败");
            return seErroMsg(uploadFileMsg, new ServiceException("获取七牛 ak sk 失败"));
        }
    }

    /**
     * 用户上传头像 或修改
     *
     * @param img
     * @return
     */
    @Override
    public Msg upLoadAccountImg(MultipartFile img) {
        String gqk = "1";
        Msg msg = new Msg();
        QiNiuKey qiNiuKey = getqiniukey(gqk);
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        if (qiNiuKey != null) {
            if (account != null && account.getBeiYongEr().equals("管理员") ||
                    account.getBeiYongEr().equals("用户") || account.getBeiYongEr().equals("超级管理员")) {
                Configuration cfg = new Configuration(Region.huanan());
                try {
                    String key = hashName(img);
                    Auth auth = Auth.create(qiNiuKey.getAk(), qiNiuKey.getSk());
                    String upToken = auth.uploadToken(qiNiuKey.getQiNiuName(), key);
                    String localTempDir = Paths.get(System.getenv("java.io.tmpdir"), qiNiuKey.getQiNiuName()).toString();
                    FileRecorder fileRecorder = new FileRecorder(localTempDir);
                    UploadManager uploadManager = new UploadManager(cfg, fileRecorder);
                    Response response = uploadManager.put(img.getBytes(), key, upToken);
                    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                    String encodedFileName = URLEncoder.encode(putRet.key, "utf-8").replace("+", "%20");
                    String publicUrl = String.format("%s/%s", qiNiuKey.getYuMing(), encodedFileName);
                    delimgOrFile(account.getBeiYongWu(),gqk);
                    account.setBeiYongSan(publicUrl);
                    account.setBeiYongWu(key);
                    updateimg(account, publicUrl,key);
                    retmsg(msg, publicUrl);
                    return msg;
                } catch (IOException ex) {
                    return seErroMsg(msg, ex);
                }
            } else {
                return seErroMsg(msg, new ServiceException("您没有权限"));
            }
        } else {
            logger.error("获取七牛 ak sk 失败");
            return seErroMsg(msg, new ServiceException("服务暂停"));
        }
    }

    private boolean delimgOrFile(String key,String getqiNiuKey){
        QiNiuKey qiNiuKey = getqiniukey(getqiNiuKey);
        Configuration cfg = new Configuration(Region.huanan());
        Auth auth = Auth.create(qiNiuKey.getAk(), qiNiuKey.getSk());
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            Response delete = bucketManager.delete(qiNiuKey.getQiNiuName(), key);
            return true;
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
            return false;
        }
    }
    /**
     * 获取hash文件名
     * @param img
     * @return
     */
    private String hashName(MultipartFile img) {
        try {
            String contentType = img.getContentType();
            MimeTypes allTypes = MimeTypes.getDefaultMimeTypes();
            MimeType jpeg = allTypes.forName(contentType);
            String houzhui = jpeg.getExtension(); //文件后缀
            InputStream inputStream = img.getInputStream();
            String stream = Etag.stream(inputStream, img.getSize()) + houzhui;
            inputStream.close();
            return stream;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MimeTypeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[][] TwoArry(byte[] bytes) {
        byte[][] arr = new byte[1][bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            arr[0][i] = bytes[i];
        }
        return arr;
    }

    private void retmsg(Msg msg, String publicUrl) {
        Map<String, String> msgsrc = new HashMap<>();
        msgsrc.put("src", publicUrl);
        msg.setCode("0");
        msg.setMsg("成功");
        msg.setData(msgsrc);
    }

    private int updateimg(Account account, String publicUrl,String key) {
        Account account1 = new Account();
        account1.setId(account.getId());
        account1.setBeiYongSan(publicUrl);
        account1.setBeiYongWu(key);
        int updateaccount = accountServiceMyzcj.updateaccount(account1);
        return updateaccount;
    }

    /**
     * 获取七牛key
     *
     * @return
     */
    private QiNiuKey getqiniukey(String key) {
        List<Object> objects = redisUtil.lGet(qiNiuKeyred + key, 0L, -1L);
        List<QiNiuKey> qiNiuKey = zhQiNiuKey(objects);
        if (qiNiuKey == null) {
            qiNiuKey = qiNiuKeyDao.getQiNiuKey(key);
            redisUtil.lSet(qiNiuKeyred + key, qiNiuKey, 7200);
        }
        if (!qiNiuKey.isEmpty() && qiNiuKey.size() > 0) {
            return qiNiuKey.get(0);
        }
        return null;
    }

    private List<QiNiuKey> zhQiNiuKey(List<Object> objects) {
        if (objects != null && objects.size() > 0) {
            return (List<QiNiuKey>) objects.get(0);
        }
        return null;
    }


    private UploadFileMsg seErroMsg(UploadFileMsg uploadFileMsg, Exception e) {
        ErrorMsg error = new ErrorMsg();
        error.setMessage(e.getMessage());
        uploadFileMsg.setUploaded("0");
        uploadFileMsg.setError(error);
        return uploadFileMsg;
    }

    private Msg seErroMsg(Msg msg, Exception e) {
        msg.setCode(Code.error);
        msg.setMsg(Code.errorMsg);
        return msg;
    }
}
