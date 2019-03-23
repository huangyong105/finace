package com.investment.app.manager;

import com.investment.app.DTO.ArticleManagementDTO;
import com.investment.app.converter.BeanConverter;
import com.investment.app.jdbcObject.ArticleManagementDO;
import com.investment.app.service.ArticleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dongyuan
 * @date 2019-03-22 16:55
 **/
@Service
public class ArticleManager {
    @Autowired
    ArticleManagementService articleManagementService;

    public List<ArticleManagementDTO> getAllArticle(){
        List<ArticleManagementDO> list = articleManagementService.getAllArticle();
        List<ArticleManagementDTO> articleManagementDTOS = BeanConverter.batchConvert(list, ArticleManagementDTO.class);
        return articleManagementDTOS;
    }
}
