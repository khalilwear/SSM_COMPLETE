package cn.java.service;

import cn.java.entity.Persons;

public interface PersonsService {

    int deleteByPrimaryKey(Long id);

    int insert(Persons record);

    int insertSelective(Persons record);

    Persons selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Persons record);

    int updateByPrimaryKey(Persons record);
    
    int transMoney(String bankNo1,String bankNo2, Integer money);
}