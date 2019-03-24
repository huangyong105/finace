package com.investment.app.mapper;


import com.investment.app.jdbcObject.InvestorManagementDO;

public interface InvestorManagementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InvestorManagementDO record);

    int insertSelective(InvestorManagementDO record);

    InvestorManagementDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InvestorManagementDO record);

    int updateByPrimaryKey(InvestorManagementDO record);
}