package cn.java.mapper;

import cn.java.entity.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    
    //模拟转账
    int updateMoney(String bankNo,Integer money);
}