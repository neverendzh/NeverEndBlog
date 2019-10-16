package com.neverend.blog.contoller.AdminUserPublic;

import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.Article;
import com.neverend.blog.entity.SuperArticleSort;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.moudel.PageMsg;
import com.neverend.blog.service.SuperArticleSortService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class YiFaBuWenZh {

    @Autowired
    private SuperArticleSortService superArticleSortService;

    @ApiOperation(value = "查看当前用户文章分类", httpMethod = "GET",
            notes = "根据登陆用户查看", protocols = "http")
    @GetMapping("/u/f/f/b/t")
    public Msg<SuperArticleSort> getFenLeijson(Device device){
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        Msg msg = superArticleSortService.getUfbWzFl(account);
        return msg;
    }

    @ApiOperation(value = "查看当前用户文章分类下的文章", httpMethod = "GET",
            notes = "根据文章分类，用户，名称分类查看", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "分类名称",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageStart", value = "第几页", defaultValue = "1",
                    required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "每页数量", defaultValue = "10",
                    required = false, dataType = "Integer", paramType = "query")})
    @GetMapping("/u/f/f/b/t/wzs")
    public Msg<PageMsg<Article>> getFenLeiWzjson(Device device, @RequestParam(name = "name") String name,
                                                 @RequestParam(name = "pageStart",defaultValue = "1",required = false) Integer pageNum,
                                                 @RequestParam(name = "pageNum",defaultValue = "10",required = false) Integer pageSize){
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        Msg msg = superArticleSortService.getUfbWzFlWzVue(account,name,pageNum,pageSize);
        return msg;
    }

    @ApiIgnore
    @Deprecated
    @GetMapping("/u/f/f/b/t/wzs/web")
    public Msg<Article> getFenLeiWzjsonWeb(Device device, @RequestParam(name = "name") String name,
                                                 @RequestParam(name = "page",defaultValue = "1",required = false) Integer pageNum,
                                                 @RequestParam(name = "limit",defaultValue = "10",required = false) Integer pageSize){
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        Msg msg = superArticleSortService.getUfbWzFlWz(account,name,pageNum,pageSize);
        return msg;
    }
}
