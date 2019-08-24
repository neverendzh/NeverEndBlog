package com.neverend.blog.contoller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 关于
 */
@Controller
@ApiIgnore
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
