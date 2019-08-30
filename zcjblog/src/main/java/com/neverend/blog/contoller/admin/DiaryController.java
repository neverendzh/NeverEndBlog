package com.neverend.blog.contoller.admin;

import com.neverend.blog.entity.Diary;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.moudel.PageMsg;
import com.neverend.blog.service.DiaryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    @ApiOperation(value = "保存日记记录", httpMethod = "POST",
            notes = "保存日记记录", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "textContext", value = "日记内容",
                    required = true, dataType = "String", paramType = "query")})
    @PostMapping("/admin/save/diary")
    public Msg setDiary(@RequestParam(name = "textContext") String textContext){
        Msg msg = diaryService.insertDiary(textContext);
        return msg;
    }

    @ApiOperation(value = "获取日记记录", httpMethod = "POST",
            notes = "获取日记记录", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sortName", value = "根据日期排序字段名称，不用传递",
                    required = true, dataType = "String", paramType = "query",defaultValue = "creat_Time"),

            @ApiImplicitParam(name = "pageStart", value = " 起始页",
                    required = true, dataType = "Integer", paramType = "query",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量",
                    required = true, dataType = "Integer", paramType = "query", defaultValue = "10")})
    @PostMapping("/admin/sel/diary")
    public Msg<PageMsg> getDiarys(@RequestParam(name = "sortName",defaultValue = "creat_Time",required = false) String sortName,
                                  @RequestParam(name = "pageStart",defaultValue = "1",required = false)  Integer pageStart,
                                  @RequestParam(name = "pageSize",defaultValue = "10",required = false) Integer pageSize){
        Msg msg = diaryService.getDiary(sortName,pageStart,pageSize);
        return msg;
    }
}
