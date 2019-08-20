package com.neverend.blog.contoller.user;

import com.github.pagehelper.PageInfo;
import com.neverend.blog.entity.Article;
import com.neverend.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zcg
 */
@Controller
@RequestMapping("/user")
public class User {
    @Autowired
    private ArticleService articleService;
    /**
     * 首页
     * @return
     */
    @GetMapping("/index")
    public String index(HttpServletRequest request){
        PageInfo<Article> articleList = articleService.getArticleHortAsc(1,10);
        request.setAttribute("PageInfoList",articleList);
        return "user/index";
    }



}
