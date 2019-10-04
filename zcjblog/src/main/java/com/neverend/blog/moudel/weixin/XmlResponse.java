
package com.neverend.blog.moudel.weixin;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 在企业微信中点击处理审核事件后被动响应包的数据格式
 */
@JacksonXmlRootElement(localName ="xml")
public class XmlResponse {

    /**
     * 时间戳
     */
    @JacksonXmlProperty(localName = "TimeStamp")
    protected String tTimeStamp;
    /**
     * 消息签名
     */
    @JacksonXmlProperty(localName = "MsgSignature")
    protected String msgSignature;
    /**
     * 经过加密的消息结构体
     */
    @JacksonXmlProperty(localName = "Encrypt")
    protected String encrypt;
    /**
     * 随机数
     */
    @JacksonXmlProperty(localName = "Nonce")
    protected String nonce;

    public String gettTimeStamp() {
        return tTimeStamp;
    }

    public void settTimeStamp(String tTimeStamp) {
        this.tTimeStamp = tTimeStamp;
    }

    public String getMsgSignature() {
        return msgSignature;
    }

    public void setMsgSignature(String msgSignature) {
        this.msgSignature = msgSignature;
    }

    public String getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }
}
