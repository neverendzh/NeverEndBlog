package com.neverend.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neverend.blog.dao.ReplyleavingDao;
import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.ArtilceRespondToMessages;
import com.neverend.blog.entity.ArtilceRespondToMessagesExample;
import com.neverend.blog.mapper.ArtilceRespondToMessagesMapper;
import com.neverend.blog.moudel.Code;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.moudel.RepMessage;
import com.neverend.blog.service.ReplyleavingService;
import com.neverend.blog.util.email.GetMsg;
import com.neverend.blog.util.email.GetUUID;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class ReplyleavingServiceImpl implements ReplyleavingService {
    @Autowired
    private ReplyleavingDao replyleavingDao;
    @Autowired
    private ArtilceRespondToMessagesMapper toMessagesMapper;
    /**
     * 保存留言
     *
     * @param msg
     * @return
     */
    @Override
    public Msg insertmsg(String msg) {
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        Msg retmsg = GetMsg.getMsg();
        if (account!=null){
            if ( account.getAccountState().equals(Account.STATE_NORMAL)){
                String uuid = GetUUID.uuid();
                ArtilceRespondToMessages toMessages = new ArtilceRespondToMessages();
                toMessages.setId(uuid);
                toMessages.setAccountId(account.getId());
                toMessages.setRespondToMessagesId(uuid);
                toMessages.setTime(new Date());
                toMessages.setMessage(msg);
                toMessages.setFabulousNum(0);
                int insertmsg = replyleavingDao.insertmsg(toMessages);
                return getMsg(retmsg, insertmsg);
            }else {
                retmsg.setCode(Code.Prohibit);
                retmsg.setMsg(Code.ProhibitMsg);
                return retmsg;
            }

        }
       else {
            retmsg.setCode(Code.login);
            retmsg.setMsg("当前未登录，或登陆信息已失效");
            return retmsg;
        }
    }

    /**
     * 保存留言回复
     *
     * @param msg   留言信息
     * @param msgid 回复留言的id
     * @return
     */
    @Override
    public Msg insertmsg(String msg, String msgid) {
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        Msg retmsg = GetMsg.getMsg();
        if (account!=null ){
            if ( account.getAccountState().equals(Account.STATE_NORMAL)){
                String uuid = GetUUID.uuid();
                ArtilceRespondToMessages toMessages = new ArtilceRespondToMessages();
                toMessages.setId(uuid);
                toMessages.setAccountId(account.getId());
                toMessages.setRespondToMessagesId(uuid);
                toMessages.setTime(new Date());
                toMessages.setMessage(msg);
                toMessages.setFabulousNum(0);
                int insertmsg = replyleavingDao.insertmsg(toMessages,msgid);
                return getMsg(retmsg, insertmsg);
            }else {
                retmsg.setCode(Code.Prohibit);
                retmsg.setMsg(Code.ProhibitMsg);
                return retmsg;
            }

        }
        else {
            retmsg.setCode(Code.login);
            retmsg.setMsg("当前未登录，或登陆信息已失效");
            return retmsg;
        }
    }

    /**
     * 查看留言不带回复
     *
     * @return
     */
    @Override
    public Msg geseeleavingMessage(Integer pageStart, Integer pageSize) {
        PageHelper.startPage(pageStart,pageSize);
        List<RepMessage> repMessages = toMessagesMapper.SeleavingMessage();
        PageInfo<RepMessage> personPageInfo = new PageInfo<>(repMessages);
        Msg msg = GetMsg.getMsg();
        msg.setCode(Code.sucess);
        msg.setMsg(Code.sucessMsg);
        msg.setData(personPageInfo);
        return msg;
    }

    /**
     * 查看留言的回复
     *
     * @param pageStart
     * @param pageSize
     * @param replymsgid
     * @return
     */
    @Override
    public Msg getRepLeavingMsg(Integer pageStart, Integer pageSize, String replymsgid) {
        PageHelper.startPage(pageStart,pageSize);
        List<RepMessage> repMessages = toMessagesMapper.seleavingMessagerep(replymsgid);
        PageInfo<RepMessage> personPageInfo = new PageInfo<>(repMessages);
        Msg msg = GetMsg.getMsg();
        msg.setCode(Code.sucess);
        msg.setMsg(Code.sucessMsg);
        msg.setData(personPageInfo);
        return msg;
    }


    private Msg getMsg(Msg retmsg, int insertmsg) {
        if (insertmsg==1){
            retmsg.setCode(Code.sucess);
            retmsg.setMsg(Code.sucessMsg);
            return retmsg;

        }else {
            retmsg.setCode(Code.error);
            retmsg.setMsg(Code.errorMsg);
            return retmsg;
        }
    }
}
