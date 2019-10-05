package com.neverend.blog.contoller.user.msg;

import com.neverend.blog.entity.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class usermsg {
    @GetMapping("/user/msg")
    public String getmsg(Model model){
        Account subject = (Account) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("account",subject);
        return "user/usermsg";
    }
}
