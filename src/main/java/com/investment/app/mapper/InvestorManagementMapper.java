package com.investment.app.mapper;


import com.investment.app.jdbcObject.InvestorManagementWithBLOBsDO;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorManagementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InvestorManagementWithBLOBsDO record);

    int insertSelective(InvestorManagementWithBLOBsDO record);

    InvestorManagementWithBLOBsDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InvestorManagementWithBLOBsDO record);

    int updateByPrimaryKeyWithBLOBs(InvestorManagementWithBLOBsDO record);

    int updateByPrimaryKey(InvestorManagementWithBLOBsDO record);
}