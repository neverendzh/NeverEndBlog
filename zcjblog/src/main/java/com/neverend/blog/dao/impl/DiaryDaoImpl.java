package com.neverend.blog.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neverend.blog.dao.DiaryDao;
import com.neverend.blog.entity.Diary;
import com.neverend.blog.entity.DiaryExample;
import com.neverend.blog.mapper.DiaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class DiaryDaoImpl implements DiaryDao {
    @Autowired
    private DiaryMapper diaryMapper;
    /**
     * 插入日记记录
     *
     * @param diary
     * @return
     */
    @Override
    public int insertDiary(Diary diarys) {
        int i = diaryMapper.insertSelective(diarys);
        return i;
    }

    /**
     * @param sortName  排序字段根据 日记正序排列
     * @param pageStart 开始页
     * @param pageSize  一页数量
     * @return
     */
    @Override
    public PageInfo<Diary> getDiary(String sortName, Integer pageStart, Integer pageSize) {
        PageHelper.startPage(pageStart,pageSize);
        DiaryExample diaryExample = new DiaryExample();
        diaryExample.setOrderByClause("creat_Time ASC");
        List<Diary> diaries = diaryMapper.selectByExample(diaryExample);
        PageInfo<Diary> personPageInfo = new PageInfo<>(diaries);
        return personPageInfo;
    }
}
