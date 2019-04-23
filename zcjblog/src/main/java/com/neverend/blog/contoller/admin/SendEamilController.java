package com.neverend.blog.contoller.admin;

import com.google.gson.Gson;
import com.neverend.blog.entity.AdminEmail;
import com.neverend.blog.entity.EmaiSend;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.util.email.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 发送邮件
 * @author zcj
 */
@Controller
@RequestMapping("/sys")
public class SendEamilController {

    @Autowired
    private MailService mailService;

    @PostMapping("/send/eamil")
    public String sendEmail(@RequestParam(name = "adminEmail") AdminEmail adminEmail,
                            @RequestParam(name = "emaiSend") EmaiSend emaiSend,
                            @RequestParam(name = "shouJianren")  String shouJianren ){
       Msg msg = mailService.sendEmails(adminEmail,emaiSend,shouJianren);
        Gson gson = new Gson();
       return gson.toJson(msg);

    }

}
