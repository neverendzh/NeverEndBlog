package com.neverend.blog.contoller.admin;

import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zcj
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

   @RequestMapping("/file/img")
   @ResponseBody
  public String uploadFileImg(){

//       TODO 文件上传方法
       String msg = "{\n" +
               "    \"uploaded\": 1,\n" +
               "    \"fileName\": \"foo.jpg\",\n" +
               "    \"url\": \"/static/res/img/banner.jpg\"\n" +
               "}";
     return msg;
  }

}
