
package com.neverend.blog.moudel.weixin;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 企业微信点击处理审核按钮是接收的xml数据格式
 */
@JacksonXmlRootElement(localName ="xml")
public class XmlRequest {

//  企业微信的CorpID，当为第三方套件回调事件时，CorpID的内容为suiteid
    @JacksonXmlProperty(localName = "ToUserName")
    protected String toUserName;
//    接收的应用id，可在应用的设置页面获取
    @JacksonXmlProperty(localName = "AgentID")
    protected String agentID;
//  消息结构体加密后的字符串
    @JacksonXmlProperty(localName = "Encrypt")
    protected String encrypt;

    /**
     * 获取toUserName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToUserName() {
        return toUserName;
    }

    /**
     * 设置toUserName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToUserName(String value) {
        this.toUserName = value;
    }

    /**
     * 获取agentID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentID() {
        return agentID;
    }

    /**
     * 设置agentID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentID(String value) {
        this.agentID = value;
    }

    /**
     * 获取encrypt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncrypt() {
        return encrypt;
    }

    /**
     * 设置encrypt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncrypt(String value) {
        this.encrypt = value;
    }

    @Override
    public String toString() {
        return "Xml{" +
                "toUserName='" + toUserName + '\'' +
                ", agentID='" + agentID + '\'' +
                ", encrypt='" + encrypt + '\'' +
                '}';
    }
}
