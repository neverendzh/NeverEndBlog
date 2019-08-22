package com.neverend.blog.contoller.admin;

import com.google.gson.Gson;
import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.ArticleWithBLOBs;
import com.neverend.blog.moudel.ActicleTree;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.AccountService;
import com.neverend.blog.service.ArticleService;
import com.neverend.blog.service.SuperArticleSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 发布预览文章
 * @author zcj
 */
@Controller
@RequestMapping("/system")
public class FabuBlog {


    @Autowired
    private AccountService accountService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private SuperArticleSortService superArticleSortService;

    /**
     * 预览保存
     * @param articleWithBLOBs
     * @return
     */
    @PostMapping("/yulan")
    @ResponseBody
    public Msg yulanBlog(HttpServletRequest request,ArticleWithBLOBs articleWithBLOBs,
                         @RequestParam(name = "articleSortSuperId") String articleSortId){
        HttpSession httpSession = request.getSession();
        Account account = (Account) httpSession.getAttribute("account");
        Msg msg = articleService.saveArticle(account,articleWithBLOBs,"-1",articleSortId);
        return msg;
    }

    /**
     * 发布文章
     * @param request
     * @param articleWithBLOBs
     * @param articleSortId
     * @return
     */
    @PostMapping("/publish/articles")
    @ResponseBody
    public Msg publishArticle(HttpServletRequest request,ArticleWithBLOBs articleWithBLOBs,
                              @RequestParam(name = "articleSortSuperId") String articleSortId)  {
        HttpSession httpSession = request.getSession();
        Account account = (Account) httpSession.getAttribute("account");
        Msg msg = articleService.saveArticle(account,articleWithBLOBs,"0",articleSortId);
        return msg;
    }
    /**
     * 发布文章页面1
     * @return
     */
  /*  @GetMapping("/admin/fabu/wen")
    public String AdminFabuWenZhang(){
        return "admin/fabu";
    }
*/
    /**
     * 发布文章页面2
     * @return
     */
    @GetMapping("/admin/fabu/wen")
    public String AdminFabuWenZhang(HttpServletRequest request){
        return "admin/indexWenZhang";
    }

    /**
     * 树形分类菜单
     * @param request
     * @return
     */
    @GetMapping("/admin/acticle/tree")
    @ResponseBody
    public Msg treeActicles(HttpServletRequest request){
        Msg msg = superArticleSortService.getClassTypeNameS(true);
        return msg;
    }

    /**
     * 发布文章页面2
     * @return
     */
    @GetMapping("/admin/fabu/yulan")
    public String Yulan(@RequestParam(name = "articleId",required = false) String articleId,HttpServletRequest request){
        ArticleWithBLOBs articleWithBLOBs = articleService.getArticle(articleId);
        request.setAttribute("articelName",articleWithBLOBs.getArticleName());
        request.setAttribute("contextht",articleWithBLOBs.getContext());

        return "admin/yulan";
    }
}
