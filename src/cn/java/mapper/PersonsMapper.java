package cn.java.mapper;

import cn.java.entity.Persons;

public interface PersonsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Persons record);

    int insertSelective(Persons record);

    Persons selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Persons record);

    int updateByPrimaryKey(Persons record);
}