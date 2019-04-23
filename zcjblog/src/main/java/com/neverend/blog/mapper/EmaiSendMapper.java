package com.neverend.blog.mapper;

import com.neverend.blog.entity.EmaiSend;
import com.neverend.blog.entity.EmaiSendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmaiSendMapper {
    long countByExample(EmaiSendExample example);

    int deleteByExample(EmaiSendExample example);

    int deleteByPrimaryKey(String id);

    int insert(EmaiSend record);

    int insertSelective(EmaiSend record);

    List<EmaiSend> selectByExampleWithBLOBs(EmaiSendExample example);

    List<EmaiSend> selectByExample(EmaiSendExample example);

    EmaiSend selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EmaiSend record, @Param("example") EmaiSendExample example);

    int updateByExampleWithBLOBs(@Param("record") EmaiSend record, @Param("example") EmaiSendExample example);

    int updateByExample(@Param("record") EmaiSend record, @Param("example") EmaiSendExample example);

    int updateByPrimaryKeySelective(EmaiSend record);

    int updateByPrimaryKeyWithBLOBs(EmaiSend record);

    int updateByPrimaryKey(EmaiSend record);
}