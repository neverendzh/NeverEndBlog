package com.neverend.blog.dao.impl;

import com.neverend.blog.dao.ReplyleavingDao;
import com.neverend.blog.entity.ArtilceRespondToMessages;
import com.neverend.blog.mapper.ArtilceRespondToMessagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
public class ReplyleavingDaoImpl implements ReplyleavingDao {
    @Autowired
    private ArtilceRespondToMessagesMapper messagesMapper;

    /**
     * 保存留言
     *
     * @param msg
     * @return
     */
    @Override
    public int insertmsg(ArtilceRespondToMessages msg) {
        int i = messagesMapper.insertSelective(msg);
        return i;
    }

    /**
     * 保存留言回复
     *
     * @param msg   留言信息
     * @param msgid 回复留言的id
     * @return
     */
    @Override
    public int insertmsg(ArtilceRespondToMessages msg, String msgid) {
        msg.setRespondToMessagesIdId(msgid);
        int i = messagesMapper.insertSelective(msg);
        return i;
    }
}
