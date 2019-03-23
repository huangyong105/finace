package com.investment.app.mapper;


import com.investment.app.jdbcObject.ArticleManagementDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleManagementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleManagementDO record);

    int insertSelective(ArticleManagementDO record);

    ArticleManagementDO selectByPrimaryKey(Integer id);

    List<ArticleManagementDO> selectAllArticle();

    int updateByPrimaryKeySelective(ArticleManagementDO record);

    int updateByPrimaryKeyWithBLOBs(ArticleManagementDO record);

    int updateByPrimaryKey(ArticleManagementDO record);
}