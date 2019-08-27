package com.neverend.blog.dao.impl;

import com.google.gson.Gson;
import com.neverend.blog.dao.QiNiuKeyDao;
import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.QiNiuKey;
import com.neverend.blog.moudel.ErrorMsg;
import com.neverend.blog.moudel.MyServiceException;
import com.neverend.blog.moudel.UploadFileMsg;
import com.neverend.blog.security.CustomerFilterChainDefinition;
import com.neverend.blog.service.UploadService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.persistent.FileRecorder;
import com.qiniu.util.Auth;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.util.List;

/**
 * 上传文件实现类
 */
@Service
public class UploadServiceImpl implements UploadService {
    private Logger logger = LoggerFactory.getLogger(CustomerFilterChainDefinition.class);
    @Autowired
    private QiNiuKeyDao qiNiuKeyDao;

    /**
     * 上传图片
     *
     * @param multipartFile
     * @return
     */
    @Override
    public UploadFileMsg uploadimg(MultipartFile multipartFile) {
        UploadFileMsg uploadFileMsg = new UploadFileMsg();
        List<QiNiuKey> qiNiuKey = qiNiuKeyDao.getQiNiuKey();
        Subject subject = SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();
        if (!qiNiuKey.isEmpty()) {
            if (account!=null && account.getBeiYongEr().equals("管理员")){
                //构造一个带指定 Region 对象的配置类
                Configuration cfg = new Configuration(Region.huanan());
                String accessKey = qiNiuKey.get(0).getAk();
                String secretKey = qiNiuKey.get(0).getSk();
                String bucket = qiNiuKey.get(0).getQiNiuName();
//默认不指定key的情况下，以文件内容的hash值作为文件名
                String key = null;
                Auth auth = Auth.create(accessKey, secretKey);
                String upToken = auth.uploadToken(bucket);
                String localTempDir = Paths.get(System.getenv("java.io.tmpdir"), bucket).toString();
                try {
                    //设置断点续传文件进度保存目录
                    FileRecorder fileRecorder = new FileRecorder(localTempDir);
                    UploadManager uploadManager = new UploadManager(cfg, fileRecorder);
                    try {
                        Response response = uploadManager.put(multipartFile.getBytes(), key, upToken);
                        //解析上传成功的结果
                        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//                    生成访问url
                        String encodedFileName = URLEncoder.encode(putRet.key, "utf-8").replace("+", "%20");
                        String publicUrl = String.format("%s/%s", qiNiuKey.get(0).getYuMing(), encodedFileName);
//                    设置响应信息
                        uploadFileMsg.setUrl(publicUrl);
                        uploadFileMsg.setUploaded("1");
                        uploadFileMsg.setFileName(putRet.key);
                        return uploadFileMsg;
                    } catch (QiniuException ex) {
                        Response r = ex.response;
                        logger.error(r.toString());
                        return seErroMsg(uploadFileMsg, ex);
                    }
                } catch (IOException ex) {
                    return seErroMsg(uploadFileMsg, ex);
                }
            }else {
                return seErroMsg(uploadFileMsg,new MyServiceException("您没有无权限"));
            }

        } else {
            logger.error("获取七牛 ak sk 失败");
            return seErroMsg(uploadFileMsg, new MyServiceException("获取七牛 ak sk 失败"));
        }
    }


    private UploadFileMsg seErroMsg(UploadFileMsg uploadFileMsg, Exception e) {
        ErrorMsg error = new ErrorMsg();
        error.setMessage(e.getMessage());
        uploadFileMsg.setUploaded("0");
        uploadFileMsg.setError(error);
        return uploadFileMsg;
    }
}
