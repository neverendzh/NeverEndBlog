package com.neverend.blog.util.email;

import com.neverend.blog.entity.AdminEmail;
import com.neverend.blog.entity.EmaiSend;
import com.neverend.blog.moudel.Msg;

/**
 * @author zcj
 *@@Description: 邮件服务的接口
 */
public interface MailService {

    /**
     * 邮件发送接口
     */
    @Deprecated
    void sendSimpleMail();


    /**
     *单个邮件发送
     * @param adminEmail 发件人信息
     * @return
     */
    Msg sendSimpleMail(AdminEmail adminEmail, EmaiSend emaiSend);
    /**
     *邮件群发
     * @param adminEmail 发件人信息
     * @Param shouJianren 收件人账号
     * @Param emaiSend 邮件内容
     * @return
     */
    Msg sendSimpleMails(AdminEmail adminEmail, EmaiSend emaiSend,String shouJianren []);

    /**
     *邮件群发
     * @param adminEmail 发件人信息
     * @Param shouJianren 收件人账号字符串
     * @Param emaiSend 邮件内容
     * @return
     */
    Msg sendEmails(AdminEmail adminEmail, EmaiSend emaiSend,String shouJianren);

}
