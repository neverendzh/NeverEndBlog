package com.neverend.blog.service.weixin.impl;

import com.neverend.blog.service.weixin.WeiXinService;
import com.neverend.blog.util.email.weixin.WeiXinUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class WeiXinServiceImpl implements WeiXinService {

     @Autowired
     private WeiXinUtil weiXinUtil;
    /**
     * 发送文本消息
     * @param o
     * @return
     */
    @Override
    public Object sendTextMsg(Object o) {
        String s = o.toString();
        int bufenUser = weiXinUtil.getBufenUser(s);
        return bufenUser;
    }

}
