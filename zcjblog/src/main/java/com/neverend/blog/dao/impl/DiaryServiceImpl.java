package com.neverend.blog.dao.impl;

import com.github.pagehelper.PageInfo;
import com.neverend.blog.dao.DiaryDao;
import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.Diary;
import com.neverend.blog.moudel.Code;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.moudel.PageMsg;
import com.neverend.blog.service.DiaryService;
import com.neverend.blog.util.email.GetMsg;
import com.neverend.blog.util.email.GetUUID;
import com.neverend.blog.util.email.SetMsgPage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    private DiaryDao diaryDao;
    /**
     * 插入日记记录
     * @param textContext
     * @return
     */
    @Override
    public Msg insertDiary(String textContext) {
        Diary diary = new Diary();
        Msg msg = GetMsg.getMsg();
        Account account = (Account)SecurityUtils.getSubject().getPrincipal();
        if(account != null){
            diary.setId(GetUUID.uuid());
            diary.setCreatTime(new Date());
            diary.setAccountId(account.getId());
            diary.setTextContext(textContext);
            int i = diaryDao.insertDiary(diary);
            msg.setMsg(Code.sucessMsg);
            msg.setCode(Code.sucess);
            msg.setCount(Integer.toString(i));
            return msg;
        }else {
            msg.setCode(Code.securityNull);
            msg.setMsg(Code.securityNullMsg+"你需要登陆！");
            return  msg;
        }


    }

    /**
     * @param sortName  排序字段根据 日记正序排列
     * @param pageStart 开始页
     * @param pageSize  一页数量
     * @return
     */
    @Override
    public Msg getDiary(String sortName, Integer pageStart, Integer pageSize) {
        PageInfo<Diary> diary = diaryDao.getDiary(sortName, pageStart, pageSize);
        Msg msg = GetMsg.getMsg();
        msg.setCode(Code.sucess);
        msg.setMsg(Code.sucessMsg);
        PageMsg pageMsg = SetMsgPage.getPageMsg(diary);
        msg.setData(pageMsg);
        return msg;
    }

}
