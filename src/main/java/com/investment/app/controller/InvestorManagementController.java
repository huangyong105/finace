package com.investment.app.controller;

import com.investment.app.DTO.InvestmentDetailsDTO;
import com.investment.app.DTO.InvestorManagementDTO;
import com.investment.app.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户相关接口
 *
 * @author dongyuan
 * @date 2019-03-23 15:10
 **/
@RestController
@RequestMapping("/investor")
public class InvestorManagementController {

    /**
     * 获取用户基础信息
     * @return
     */
    @RequestMapping("/information")
    public Result getInformation(){
        InvestorManagementDTO investorManagementDTO = new InvestorManagementDTO();
        investorManagementDTO.setId(1);
        investorManagementDTO.setTelNumber("123456789");
        investorManagementDTO.setEmail("8435145324.@qq.com");
        return Result.ofSuccess(investorManagementDTO);
    }

    /**
     * 获取用户投资详情
     * @return
     */
    @RequestMapping("/myInvestment")
    public Result getMyInvestment(){
        List<InvestmentDetailsDTO> investmentDetailsDTOS = new ArrayList<>();
        InvestmentDetailsDTO investmentDetailsDTO = new InvestmentDetailsDTO();
        investmentDetailsDTO.setId(1);
        investmentDetailsDTO.setExpectedRiskTolerance(2);
        BigDecimal amount = BigDecimal.valueOf(213.12);
        investmentDetailsDTO.setInputMargin(amount);
        investmentDetailsDTO.setState(1);
        investmentDetailsDTOS.add(investmentDetailsDTO);
        return Result.ofSuccess(investmentDetailsDTOS);
    }

    /**
     * 获取实名认证状态
     * @return
     */
    @RequestMapping("/realNameState")
    public Result getRealNameState(){
        return Result.ofSuccess("已认证");
    }

    /**
     * 获取绑卡状态
     * @return
     */
    @RequestMapping("/bindCodeState")
    public Result getBindCodeState(){
        return Result.ofSuccess("已绑定");
    }

}
