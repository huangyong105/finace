package com.investment.app.controller;

import com.investment.app.DTO.InvestmentDetailsDTO;
import com.investment.app.DTO.InvestorManagementDTO;
import com.investment.app.manager.InvestorManager;
import com.investment.app.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    @Autowired
    private InvestorManager investorManager;
    @Value("${image_path_url}")
    String imagePathUrl;
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

    /**
     * 上传图片
     * @param file
     * @return
     */
    @RequestMapping("/uploadIdPhoto")
    public Result uploadIdPhoto(@RequestParam("file") MultipartFile file){
        String fileName = null;
        try {
            fileName = investorManager.uploadIdPhoto(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  Result.ofSuccess(imagePathUrl+fileName);
    }

    /**
     * 下载图片
     * @param fileName
     * @param response
     */
    @RequestMapping(value = "/downloadIdPhoto",method = RequestMethod.GET)
    public void downLoadIdPhoto(@RequestParam String fileName, HttpServletResponse response){
        response.setContentType("image/jpeg");
        response.setHeader("Cache-Control", "max-age=604800");
        try {
            investorManager.downloadIdPhoto(fileName,response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
