package com.neverend.blog.contoller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 关于
 */
@Controller
public class GuanYu {
    /**
     * 关于
     * @return
     */
    @GetMapping("/gy")
    public String guanYuIndex(){
        return "user/about";
    }
}
