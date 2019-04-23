package com.neverend.blog.contoller.admin;

import com.neverend.blog.entity.Account;
import com.neverend.blog.service.AccountService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/system")
public class IndexAdmin {

    @Autowired
    private AccountService accountService;

    /**
     * 管理员首页
     * @return
     */
    @RequestMapping("/admin/index")
    public String AdminIndex(){
       return "admin/index";
    }


    /**
     * 系统登录页面
     * @return
     */
    @RequestMapping("/admin/login")
    public String  adminLogin(){
        return "admin/login";
    }

    /**
     * 登录方法
     * @param name
     * @param password
     * @param rememberMe
     * @param request
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/login")
    public String AdminLogin(
                             @RequestParam(name = "name") String name,
                             @RequestParam(required = false,name = "password") String password,
                             String rememberMe,
                             HttpServletRequest request,
                             RedirectAttributes redirectAttributes){
        if (name == null || password == null || name.equals("") || password.equals("")){
            return "admin/login";
        }else {
            // 创建Subject对象
            Subject subject = SecurityUtils.getSubject();
            // 根据账号和密码进行登录
            String requestIp = request.getRemoteAddr();
            UsernamePasswordToken usernamePasswordToken =
                    new UsernamePasswordToken(name,DigestUtils.md5Hex(password),rememberMe!=null,requestIp);
            try {
                subject.login(usernamePasswordToken);

                //将登录成功的对象放入session（没必要）
                Account account = accountService.findByMobile(name);
                Session session = subject.getSession();
                session.setAttribute("account",account);

                //登录后跳转目标的判断
                SavedRequest savedRequest = WebUtils.getSavedRequest(request);
                String url = "/system/admin/index";
                if(savedRequest != null) {
                    url = savedRequest.getRequestUrl();
                }

                return "redirect:"+url;
            } catch (UnknownAccountException | IncorrectCredentialsException ex) {
                redirectAttributes.addFlashAttribute("message","账号或密码错误");
            } catch (LockedAccountException ex) {
                redirectAttributes.addFlashAttribute("message","账号被锁定");
            } catch (AuthenticationException ex) {
                redirectAttributes.addFlashAttribute("message","账号或密码错误");
            }
            return "redirect:"+"/system/admin/login";
        }
    }


    /**
     * 系统登录页面
     * @return
     */
    @GetMapping("/login")
    public String AdminLoginGetHtml(){

            return "admin/login";
    }
}
