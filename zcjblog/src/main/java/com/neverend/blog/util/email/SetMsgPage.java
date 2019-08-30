package com.neverend.blog.util.email;

import com.github.pagehelper.PageInfo;
import com.neverend.blog.moudel.PageMsg;

public class SetMsgPage {

    public static PageMsg getPageMsg(PageInfo pageInfo){
        PageMsg pageMsg = new PageMsg();
        pageMsg.setPageNum(pageInfo.getPageNum());
        pageMsg.setPageSize(pageInfo.getPageSize());
        pageMsg.setSize(pageInfo.getSize());
        pageMsg.setStartRow(pageInfo.getStartRow());
        pageMsg.setEndRow(pageInfo.getEndRow());
        pageMsg.setTotal(pageInfo.getTotal());
        pageMsg.setPages(pageInfo.getPages());
        pageMsg.setList(pageInfo.getList());
        pageMsg.setPrePage(pageInfo.getPrePage());
        pageMsg.setNextPage(pageInfo.getNextPage());
        pageMsg.setFirstPage(pageInfo.isIsFirstPage());
        pageMsg.setLastPage(pageInfo.isIsLastPage());
        pageMsg.setHasPreviousPage(pageInfo.isHasPreviousPage());
        pageMsg.setHasNextPage(pageInfo.isHasNextPage());
        pageMsg.setNavigatePages(pageInfo.getNavigatePages());
        pageMsg.setNavigatepageNums(pageInfo.getNavigatepageNums());
        pageMsg.setNavigateFirstPage(pageInfo.getNavigateFirstPage());
        pageMsg.setNavigateLastPage(pageInfo.getNavigateLastPage());
        return pageMsg;
    }
}
