package com.investment.app.service;

import com.investment.app.jdbcObject.ProjectManagementDO;
import com.investment.app.mapper.ProjectManagementMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dongyuan
 * @date 2019-03-22 12:11
 **/
@Service
public class ProjectManagementService {
    @Resource
    ProjectManagementMapper projectManagementMapper;
    public List<ProjectManagementDO> getAllProjectManagement(){
        List<ProjectManagementDO> projectManagementDOS = projectManagementMapper.selectAllPrimary();
        return projectManagementDOS;
    }
    public ProjectManagementDO getProjectManagementById(Integer id){
        ProjectManagementDO projectManagementDO = projectManagementMapper.selectByPrimaryKey(id);
        return projectManagementDO;
    }
}
