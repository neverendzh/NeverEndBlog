package com.neverend.blog.contoller.admin.messagecrm;

import com.neverend.blog.moudel.weixin.XmlRequest;
import com.neverend.blog.service.weixin.WeiXinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.net.URLDecoder;

@Controller
@ApiIgnore
public class msgcrm {
    @Autowired
    private WeiXinService weiXinService;
    @GetMapping("/system/admin/msg/crm")
    public String urledit(){
        return "admin/messagecrm/message";
    }

    /**
     * 验证
     * @param msg_signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @GetMapping(value = "/system/admin/handle/weixin/msg")
    @ResponseBody
    public String handleWeiXinMsgYz(@RequestParam(name = "msg_signature") String msg_signature,
                                  @RequestParam(name = "timestamp") String timestamp,
                                  @RequestParam(name = "nonce") String nonce,
                                  @RequestParam(name = "echostr",required = false) String echostr){
        String msg = weiXinService.handleWeiXinMsg(msg_signature,timestamp,nonce,echostr);
        return msg;
    }

    /**
     * 处理消息
     * @param xml
     * @return
     */
    @PostMapping(value = "/system/admin/handle/weixin/msg",
            consumes = { MediaType.TEXT_XML_VALUE})
    @ResponseBody
    public String handleWeiXinMsg(@RequestBody XmlRequest xml,
                                  @RequestParam(name = "msg_signature") String msg_signature,
                                  @RequestParam(name = "timestamp") String timestamp,
                                  @RequestParam(name = "nonce") String nonce){
        String msg = weiXinService.handleWeiXinMsg(xml,msg_signature,timestamp,nonce);
        return msg;
    }
}
