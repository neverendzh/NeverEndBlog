package com.neverend.blog.contoller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zcg
 */
@Controller
@RequestMapping("/user")
public class User {
    /**
     * 首页
     * @return
     */
    @GetMapping("/index")
    public String index(){
        return "user/index";
    }



}
