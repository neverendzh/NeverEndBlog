package com.neverend.blog.service.weixin.impl;

import com.neverend.blog.service.weixin.WeiXinService;
import com.neverend.blog.util.email.weixin.AesException;
import com.neverend.blog.util.email.weixin.WXBizMsgCrypt;
import com.neverend.blog.util.email.weixin.WeiXinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Service
public class WeiXinServiceImpl implements WeiXinService {

    @Autowired
    private WeiXinUtil weiXinUtil;

    /**
     * 发送文本消息
     *
     * @param o
     * @return
     */
    @Override
    public Object sendTextMsg(Object o) {
        String s = o.toString();
        int bufenUser = weiXinUtil.getBufenUser(s);
        return bufenUser;
    }

    @Override
    public String handleWeiXinMsg(String msg_signature, String timestamp, String nonce, String echostr) {
        try {
            System.out.println("ABCDEFG:"+msg_signature);
            String sToken = "q2Oiq3QGTpebCT";
            String sCorpID = "wwcfe718794b798a88";
            String sEncodingAESKey = "WrxtzXSt4qjz33za6mtMPiZSVIHPQuAYeYVLWYwJznH";
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
            echostr = URLDecoder.decode(echostr,"UTF-8");
            String sechostr = wxcpt.VerifyURL(msg_signature, timestamp,
                    nonce, echostr);

            System.out.println("decode" + sechostr);
            return sechostr;
        } catch (AesException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "200";
    }

}
