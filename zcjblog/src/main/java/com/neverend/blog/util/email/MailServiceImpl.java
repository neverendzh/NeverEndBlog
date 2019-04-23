package com.neverend.blog.util.email;

import com.neverend.blog.entity.AdminEmail;
import com.neverend.blog.entity.EmaiSend;
import com.neverend.blog.moudel.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

/**
 * @author zcj
 * @Description: 邮件服务的实现
 */
@Service
public class MailServiceImpl implements MailService {
    private final Logger logger = (Logger)
            LoggerFactory.getLogger(this.getClass());

    @Override
    public void sendSimpleMail() {
        String htmlEmailTemplate ="<html><div>\n" +
                " <a  href=\"https://promotion.aliyun.com/ntms/yunparter/invite.html?userCode=h3re6oo8\"><img src=\"http://127.0.0.1/static/img/yhj.gif\"></a><br/><br/>\n" +
                " <a style=\"font-size: 16px;color:red;\" href=\"https://promotion.aliyun.com/ntms/yunparter/invite.html?userCode=h3re6oo8\">点击领取阿里元代金券</a>\n" +
                " https://promotion.aliyun.com/ntms/yunparter/invite.html?userCode=h3re6oo8<br/>\n" +
                " <a href=\"https://promotion.aliyun.com/ntms/act/enterprise-discount.html?userCode=h3re6oo8\"><img src=\"http://127.0.0.1/static/img/wz.gif\"  style=\"width: 250px;height: 250px;;\"></a><br/><br/>\n" +
                " <a style=\"font-size: 16px;color:red;\" href=\"https://promotion.aliyun.com/ntms/act/enterprise-discount.html?userCode=h3re6oo8\">点击链接高性能服务器五折优惠</a>\n" +
                " https://promotion.aliyun.com/ntms/act/enterprise-discount.html?userCode=h3re6oo8<br/>\n" +
                " <a  href=\"https://promotion.aliyun.com/ntms/act/qwbk.html?userCode=h3re6oo8\"><img  src=\"http://127.0.0.1/static/img/erz.gif\" style=\"width: 250px;height: 250px;;\"></a><br/><br/>\n" +
                " <a style=\"font-size: 16px;color:red;\" href=\"https://promotion.aliyun.com/ntms/act/qwbk.html?userCode=h3re6oo8\">云产品最低二者优惠</a>\n" +
                " https://promotion.aliyun.com/ntms/act/qwbk.html?userCode=h3re6oo8\n" +
                "</div></html>";
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setUsername("1927271161@qq.com");
        sender.setPassword("msxmfusnjvnrgcfg");
//        spring.mail.properties.mail.smtp.ssl.enable=true
//        1927271161@qq.com
        sender.setHost("smtp.qq.com");
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message,true,"UTF-8");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            helper.setSubject("TESTEmail");
            helper.setFrom("1927271161@qq.com","TESTFROMEZCJ");
//            helper.setTo("2545395596@qq.com");
            String [] a = new String[2];
            a[0] = "2545395596@qq.com";
            a[1] = "1743001147@qq.com";
            helper.setTo(a);
            helper.setText(htmlEmailTemplate,true);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        sender.send(message);
    }

    @Override
    public Msg sendSimpleMail(AdminEmail adminEmail, EmaiSend emaiSend) {
        Msg msg = new Msg();
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        // 设置发件人
        sender.setUsername(adminEmail.getEmail());
        // 口令
        sender.setPassword(adminEmail.getPasswordKoLing());
       //  邮箱类型
        sender.setHost("smtp."+adminEmail.getType()+".com");
       // 端口sender.setPort();
        MimeMessage message = sender.createMimeMessage();
        try {
//            设置为true是自动关联发送时的附件
            MimeMessageHelper helper = new MimeMessageHelper(message,true,"UTF-8");
//            邮件主题
            helper.setSubject(emaiSend.getEmailSubject());
//            邮件来自哪里，发件人名称
            helper.setFrom(adminEmail.getEmail(),adminEmail.getName());
//            收件人
            helper.setTo(emaiSend.getRevenueEmailNumber());
//            表示为html编码
            helper.setText(emaiSend.getEmailText(),true);
            sender.send(message);
            msg.setCode("0");
//            发送成功
            return msg;
        } catch (Exception e) {
//            发送失败
            msg.setCode("1");
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 单个邮件发送
     *
     * @param adminEmail 发件人信息
     * @param emaiSend
     * @return
     */
    @Override
    public Msg sendSimpleMails(AdminEmail adminEmail, EmaiSend emaiSend,String shouJianren []) {
        return null;
    }

    /**
     * 邮件群发
     *
     * @param adminEmail  发件人信息
     * @param emaiSend
     * @param shouJianren
     * @return
     * @Param shouJianren 收件人账号字符串
     * @Param emaiSend 邮件内容
     */
    @Override
    public Msg sendEmails(AdminEmail adminEmail, EmaiSend emaiSend, String shouJianren) {
        return null;
    }

}
