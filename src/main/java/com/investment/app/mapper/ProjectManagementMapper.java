package com.investment.app.mapper;

import com.investment.app.jdbcObject.ProjectManagementDO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectManagementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectManagementDO record);

    int insertSelective(ProjectManagementDO record);

    ProjectManagementDO selectByPrimaryKey(Integer id);

    List<ProjectManagementDO> selectAllPrimary();

    int updateByPrimaryKeySelective(ProjectManagementDO record);

    int updateByPrimaryKey(ProjectManagementDO record);
}