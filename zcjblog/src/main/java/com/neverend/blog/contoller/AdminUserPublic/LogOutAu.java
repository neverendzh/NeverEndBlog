package com.neverend.blog.contoller.AdminUserPublic;

import com.neverend.blog.entity.Account;
import com.neverend.blog.moudel.Code;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.util.email.GetMsg;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zcg
 */
@Controller
@RequestMapping("/system")
public class LogOutAu {

    @GetMapping("/logout")
    public String logOut(){
        // 创建Subject对象
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        //将登录成功的对象放入session（没必要）
        Session session = subject.getSession();
        session.removeAttribute("account");
        return "redirect:/";
    }


    @ApiOperation(value = "获取当前登陆对象", httpMethod = "POST",
            notes = "获取当前登陆对象Account", protocols = "http")
    @PostMapping("/get/acount")
    @ResponseBody
    public Msg<Account> getLoginAccount(){
        Subject subject = SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();
        Msg msg = GetMsg.getMsg();
        msg.setCode(Code.sucess);
        msg.setMsg(Code.sucessMsg);
        msg.setData(account);
        return msg;
    }
}
