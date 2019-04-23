package com.neverend.blog.contoller.admin;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.SuperArticleSort;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.SuperArticleSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

/**
 *文章管理
 *分类管理
 * @author zcj
 */
@Controller
@RequestMapping("/system")
public class ArticleClassification {
    @Autowired
    private SuperArticleSortService superArticleSortService;

    @GetMapping("/articles/classification")
    public String AddArticleClassification(HttpServletRequest request){
        return "admin/classification";
    }

    /**
     * 查询分类信息菜单
     * @param type
     * @param page
     * @param limit
     * @param request
     * @return
     */
    @GetMapping("/articles/classification/all/Articles")
    @ResponseBody
    public String AddArticleClassificationJson(
            @RequestParam(name = "type",defaultValue = "0")String type,
            @RequestParam(name = "page",defaultValue = "1")String page,
            @RequestParam(value = "limit",defaultValue = "10") String limit,
            HttpServletRequest request){
        PageInfo<SuperArticleSort> superArticleSortList = superArticleSortService.getSuperArticleSorts(page,limit,type);
        Gson gson = new Gson();
        Msg msg = new Msg();
        msg.setCode("0");
        msg.setMsg("");
        msg.setData(superArticleSortList.getList());
        msg.setCount(superArticleSortList.getTotal()+"");
        return gson.toJson(msg);
    }

    @PostMapping("/articles/classification/types/num")
    @ResponseBody
    public Msg getClsssType(){
        Msg msg =  superArticleSortService.getClassType();
        return msg;
    }

    @PostMapping("/calss/ifcation/add")
    @ResponseBody
    public Msg andArticleClass(@RequestParam(name = "name")String name,@RequestParam(name = "type")String type,
                               HttpServletRequest request){
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        Msg msg = superArticleSortService.addAtricle(name,type,account);
       return msg;
    }

    @PostMapping("/calss/ifcation/edit")
    @ResponseBody
    public Msg editArticleClass(@RequestParam(name = "name")String name,
                                @RequestParam(name = "type")String type,
                               @RequestParam(name = "articleId") String articleId,
                               HttpServletRequest request){
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        Msg msg = superArticleSortService.editAtricle(name,type,account,articleId);
        return msg;
    }

    @PostMapping("/calss/ifcation/remove")
    @ResponseBody
    public Msg romoveArticleClass(@RequestParam(name = "type")String type,
                                  @RequestParam(name = "articleId") String articleId,
                                  HttpServletRequest request){
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        Msg msg = superArticleSortService.removeAtricle(type,account,articleId);
        return msg;
    }

    /**
     *  锁定菜单
     * @param type
     * @param articleId
     * @param request
     * @return
     */
    @PostMapping("/calss/ifcation/lock")
    @ResponseBody
    public Msg romoveArticleLock(@RequestParam(name = "type")String type,
                                  @RequestParam(name = "articleId") String articleId,
                                  @RequestParam(name = "isLock") String isLock,
                                  HttpServletRequest request){
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        Msg msg = superArticleSortService.removeAtricleLock(type,account,articleId,isLock);
        return msg;
    }
}
