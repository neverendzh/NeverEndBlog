package com.neverend.blog.contoller.user;

import com.google.gson.Gson;
import com.neverend.blog.entity.Account;
import com.neverend.blog.moudel.Code;
import com.neverend.blog.moudel.LanMuUi;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.AccountService;
import com.neverend.blog.service.SuperLanMuService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 用户首页
 *
 * @author zcj
 */
@Controller
public class IndexUser {
    @Autowired
    private AccountService accountService;
    @Autowired
    private SuperLanMuService superLanMuService;

    /**
     * 首页默认登录
     *
     * @param accountMobile
     * @param password
     * @param rememberMe
     * @param request
     * @param redirectAttributes
     * @return
     */
    @ApiOperation(value = "首页默认登陆接口", httpMethod = "GET",
            notes = "首页默认登陆返回首页", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accountMobile", value = "账号", defaultValue = "123",
                    required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "123",
                    required = false, dataType = "String", paramType = "query")})
    @GetMapping("/")
    public String index(@RequestParam(name = "accountMobile", defaultValue = "123", required = false) String accountMobile,
                        @RequestParam(name = "password", defaultValue = "123", required = false) String password,
                        String rememberMe,
                        HttpServletRequest request,
                        RedirectAttributes redirectAttributes) {
        // 创建Subject对象
        Subject subject = SecurityUtils.getSubject();
        Account accountend = (Account) subject.getPrincipal();
        if (accountend != null) {
            return "redirect:/user/index";
        } else {
            // 根据账号和密码进行登录
            String requestIp = request.getRemoteAddr();
            UsernamePasswordToken usernamePasswordToken =
                    new UsernamePasswordToken(accountMobile, DigestUtils.md5Hex(password), rememberMe != null, requestIp);
            try {
                subject.login(usernamePasswordToken);
                //登录后跳转目标的判断
                SavedRequest savedRequest = WebUtils.getSavedRequest(request);
                String url = "/user/index";
                if (savedRequest != null) {
                    url = savedRequest.getRequestUrl();
                }
                return "redirect:" + url;
            } catch (UnknownAccountException | IncorrectCredentialsException ex) {
                ex.printStackTrace();
                redirectAttributes.addFlashAttribute("message", "账号或密码错误");
            } catch (LockedAccountException ex) {
                ex.printStackTrace();
                redirectAttributes.addFlashAttribute("message", "账号被锁定");
            } catch (AuthenticationException ex) {
                ex.printStackTrace();
                redirectAttributes.addFlashAttribute("message", "账号或密码错误");
            }
            return "redirect:/";
        }

    }

    /**
     * 首页默认登录
     *
     * @param accountMobile
     * @param password
     * @param rememberMe
     * @param request
     * @param redirectAttributes
     * @return
     */
    @ApiOperation(value = "首页默认登陆接口", httpMethod = "POST",
            notes = "首页默认登陆返回首页", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accountMobile", value = "账号", defaultValue = "",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "",
                    required = true, dataType = "String", paramType = "query")})
    @PostMapping("/")
    @ResponseBody
    public Msg indexPost(@RequestParam(name = "accountMobile", required = true) String accountMobile,
                            @RequestParam(name = "password", required = true) String password,
                            String rememberMe,
                            HttpServletRequest request,
                            RedirectAttributes redirectAttributes) {
        // 创建Subject对象
        Subject subject = SecurityUtils.getSubject();
        // 根据账号和密码进行登录
        String requestIp = request.getRemoteAddr();
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(accountMobile, DigestUtils.md5Hex(password), rememberMe != null, requestIp);
        Msg msg = new Msg();
        try {
            subject.login(usernamePasswordToken);
            //登录后跳转目标的判断
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            String url = "/user/index";
            if (savedRequest != null) {
                url = savedRequest.getRequestUrl();
            }
            msg.setCode(Code.sucess);
            msg.setMsg(Code.sucessMsg);
            msg.setUrl(url);
            return msg;
        } catch (UnknownAccountException | IncorrectCredentialsException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "账号或密码错误");
        } catch (LockedAccountException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "账号被锁定");
        } catch (AuthenticationException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "账号或密码错误");
        }
        msg.setCode(Code.loginAgin);
        msg.setMsg(Code.loginAginMsg);
        msg.setUrl("/");
        return msg;
    }


    /**
     * 首页头部栏目
     *
     * @param topName
     * @return json
     */
    @ApiOperation(value = "博客首页头部栏目", httpMethod = "POST",
            notes = "就是博客首页的导航栏标题", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topName", value = "设置是加载头部标题",
                    defaultValue = "首页头部",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "state", value = "菜单状态，flase加载可用菜单，true加载不可用菜单，null加载所有菜单",
                    defaultValue = "false",
                    required = true, dataType = "String", paramType = "query")})
    @ResponseBody
    @PostMapping("/lan/mu/top")
    public Msg<List<LanMuUi>> indexLanMuTop(@RequestParam(name = "topName", defaultValue = "首页头部", required = false) String topName,
                                            @RequestParam(name = "state", defaultValue = "false", required = false) String state) {
        // 创建Subject对象
        Subject subject = SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();
        List<LanMuUi> lanMuUis = superLanMuService.getLanMus(account, topName.trim(), state);
        Msg msg = new Msg();
        msg.setData(lanMuUis);
        msg.setCode(Code.sucess);
        msg.setMsg(Code.sucessMsg);
        return msg;
    }

    /**
     * 首页尾部栏目
     *
     * @param bName
     * @return json
     */
    @ApiOperation(value = "首页尾部栏目", httpMethod = "POST",
            notes = "首页尾部栏目导航标题", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bName", value = "设置是加载底部标题",
                    defaultValue = "首页尾部",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "state", value = "菜单状态，flase加载可用菜单，true加载不可用菜单，null加载所有菜单",
                    defaultValue = "false",
                    required = true, dataType = "String", paramType = "query")})
    @ResponseBody
    @PostMapping("/lan/mu/boom")
    public Msg<List<LanMuUi>> indexLanMuBottom(@RequestParam(name = "bName", defaultValue = "首页尾部", required = false) String bName,
                                               @RequestParam(name = "state", defaultValue = "false", required = false) String state) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Account account = (Account) session.getAttribute("account");
        List<LanMuUi> lanMus = superLanMuService.getLanMus(account, bName, state);
        Msg msg = new Msg();
        msg.setData(lanMus);
        msg.setCode(Code.sucess);
        msg.setMsg(Code.sucessMsg);
        return msg;
    }
}
