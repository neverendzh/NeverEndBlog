package com.neverend.blog.contoller.user;

import com.neverend.blog.moudel.Msg;
import com.neverend.blog.moudel.PageMsg;
import com.neverend.blog.moudel.RepMessage;
import com.neverend.blog.service.ReplyleavingService;
import com.neverend.blog.util.email.weixin.WeiXinUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 留言
 * @author zcg
 */
@Controller
@RequestMapping("/album")
public class Albums {
    @Autowired
    private WeiXinUtil weiXinUtil;
    @Autowired
    private ReplyleavingService replyleavingService;
    /**
     * 留言
     * @return
     */
    @GetMapping("/index")
    @ApiIgnore
    public  String albumsIndex(){
        return "user/liuyan";
    }


    /**
     * 留言接口
     * @return
     */
    @PostMapping("/leaving/message")
    @ResponseBody
    @ApiOperation(value = "留言接口", httpMethod = "POST",
            notes = "用户留言接口", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "leavingMsg", value = "留言信息",
                    required = true, dataType = "String", paramType = "query")})
    public  Msg leavingMessagejson(@RequestParam(name = "leavingMsg")String leavingMsg,
                                   Device device){
        Msg insertmsg = replyleavingService.insertmsg(leavingMsg);
        return insertmsg;
    }

    /**
     * 回复留言接口
     * @return
     */
    @PostMapping("/Reply/leaving/message")
    @ResponseBody
    @ApiOperation(value = "回复留言接口", httpMethod = "POST",
            notes = "回复用户留言接口", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "leavingMsg", value = "留言信息",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "replymsgid", value = "回复留言的id",
                    required = true, dataType = "String", paramType = "query")})
    public  Msg ReplyleavingMessagejson(@RequestParam(name = "leavingMsg")String leavingMsg,
                                       @RequestParam(name = "replymsgid")String replymsgid,
                                        Device device){

        Msg insertmsg = replyleavingService.insertmsg(leavingMsg,replymsgid);
        return insertmsg;
    }


    /**
     * 查看留言
     * @return
     */
    @PostMapping("/see/leaving/message")
    @ResponseBody
    @ApiOperation(value = "查看留言", httpMethod = "POST",
            notes = "查看不带回复的留言", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageStart", value = "第几页", defaultValue = "1",
                    required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", defaultValue = "10",
                    required = false, dataType = "Integer", paramType = "query")})
    public  Msg<PageMsg<RepMessage>> seeleavingMessagejson(@RequestParam(name = "pageStart",defaultValue = "1",required = false)Integer pageStart,
                                           @RequestParam(name = "pageSize",defaultValue = "10",required = false) Integer pageSize,
                                               Device device){
        Msg msg = replyleavingService.geseeleavingMessage(pageStart,pageSize);
        return msg;
    }

    /**
     * 查看回复留言
     * @return
     */
    @PostMapping("/see/rep/leaving/message")
    @ResponseBody
    @ApiOperation(value = "查看回复留言", httpMethod = "POST",
            notes = "查看回复留言", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageStart", value = "第几页", defaultValue = "1",
                    required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", defaultValue = "10",
                    required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "replymsgid", value = "当前留言id",
                    required = true, dataType = "String", paramType = "query")})
    public  Msg<PageMsg<RepMessage>> seeRepleavingMessagejson(@RequestParam(name = "pageStart",defaultValue = "1",required = false)Integer pageStart,
                                                 @RequestParam(name = "pageSize",defaultValue = "10",required = false) Integer pageSize,
                                                 @RequestParam(name = "replymsgid")String replymsgid,
                                                     Device device){

        Msg msg = replyleavingService.getRepLeavingMsg(pageStart,pageSize,replymsgid);
        return msg;
    }
}
