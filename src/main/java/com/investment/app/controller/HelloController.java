package com.investment.app.controller;

import com.investment.app.DTO.ProjectManagementDTO;
import com.investment.app.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能描述: <br>
 *
 * @since: 1.0.0
 * @Author:yong.huang
 * @Date: 2019/3/23 23:49
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/helloWord")
    public String helloWord(){
        return "xiaohuangyong hello world";
    }
}
