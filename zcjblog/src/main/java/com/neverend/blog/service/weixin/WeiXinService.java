package com.neverend.blog.service.weixin;

import com.neverend.blog.moudel.weixin.XmlRequest;

public interface WeiXinService {
    /**
     * 发送文本消息
     * @param o
     * @return
     */
    Object sendTextMsg(Object o);

    /**
     * 处理企业微信中接收的消息
     * @param xmlRequest
     * @return
     */
    String handleWeiXinMsg(XmlRequest xmlRequest,String msg_signature, String timestamp, String nonce);
    String handleWeiXinMsg(String msg_signature, String timestamp, String nonce, String echostr);
}
