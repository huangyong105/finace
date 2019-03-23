package com.investment.app.manager;

import com.investment.app.DTO.ProjectManagementDTO;
import com.investment.app.converter.BeanConverter;
import com.investment.app.jdbcObject.ProjectManagementDO;
import com.investment.app.service.ProjectManagementService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 投资项目相关
 *
 * @author dongyuan
 * @date 2019-03-22 11:42
 **/
@Service
public class InvestmentManager {
    @Autowired
    private ProjectManagementService projectManagementService;

    public List<ProjectManagementDTO> getAllInvestmentProject(){
        List<ProjectManagementDO> list = projectManagementService.getAllProjectManagement();
        List<ProjectManagementDTO> projectManagementDTOS = BeanConverter.batchConvert(list, ProjectManagementDTO.class);
        return projectManagementDTOS;
    }

    public ProjectManagementDTO getInvestmentProject(Integer id){
        ProjectManagementDO projectManagementDO = projectManagementService.getProjectManagementById(id);
        ProjectManagementDTO projectManagementDTO = BeanConverter.convert(projectManagementDO, ProjectManagementDTO.class);
        return projectManagementDTO;
    }
}
