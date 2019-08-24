package com.neverend.blog.contoller.user;

import com.github.pagehelper.PageInfo;
import com.neverend.blog.entity.Article;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.ArticleService;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zcg
 */
@Api(value = "博客首页加载内容的请求地址都位于user请求路径下")
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
    @ApiIgnore
    public String index(HttpServletRequest request){
        return "user/index";
    }

    /**
     * 博客首页展示文章内容排序
     * 文章排行
     * @param pageStart
     * @param pageNum
     * @return
     */
    @ApiOperation(value="博客首页展示文章内容排序",httpMethod = "GET",
            notes="根据热度排序",protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageStart", value = "第几页", defaultValue = "1",
                    required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "每页数量",defaultValue = "5",
                    required = true, dataType = "Integer",paramType = "query")})
    @GetMapping("/index/articlesHort")
    @ResponseBody
    public Msg<List<Article>> indexArticle(@RequestParam(name = "pageStart",defaultValue = "1")Integer pageStart,
                            @RequestParam(name = "pageNum",defaultValue = "5") Integer pageNum){
        PageInfo<Article> articleList = articleService.getArticleHortAsc(pageStart,pageNum);
        Msg msg = articleService.getArticleMsg(articleList);
        return msg;
    }

    /**
     * 文章点记率排行
     * @param pageStart
     * @param pageNum
     * @return
     */
    @ApiOperation(value="查询隶属当前传入文章分类id下的所有文章",httpMethod = "GET",
            notes="根据点击率排序",protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "artilceid", value = "文章分类id",
                    required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pageStart", value = "第几页", defaultValue = "1",
                    required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "每页数量",defaultValue = "5",
                    required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "state", value = "文章状态;" + "-1编辑状态;" +
                    "0已发布，可用;" +
                    "1禁止普通用户查看;" +
                    "2删除",defaultValue = "0",
                    required = true, dataType = "String",paramType = "query")})
    @GetMapping("/index/articlesHort/fenlei")
    @ResponseBody
    public  Msg<List<Article>>  getArtilceFeiL(@RequestParam(name = "artilceid")String artilceid,
                              @RequestParam(name = "pageStart",defaultValue = "1")Integer pageStart,
                              @RequestParam(name = "pageNum",defaultValue = "5") Integer pageNum,
                              @RequestParam(name = "state",defaultValue = "0")String state){
        Msg<List<Article>>  msg = articleService.getArtilceFeiL(artilceid,pageStart,pageNum,state);
        return msg;
    }

    /**
     * 根据关键字搜索文章
     * @param searchname
     * @param pageStart
     * @param pageNum
     * @param state
     * @return
     */
    @ApiOperation(value="根据关键字搜索文章",httpMethod = "GET",
            notes="根据关键字搜索文章",protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchname", value = "搜索名称",
                    required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pageStart", value = "第几页", defaultValue = "1",
                    required = false, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "每页数量",defaultValue = "5",
                    required = false, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "state", value = "文章状态;" + "-1编辑状态;" +
                    "0已发布，可用;" +
                    "1禁止普通用户查看;" +
                    "2删除",defaultValue = "0",
                    required = true, dataType = "String",paramType = "query")})
    @GetMapping("/index/search")
    @ResponseBody
    public Msg<List<Article>> search(@RequestParam(name = "searchname")String searchname,
                              @RequestParam(name = "pageStart",defaultValue = "1")Integer pageStart,
                              @RequestParam(name = "pageNum",defaultValue = "5") Integer pageNum,
                              @RequestParam(name = "state",defaultValue = "0")String state){
        Msg msg = articleService.getArtilcesearch(searchname,pageStart,pageNum,state);
        return msg;
    }
}
