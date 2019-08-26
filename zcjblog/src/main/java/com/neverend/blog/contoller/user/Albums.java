package com.neverend.blog.contoller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 留言
 * @author zcg
 */
@Controller
@RequestMapping("/album")
@ApiIgnore
public class Albums {
    /**
     * 留言
     * @return
     */
    @GetMapping("/index")
    public  String albumsIndex(){
        return "user/liuyan";
    }
}
