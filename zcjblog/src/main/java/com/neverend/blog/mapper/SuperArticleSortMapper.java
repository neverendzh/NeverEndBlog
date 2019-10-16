package com.neverend.blog.mapper;

import com.neverend.blog.entity.Article;
import com.neverend.blog.entity.SuperArticleSort;
import com.neverend.blog.entity.SuperArticleSortExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SuperArticleSortMapper {
    long countByExample(SuperArticleSortExample example);

    int deleteByExample(SuperArticleSortExample example);

    int deleteByPrimaryKey(String superArticleSortId);

    int insert(SuperArticleSort record);

    int insertSelective(SuperArticleSort record);

    List<SuperArticleSort> selectByExample(SuperArticleSortExample example);

    SuperArticleSort selectByPrimaryKey(String superArticleSortId);

    int updateByExampleSelective(@Param("record") SuperArticleSort record, @Param("example") SuperArticleSortExample example);

    int updateByExample(@Param("record") SuperArticleSort record, @Param("example") SuperArticleSortExample example);

    int updateByPrimaryKeySelective(SuperArticleSort record);

    int updateByPrimaryKey(SuperArticleSort record);

    List<SuperArticleSort> selectByWeiShanChu(@Param("statOne") String statOne,@Param("stateTwo") String stateTwo);

    /**
     * 根据文章的上下级长度倒序
     * @return
     */
    List<SuperArticleSort> selArticleNameSTypeS();

    /**
     *
     * @param id 用户id
     * @return
     */
    List<SuperArticleSort> getwzflsjyh(@Param("id") String id);

    /**
     * 根据用户 文章分类名 查询文章列表
     * @param id
     * @param name
     * @return
     */
    List<Article> getAccountArticleName(@Param("id")String id, @Param("name")String name);
}