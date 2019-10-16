package com.neverend.blog.contoller.user.userfabu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class fabu {
    @GetMapping("/user/fabus")
    public String fabus(){
        return "user/fabus";
    }
}
