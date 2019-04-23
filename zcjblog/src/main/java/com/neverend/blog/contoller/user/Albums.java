package com.neverend.blog.contoller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 相册
 * @author zcg
 */
@Controller
@RequestMapping("/album")
public class Albums {
    /**
     * 相册
     * @return
     */
    @GetMapping("/index")
    public  String albumsIndex(){
        return "user/album";
    }
}
