package com.neverend.blog.contoller.admin;

import com.neverend.blog.entity.Article;
import com.neverend.blog.entity.ArticleWithBLOBs;
import com.neverend.blog.moudel.Code;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.moudel.PageMsg;
import com.neverend.blog.service.ArticleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/system")
public class ArticleStateEdit {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/state")
    @ApiIgnore
    public String editstate() {
        return "/admin/articleState/articleStateEdit";
    }

    @GetMapping("/article/state/shenhe")
    @ApiIgnore
    public String editstateshenhe() {
        return "/admin/articleState/shenhe";
    }


    @ApiOperation(value = "文章状态分类", httpMethod = "GET",
            notes = "文章不同分类查看", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "statId", value = "文章状态id",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "第几页", defaultValue = "1",
                    required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页数量", defaultValue = "10",
                    required = true, dataType = "Integer", paramType = "query")})
    @GetMapping("/edit/article/state")
    @ResponseBody
    public Msg<PageMsg<Article>> YulanApijson(@RequestParam(name = "statId", required = true) String statId,
                                              @RequestParam(name = "page", defaultValue = "1") Integer page,
                                              @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                              Device device) {
        Msg msg = articleService.getArticleState(statId, page, limit);

        return msg;
    }


    @PostMapping("/edit/state")
    @ResponseBody
    public Msg editState(@RequestParam(name = "state") String state,
                         @RequestParam(name = "articleID") String articleID,Device device) {
        Msg msg = articleService.editState(state,articleID);
        return msg;
    }
}
