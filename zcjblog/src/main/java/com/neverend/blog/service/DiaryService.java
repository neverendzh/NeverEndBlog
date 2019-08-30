package com.neverend.blog.service;

import com.neverend.blog.entity.Diary;
import com.neverend.blog.moudel.Msg;

public interface DiaryService {

    /**
     * 插入日记记录
     * @param diary
     * @return
     */
    Msg insertDiary(String diary);

    /**
     *
     * @param sortName 排序字段根据 日记正序排列
     * @param pageStart 开始页
     * @param pageSize  一页数量
     * @return
     */
    Msg getDiary(String sortName, Integer pageStart, Integer pageSize);
}
