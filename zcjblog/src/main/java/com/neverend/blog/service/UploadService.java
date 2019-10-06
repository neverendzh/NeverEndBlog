package com.neverend.blog.service;

import com.neverend.blog.moudel.Msg;
import com.neverend.blog.moudel.UploadFileMsg;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *上传问价接口
 */
@Service
public interface UploadService {
    /**
     * 上传图片
     * @param multipartFile
     * @return
     */
    UploadFileMsg uploadimg( MultipartFile multipartFile);

    /**
     * 用户上传头像 或修改
     * @param img
     * @return
     */
    Msg upLoadAccountImg(MultipartFile img);
}
