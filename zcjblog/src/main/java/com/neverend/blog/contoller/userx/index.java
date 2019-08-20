package com.neverend.blog.contoller.userx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class index {
    @GetMapping("xi")
    public String index(){
        return "userx/index";
    }
}
