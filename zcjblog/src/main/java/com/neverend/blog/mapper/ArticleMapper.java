package com.neverend.blog.mapper;

import com.neverend.blog.entity.Article;
import com.neverend.blog.entity.ArticleExample;
import com.neverend.blog.entity.ArticleWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ArticleMapper {
    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(String articleId);

    int insert(ArticleWithBLOBs record);

    int insertSelective(ArticleWithBLOBs record);

    List<ArticleWithBLOBs> selectByExampleWithBLOBs(ArticleExample example);

    List<Article> selectByExample(ArticleExample example);

    ArticleWithBLOBs selectByPrimaryKey(String articleId);

    int updateByExampleSelective(@Param("record") ArticleWithBLOBs record, @Param("example") ArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticleWithBLOBs record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(ArticleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

    int updateByPrimaryKey(Article record);

    List<Article> getArtilceFeiL(@Param("artilceid") String artilceid,@Param("state") String state,@Param("array")String[] array);

    List<Article> selectActilcNameLike(@Param("list") List<String> list,@Param("state") String state);

    List<Article> getArtilceFeiLon(@Param("artilceid") String artilceid,@Param("state") String state);

    List<Article> selectArticleHort();
}