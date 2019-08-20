package com.neverend.blog.contoller.user;

import com.google.gson.Gson;
import com.neverend.blog.entity.Account;
import com.neverend.blog.moudel.LanMuUi;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.AccountService;
import com.neverend.blog.service.SuperLanMuService;
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
 * �û���ҳ
 * @author zcj
 */
@Controller
public class IndexUser {
    @Autowired
    private AccountService accountService;
    @Autowired
    private SuperLanMuService superLanMuService;

    /**
     * ��ҳĬ�ϵ�¼
     * @param accountMobile
     * @param password
     * @param rememberMe
     * @param request
     * @param redirectAttributes
     * @return
     */
    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "123", required = false) String accountMobile,
                        @RequestParam(defaultValue = "123", required = false) String password,
                        String rememberMe,
                        HttpServletRequest request,
                        RedirectAttributes redirectAttributes) {
        // ����Subject����
        Subject subject = SecurityUtils.getSubject();
        // �����˺ź�������е�¼
        String requestIp = request.getRemoteAddr();
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(accountMobile, DigestUtils.md5Hex(password), rememberMe != null, requestIp);
        try {
            subject.login(usernamePasswordToken);

            //����¼�ɹ��Ķ������session��û��Ҫ��
            Account account = accountService.findByMobile(accountMobile);
            Session session = subject.getSession();
            session.setAttribute("account", account);

            //��¼����תĿ����ж�
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            String url = "/user/index";
            if (savedRequest != null) {
                url = savedRequest.getRequestUrl();
            }
            return "redirect:" + url;
        } catch (UnknownAccountException | IncorrectCredentialsException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "�˺Ż��������");
        } catch (LockedAccountException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "�˺ű�����");
        } catch (AuthenticationException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "�˺Ż��������");
        }
        return "redirect:/";
    }

    /**
     * ��ҳĬ�ϵ�¼
     * @param accountMobile
     * @param password
     * @param rememberMe
     * @param request
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/")
    @ResponseBody
    public String indexPost(@RequestParam(defaultValue = "123",name = "accountMobile",required = false) String accountMobile,
                        @RequestParam(defaultValue = "123",name = "password",required = false) String password,
                        String rememberMe,
                        HttpServletRequest request,
                        RedirectAttributes redirectAttributes) {
        // ����Subject����
        Subject subject = SecurityUtils.getSubject();
        // �����˺ź�������е�¼
        String requestIp = request.getRemoteAddr();
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(accountMobile, DigestUtils.md5Hex(password), rememberMe != null, requestIp);
        Msg msg = new Msg();
        Gson gson = new Gson();
        try {
            subject.login(usernamePasswordToken);

            //����¼�ɹ��Ķ������session��û��Ҫ��
            Account account = accountService.findByMobile(accountMobile);
            Session session = subject.getSession();
            session.setAttribute("account", account);

            //��¼����תĿ����ж�
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            String url = "/user/index";
            if (savedRequest != null) {
                url = savedRequest.getRequestUrl();
            }
            msg.setCode("0");
            msg.setUrl(url);
            return gson.toJson(msg);
        } catch (UnknownAccountException | IncorrectCredentialsException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "�˺Ż��������");
        } catch (LockedAccountException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "�˺ű�����");
        } catch (AuthenticationException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "�˺Ż��������");
        }
        msg.setCode("1");
        msg.setUrl("/");
        return gson.toJson(msg);
    }


    /**
     * ��ҳͷ����Ŀ
     * @param topName
     * @return json
     *
     */
    @ResponseBody
    @PostMapping("/lan/mu/top")
    public String indexLanMuTop(@RequestParam(name = "topName", defaultValue = "��ҳͷ��",required = false) String topName) {
        // ����Subject����
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Account account = (Account) session.getAttribute("account");
        Gson gson = new Gson();
        List<LanMuUi> lanMuUis = superLanMuService.getLanMus(account,topName.trim());
        return gson.toJson(lanMuUis);
    }

    /**
     * ��ҳβ����Ŀ
     * @param bName
     * @return json
     */
    @ResponseBody
    @PostMapping("/lan/mu/boom")
    public String indexLanMuBottom(@RequestParam(name = "bName", defaultValue = "��ҳβ��",required = false) String bName) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Account account = (Account) session.getAttribute("account");
        Gson gson = new Gson();
        return gson.toJson(superLanMuService.getLanMus(account,bName));
    }
}
