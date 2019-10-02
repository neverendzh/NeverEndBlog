package com.neverend.blog.service.weixin;

public interface WeiXinService {
    /**
     * 发送文本消息
     * @param o
     * @return
     */
    Object sendTextMsg(Object o);

    /**
     * 处理企业微信中接收的消息
     * @param msg_signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    String handleWeiXinMsg(String msg_signature, String timestamp, String nonce, String echostr);

}
