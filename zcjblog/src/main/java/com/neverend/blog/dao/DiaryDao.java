package com.neverend.blog.dao;

import com.github.pagehelper.PageInfo;
import com.neverend.blog.entity.Diary;

public interface DiaryDao {

    /**
     * 插入日记记录
     * @param diary
     * @return
     */
    int insertDiary(Diary diary);

    /**
     *
     * @param sortName 排序字段根据 日记正序排列
     * @param pageStart 开始页
     * @param pageSize  一页数量
     * @return
     */
    PageInfo<Diary> getDiary(String sortName,Integer pageStart,Integer pageSize);
}
