package com.neverend.blog.mapper;

import com.neverend.blog.entity.ArticleSuperArticleId;
import com.neverend.blog.entity.ArticleSuperArticleIdExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ArticleSuperArticleIdMapper {
    long countByExample(ArticleSuperArticleIdExample example);

    int deleteByExample(ArticleSuperArticleIdExample example);

    int deleteByPrimaryKey(String id);

    int insert(ArticleSuperArticleId record);

    int insertSelective(ArticleSuperArticleId record);

    List<ArticleSuperArticleId> selectByExample(ArticleSuperArticleIdExample example);

    ArticleSuperArticleId selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ArticleSuperArticleId record, @Param("example") ArticleSuperArticleIdExample example);

    int updateByExample(@Param("record") ArticleSuperArticleId record, @Param("example") ArticleSuperArticleIdExample example);

    int updateByPrimaryKeySelective(ArticleSuperArticleId record);

    int updateByPrimaryKey(ArticleSuperArticleId record);

    int save(@Param("list") List<ArticleSuperArticleId> list);

    int Updatesave(@Param("list") List<ArticleSuperArticleId> articleSuperArticleId);

}