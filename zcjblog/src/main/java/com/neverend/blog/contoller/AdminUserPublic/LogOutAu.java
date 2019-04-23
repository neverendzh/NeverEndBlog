package com.neverend.blog.contoller.AdminUserPublic;

import com.neverend.blog.entity.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zcg
 */
@Controller
@RequestMapping("/system")
public class LogOutAu {

    @GetMapping("/logout")
    public String logOut( HttpServletRequest request,
                          RedirectAttributes redirectAttributes){
        // 创建Subject对象
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        //将登录成功的对象放入session（没必要）
        Session session = subject.getSession();
        session.removeAttribute("account");
        return "redirect:/";
    }

}
