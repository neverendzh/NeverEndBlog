package com.neverend.blog.contoller.admin;

import com.google.gson.Gson;
import com.neverend.blog.moudel.UploadFileMsg;
import com.neverend.blog.service.UploadService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zcj
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    //    https://ckeditor.com/docs/ckeditor4/latest/guide/dev_file_upload.html
    @Autowired
    private UploadService uploadService;

    @ApiOperation(value = "上传图片", httpMethod = " POST",
            notes = "富文本编辑器中上传图片接口，需要管理员权限，或超级管理员", protocols = "http")
    @PostMapping("/file/img")
    @ResponseBody
    public String uploadFileImg(@RequestParam("upload") MultipartFile multipartFile) throws IOException {
        UploadFileMsg uploadimg = uploadService.uploadimg(multipartFile);
        Gson gson = new Gson();
        return gson.toJson(uploadimg);
    }

}
