package com.neverend.blog.service.weixin.impl;

import com.neverend.blog.moudel.Msg;
import com.neverend.blog.moudel.weixin.XmlRequest;
import com.neverend.blog.moudel.weixin.huifu.Xml;
import com.neverend.blog.service.ArticleService;
import com.neverend.blog.service.weixin.WeiXinService;
import com.neverend.blog.util.email.weixin.AesException;
import com.neverend.blog.util.email.weixin.WXBizMsgCrypt;
import com.neverend.blog.util.email.weixin.WeiXinUtil;
import com.thoughtworks.xstream.XStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

@Service
public class WeiXinServiceImpl implements WeiXinService {

    @Autowired
    private WeiXinUtil weiXinUtil;
    @Autowired
    private ArticleService articleService;
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
    public String handleWeiXinMsg(XmlRequest xmlRequest,String msg_signature, String timestamp, String nonce) {
        try {
            Date date = new Date();
            System.out.println("时间："+date.toString()+xmlRequest);
            String sToken = "q2Oiq3QGTpebCT";
            String sCorpID = "wwcfe718794b798a88";
            String sEncodingAESKey = "WrxtzXSt4qjz33za6mtMPiZSVIHPQuAYeYVLWYwJznH";
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
//            解析后的xml
            String xmlx = wxcpt.VerifyURL(msg_signature, timestamp, nonce, xmlRequest.getEncrypt());
            System.out.println("需要转换的xml格式："+xmlx);
            XStream xStream = new XStream();
            XStream.setupDefaultSecurity(xStream);
            xStream.allowTypes(new Class[]{ com.neverend.blog.moudel.weixin.jieshouxml.Xml.class});
            xStream.alias("xml",  com.neverend.blog.moudel.weixin.jieshouxml.Xml.class);
            com.neverend.blog.moudel.weixin.jieshouxml.Xml xmlBtnShenHeMsg = (com.neverend.blog.moudel.weixin.jieshouxml.Xml) xStream.fromXML(xmlx);
//           修改文章待审核为已审核状态
//            获取文章id
            String articleID = xmlBtnShenHeMsg.getTaskId();
//            点击的是按钮是那个 btn1是通过审核 btn2是驳回
            String eventKey = xmlBtnShenHeMsg.getEventKey();
            String event = xmlBtnShenHeMsg.getEvent();
            Msg msg = null;
//            任务卡片点击时间
            if (event.equals("taskcard_click")){
                if (eventKey.equals("btn1")){
                    msg = articleService.editState("0",articleID);
                }else if (eventKey.equals("btn2")){
                    msg = articleService.editState("4",articleID);
                }
            }
            Xml xmlret = new Xml();
            xmlret.setToUserName(xmlBtnShenHeMsg.getFromUserName());
            xmlret.setCreateTime(date.toString());
            xmlret.setFromUserName(xmlBtnShenHeMsg.getToUserName());
            xmlret.setMsgType("text");
            String retmsg ="";
            if (msg!=null && msg.getCode().equals("200")){
                xmlret.setContent("处理成功");
            }else {
                xmlret.setContent("处理失败");
            }
            XStream xStream1 = new XStream();
            xStream1.setupDefaultSecurity(xStream1);
            xStream1.allowTypes(new Class[]{Xml.class});
            xStream1.alias("xml",Xml.class);
            String xmlmsg = xStream1.toXML(xmlret);
            System.out.println("返回xml："+xmlmsg);
            retmsg = wxcpt.EncryptMsg(xmlmsg, timestamp, nonce);
            return retmsg;
        } catch (AesException e) {
            e.printStackTrace();
        }
        return "500";
    }

    @Override
    public String handleWeiXinMsg(String msg_signature, String timestamp, String nonce, String echostr) {
        try {
            String sToken = "q2Oiq3QGTpebCT";
            String sCorpID = "wwcfe718794b798a88";
            String sEncodingAESKey = "WrxtzXSt4qjz33za6mtMPiZSVIHPQuAYeYVLWYwJznH";
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
            echostr = URLDecoder.decode(echostr, "UTF-8");
            String sechostr = wxcpt.VerifyURL(msg_signature, timestamp, nonce, echostr);
            return sechostr;
        } catch (AesException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "500";
    }

}
