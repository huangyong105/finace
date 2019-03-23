package com.investment.app.controller;

import com.investment.app.DTO.ArticleManagementDTO;
import com.investment.app.manager.ArticleManager;
import com.investment.app.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文章接口
 *
 * @author dongyuan
 * @date 2019-03-22 16:54
 **/
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleManager articleManager;

    /**
     * 获取所有文章列表
     * @return
     */
    @RequestMapping("/getArticleList")
    public Result<List<ArticleManagementDTO>> getArticleList(){
        List<ArticleManagementDTO> allArticle = articleManager.getAllArticle();
        return Result.ofSuccess(allArticle);
    }
}
