package com.neverend.blog.contoller.user;

import com.github.pagehelper.PageInfo;
import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.Article;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.ArticleService;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DevicePlatform;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class UserController {
    @Autowired
    private ArticleService articleService;


    @ApiOperation(value = "置顶推荐文章列表", httpMethod = "GET",
            notes = "可以选择性传递文章级别经行推荐，默认是最高界别值为4", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageStart", value = "第几页", defaultValue = "1",
                    required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "每页数量", defaultValue = "5",
                    required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "levelNum", value = "推荐文章级别,数值范围(0-4),如果传递值在正常范围内则查询当前级别，根据流量次数排序，否则根据级别,浏览次数倒序返回", defaultValue = "4",
                    required = false, dataType = "String", paramType = "query")})
    @GetMapping("/index/articlelevel")
    @ResponseBody
    public Msg<List<Article>> getarticleleveljson
            (@RequestParam(name = "levelNum", defaultValue = "4", required = false) String levelNum,
             @RequestParam(name = "pageStart", defaultValue = "1") Integer pageStart,
             @RequestParam(name = "pageNum", defaultValue = "5") Integer pageNum,Device device) {
        return articleService.getarticlelevel(levelNum,pageStart,pageNum);
    }

    /**
     * 首页
     *
     * @return
     */
    @GetMapping("/index")
    @ApiIgnore
    public String index(HttpServletRequest request, Model model) {
        return "user/index";
    }

    /**
     * 博客首页展示文章内容排序
     * 文章排行
     *
     * @param pageStart
     * @param pageNum
     * @return
     */
    @ApiOperation(value = "博客首页展示文章内容排序", httpMethod = "GET",
            notes = "根据热度排序", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageStart", value = "第几页", defaultValue = "1",
                    required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "每页数量", defaultValue = "5",
                    required = true, dataType = "Integer", paramType = "query")})
    @GetMapping("/index/articlesHort")
    @ResponseBody
    public Msg<List<Article>> indexArticlejson(@RequestParam(name = "pageStart", defaultValue = "1") Integer pageStart,
                                           @RequestParam(name = "pageNum", defaultValue = "5") Integer pageNum,
                                               Device device) {
        PageInfo<Article> articleList = articleService.getArticleHortAsc(pageStart, pageNum);
        Msg msg = articleService.getArticleMsg(articleList);
        return msg;
    }

    /**
     * 文章点记率排行
     *
     * @param pageStart
     * @param pageNum
     * @return
     */
    @ApiOperation(value = "查询隶属当前传入文章分类id下的所有文章", httpMethod = "GET",
            notes = "根据点击率排序", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "artilceid", value = "文章分类id",
                    required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageStart", value = "第几页", defaultValue = "1",
                    required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "每页数量", defaultValue = "5",
                    required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "state", value = "文章状态;" + "-1编辑状态;" +
                    "0已发布，可用;" +
                    "1禁止普通用户查看;" +
                    "2删除", defaultValue = "0",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "artilceids", value = "文章id数组",
                    required = false,  allowMultiple = true,paramType = "query"),})
    @GetMapping("/index/articlesHort/fenlei")
    @ResponseBody
    public Msg<List<Article>> getArtilceFeiLjson(@RequestParam(name = "artilceid",required = false) String artilceid,
                                             @RequestParam(name = "pageStart", defaultValue = "1") Integer pageStart,
                                             @RequestParam(name = "pageNum", defaultValue = "5") Integer pageNum,
                                             @RequestParam(name = "state", defaultValue = "0") String state,
                                                 @RequestParam(name = "artilceids",required = false) String[] artilceids,
            Device device) {
        Msg<List<Article>> msg = articleService.getArtilceFeiL(artilceid, pageStart, pageNum, state,artilceids);
        return msg;
    }

    /**
     * 根据关键字搜索文章
     *
     * @param searchname
     * @param pageStart
     * @param pageNum
     * @param state
     * @return
     */
    @ApiOperation(value = "根据关键字搜索文章", httpMethod = "GET",
            notes = "根据关键字搜索文章", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchname", value = "搜索名称",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageStart", value = "第几页", defaultValue = "1",
                    required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "每页数量", defaultValue = "5",
                    required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "state", value = "文章状态;" + "-1编辑状态;" +
                    "0已发布，可用;" +
                    "1禁止普通用户查看;" +
                    "2删除", defaultValue = "0",
                    required = true, dataType = "String", paramType = "query")})
    @GetMapping("/index/search")
    @ResponseBody
    public Msg<List<Article>> searchjson(@RequestParam(name = "searchname") String searchname,
                                     @RequestParam(name = "pageStart", defaultValue = "1") Integer pageStart,
                                     @RequestParam(name = "pageNum", defaultValue = "5") Integer pageNum,
                                     @RequestParam(name = "state", defaultValue = "0") String state, Device device) {
        Msg msg = articleService.getArtilcesearch(searchname, pageStart, pageNum, state);
        return msg;
    }
}
