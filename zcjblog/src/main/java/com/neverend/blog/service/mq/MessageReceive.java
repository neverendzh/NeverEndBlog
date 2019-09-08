package com.neverend.blog.service.mq;

import com.neverend.blog.util.email.weixin.WeiXinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageReceive {

    @Autowired
    private WeiXinUtil weiXinUtil;
    public void receiveMessagesend(Object message) {
        if (message!=null){
            weiXinUtil.getBufenUser("发布文章："+message.toString()+"待审核；请处理");
        }
    }
}
