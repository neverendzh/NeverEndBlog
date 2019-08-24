package com.neverend.blog.contoller.admin;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.SuperArticleSort;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.moudel.NumSize;
import com.neverend.blog.service.SuperArticleSortService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

/**
 * 文章管理
 * 分类管理
 *
 * @author zcj
 */
@Controller
@RequestMapping("/system")
public class ArticleClassification {
    @Autowired
    private SuperArticleSortService superArticleSortService;


    /**
     * 查询前分类层级的“下级”层级分类
     *
     * @param request
     * @param type
     * @return
     */
    @ApiOperation(value = "查询前分类层级的“下级”层级分类", httpMethod = "GET",
            notes = "根据当前Type字段值查询当前层级的下层的所有同级分类", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "表示在树节点中属于第几层节点，默认从0开始",
                    required = true, defaultValue = "0", dataType = "String", paramType = "query")})
    @GetMapping("/calss/ifcation/type")
    @ResponseBody
    public Msg<List<SuperArticleSort>> AddArticleType(HttpServletRequest request, @RequestParam(name = "type", defaultValue = "0") String type) {
        Msg msg = superArticleSortService.getType(type);
        return msg;
    }


    @GetMapping("/articles/classification")
    @ApiIgnore
    public String AddArticleClassification(HttpServletRequest request) {
        return "admin/classification";
    }

    /**
     * 查询分类信息菜单
     *
     * @param type
     * @param pageStart
     * @param pageNum
     * @param request
     * @return
     */
    @ApiOperation(value = "文章分类层级信息", httpMethod = "GET",
            notes = "根据type字段查询分类信息", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "表示在树节点中属于第几层节点，默认从0开始",
                    required = true, defaultValue = "0", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageStart", value = "第几页", defaultValue = "1",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "每页数量", defaultValue = "5",
                    required = true, dataType = "String", paramType = "query")})
    @GetMapping("/articles/classification/all/Articles")
    @ResponseBody
    public Msg<List<SuperArticleSort>> AddArticleClassificationJson(
            @RequestParam(name = "type", defaultValue = "0") String type,
            @RequestParam(name = "pageStart", defaultValue = "1") String pageStart,
            @RequestParam(value = "pageNum", defaultValue = "10") String pageNum,
            HttpServletRequest request) {
        PageInfo<SuperArticleSort> superArticleSortList = superArticleSortService.getSuperArticleSorts(pageStart, pageNum, type);
        Msg msg = new Msg();
        msg.setCode("0");
        msg.setMsg("sucess");
        msg.setData(superArticleSortList.getList());
        msg.setCount(superArticleSortList.getList().size() + "");
        return msg;
    }

    /**
     * 共有几级分类
     *
     * @return
     */
    @ApiOperation(value = "共有几级分类", httpMethod = "POST",
            notes = "查询在树节点中共有几个层级的分类", protocols = "http")
    @PostMapping("/articles/classification/types/num")
    @ResponseBody
    public Msg<NumSize> getClsssType() {
        Msg msg = superArticleSortService.getClassType();
        return msg;
    }

    /**
     * 添加分类
     *
     * @param name
     * @param type
     * @param request
     * @return
     */
    @ApiOperation(value = "添加分类", httpMethod = "POST",
            notes = "通过选择父级节点，把新增的节点添加到父级节点下边", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "上级分类id和当前分类的树形关系；k表示分隔符；例如" +
                    "1565172980628K1565172980628-1565172980628-;superArticleSortId k beiYongEr",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "分类名称",
                    required = true, dataType = "String", paramType = "query")})
    @PostMapping("/calss/ifcation/add")
    @ResponseBody
    public Msg andArticleClass(@RequestParam(name = "name") String name,
                               @RequestParam(name = "type") String type,
                               HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        Msg msg = superArticleSortService.addAtricle(name, type, account);
        return msg;
    }

    /**
     * 修改分类
     *
     * @param name
     * @param articleId
     * @param request
     * @return
     */
    @ApiOperation(value = "修改分类名称", httpMethod = "POST",
            notes = "修改分类名称,传入的 articleId 是当前选择的分类的唯一id", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "分类名称",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "articleId", value = "分类名称唯一id",
                    required = true, dataType = "String", paramType = "query")})

    @PostMapping("/calss/ifcation/edit")
    @ResponseBody
    public Msg editArticleClass(@RequestParam(name = "name") String name,
                                @RequestParam(name = "articleId") String articleId,
                                HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        Msg msg = superArticleSortService.editAtricle(name, account, articleId);
        return msg;
    }

    /**
     * 删除分类
     *
     * @param articleId
     * @param request
     * @return
     */
    @ApiOperation(value = "删除分类", httpMethod = "POST",
            notes = "删除分类名称,传入的 articleId 是当前分类的唯一id", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "分类名称唯一id",
                    required = true, dataType = "String", paramType = "query")})
    @PostMapping("/calss/ifcation/remove")
    @ResponseBody
    public Msg romoveArticleClass(@RequestParam(name = "articleId") String articleId,
                                  HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        Msg msg = superArticleSortService.removeAtricle(account, articleId);
        return msg;
    }

    /**
     * 锁定菜单
     *
     * @param type
     * @param articleId
     * @param request
     * @return
     */
    @ApiOperation(value = "锁定分类", httpMethod = "POST",
            notes = "搜定分类后该分类下文章不可查看，该分类在用户界面不可见", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "忘记了啥意思，卧槽，真尴尬，现在只能设置0。",
                    required = true, dataType = "String", paramType = "query",defaultValue = "0"),
            @ApiImplicitParam(name = "articleId", value = "锁定分类的id",
                    required = true, dataType = "String", paramType = "query")
            , @ApiImplicitParam(name = "isLock", value = "锁定状态 true false",
            required = true, dataType = "String", paramType = "query")})
    @PostMapping("/calss/ifcation/lock")
    @ResponseBody
    public Msg romoveArticleLock(@RequestParam(name = "type") String type,
                                 @RequestParam(name = "articleId") String articleId,
                                 @RequestParam(name = "isLock") String isLock,
                                 HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        Msg msg = superArticleSortService.removeAtricleLock(type, account, articleId, isLock);
        return msg;
    }
}
