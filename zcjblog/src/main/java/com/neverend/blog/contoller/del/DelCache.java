package com.neverend.blog.contoller.del;

import com.neverend.blog.moudel.Code;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.util.email.redis.RedisUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DelCache {

    @Autowired
    private RedisUtil redisUtil;
    @ApiOperation(value = "清除缓存所有", httpMethod = "POST",
            notes = "清除缓存数据,包括当前登陆对象", protocols = "http")
    @PostMapping("/del/all/cache")
    @ResponseBody
    public Msg delCacheRedisAll(){
        redisUtil.flushAll();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        Msg msg = new Msg();
        msg.setCode(Code.sucess);
        msg.setMsg(Code.sucessMsg);
        return msg;
    }

    @ApiOperation(value = "清除缓存数据redis", httpMethod = "POST",
            notes = "清除缓存数据redis", protocols = "http")
    @PostMapping("/del/all/cache/redis")
    @ResponseBody
    public Msg delCacheRedisAllYy(){
        redisUtil.flushAll();
        Msg msg = new Msg();
        msg.setCode(Code.sucess);
        msg.setMsg(Code.sucessMsg);
        return msg;
    }
}
