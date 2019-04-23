package com.neverend.blog.contoller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 分类文章显示
 * @author zcg
 */
@Controller
@RequestMapping("/Article")
public class Classification {


    @GetMapping("/category/view")
    public String fenLeiArticle(@RequestParam(name = "type",defaultValue = "",required = false)String type){
        System.out.println(type);
        return "user/index";
    }

}
