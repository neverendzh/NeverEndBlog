package com.neverend.blog.contoller.admin;

import com.google.gson.Gson;
import com.neverend.blog.moudel.UploadFileMsg;
import com.neverend.blog.service.UploadService;
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

    @PostMapping("/file/img")
    @ResponseBody
    public String uploadFileImg(@RequestParam("upload") MultipartFile multipartFile) throws IOException {
        UploadFileMsg uploadimg = uploadService.uploadimg(multipartFile);
        Gson gson = new Gson();
        return gson.toJson(uploadimg);
    }

}
