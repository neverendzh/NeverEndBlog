package com.neverend.blog.contoller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 最新文章
 * @author zcj
 */
@Controller
@RequestMapping("/new")
public class NewRelease {

    /**
     * 最新文章
     * @return
     */
    @GetMapping("/rel/index")
    public String NewReleaseIndex(){
         return "user/whisper";
    }



}
