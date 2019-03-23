package com.investment.app.mapper;


import com.investment.app.jdbcObject.AdministratorDO;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdministratorDO record);

    int insertSelective(AdministratorDO record);

    AdministratorDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdministratorDO record);

    int updateByPrimaryKey(AdministratorDO record);
}