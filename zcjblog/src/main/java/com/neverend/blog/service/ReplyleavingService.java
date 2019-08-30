package com.neverend.blog.service;

import com.neverend.blog.moudel.Msg;

public interface ReplyleavingService {
    /**
     * 保存留言
     * @param msg
     * @return
     */
    Msg insertmsg(String msg);
    /**
     * 保存留言回复
     * @param msg 留言信息
     * @param msgid 回复留言的id
     * @return
     */
    Msg insertmsg(String msg,String msgid);

    /**
     * 查看留言不带回复
     * @return
     */
    Msg geseeleavingMessage(Integer pageStart, Integer pageSize);


    /**
     * 查看留言的回复
     * @param pageStart
     * @param pageSize
     * @param replymsgid
     * @return
     */
    Msg getRepLeavingMsg(Integer pageStart, Integer pageSize, String replymsgid);
}
