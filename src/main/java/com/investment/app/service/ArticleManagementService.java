package com.investment.app.service;

import com.investment.app.jdbcObject.ArticleManagementDO;
import com.investment.app.mapper.ArticleManagementMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dongyuan
 * @date 2019-03-22 17:00
 **/
@Service
public class ArticleManagementService {
    @Resource
    ArticleManagementMapper articleManagementMapper;
    public List<ArticleManagementDO> getAllArticle(){
        List<ArticleManagementDO> articleManagementDOS = articleManagementMapper.selectAllArticle();
        return articleManagementDOS;
    }
}
