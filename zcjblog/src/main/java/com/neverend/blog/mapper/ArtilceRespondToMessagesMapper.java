package com.neverend.blog.mapper;

import com.neverend.blog.entity.ArtilceRespondToMessages;
import com.neverend.blog.entity.ArtilceRespondToMessagesExample;
import java.util.List;

import com.neverend.blog.moudel.RepMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ArtilceRespondToMessagesMapper {
    long countByExample(ArtilceRespondToMessagesExample example);

    int deleteByExample(ArtilceRespondToMessagesExample example);

    int deleteByPrimaryKey(String id);

    int insert(ArtilceRespondToMessages record);

    int insertSelective(ArtilceRespondToMessages record);

    List<ArtilceRespondToMessages> selectByExample(ArtilceRespondToMessagesExample example);

    ArtilceRespondToMessages selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ArtilceRespondToMessages record, @Param("example") ArtilceRespondToMessagesExample example);

    int updateByExample(@Param("record") ArtilceRespondToMessages record, @Param("example") ArtilceRespondToMessagesExample example);

    int updateByPrimaryKeySelective(ArtilceRespondToMessages record);

    int updateByPrimaryKey(ArtilceRespondToMessages record);

    List<RepMessage> SeleavingMessage();

    List<RepMessage> seleavingMessagerep(@Param("replymsgid") String replymsgid);
}