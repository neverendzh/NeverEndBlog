package com.neverend.blog.contoller.user;

import com.github.pagehelper.PageInfo;
import com.neverend.blog.entity.Article;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return "user/index";
    }

    /**
     * 文章排行
     * @param pageStart
     * @param pageNum
     * @return
     */
    @GetMapping("/index/articlesHort")
    @ResponseBody
    public Msg indexArticle(@RequestParam(name = "pageStart",defaultValue = "1")Integer pageStart,@RequestParam(name = "pageNum",defaultValue = "5") Integer pageNum){
        PageInfo<Article> articleList = articleService.getArticleHortAsc(pageStart,pageNum);
        Msg msg = articleService.getArticleMsg(articleList);
        return msg;
    }

    /**
     * 文章排行
     * @param pageStart
     * @param pageNum
     * @return
     */
    @GetMapping("/index/articlesHort/fenlei")
    @ResponseBody
    public Msg getArtilceFeiL(@RequestParam(name = "artilceid")String artilceid,
                              @RequestParam(name = "pageStart",defaultValue = "1")Integer pageStart,
                              @RequestParam(name = "pageNum",defaultValue = "5") Integer pageNum,
                              @RequestParam(name = "state",defaultValue = "0")String state){
        Msg msg = articleService.getArtilceFeiL(artilceid,pageStart,pageNum,state);
        return msg;
    }

    @GetMapping("/index/search")
    @ResponseBody
    public Msg search(@RequestParam(name = "searchname")String searchname,
                              @RequestParam(name = "pageStart",defaultValue = "1")Integer pageStart,
                              @RequestParam(name = "pageNum",defaultValue = "5") Integer pageNum,
                              @RequestParam(name = "state",defaultValue = "0")String state){
        Msg msg = articleService.getArtilcesearch(searchname,pageStart,pageNum,state);
        return msg;
    }
}
