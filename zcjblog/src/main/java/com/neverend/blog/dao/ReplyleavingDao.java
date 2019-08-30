package com.neverend.blog.dao;

import com.neverend.blog.entity.ArtilceRespondToMessages;
import com.neverend.blog.moudel.Msg;
import io.swagger.models.auth.In;

public interface ReplyleavingDao {
    /**
     * 保存留言
     * @param msg
     * @return
     */
    int insertmsg(ArtilceRespondToMessages msg);
    /**
     * 保存留言回复
     * @param msg 留言信息
     * @param msgid 回复留言的id
     * @return
     */
    int insertmsg(ArtilceRespondToMessages msg,String msgid);
}
