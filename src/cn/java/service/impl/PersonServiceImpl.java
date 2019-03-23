package cn.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.java.entity.Persons;
import cn.java.mapper.AccountMapper;
import cn.java.mapper.PersonsMapper;
import cn.java.service.PersonsService;

@Service
public class PersonServiceImpl implements PersonsService {
	
	@Autowired
	private PersonsMapper pm;
	
	@Autowired
	private AccountMapper am;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Persons record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Persons record) {
		// TODO Auto-generated method stub
		return 0;
	}

	//根据指定id查询用户
	@Override
	public Persons selectByPrimaryKey(Long id) {
		return pm.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Persons record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Persons record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional(readOnly=false)//具有事务性，有错直接回滚
	public int transMoney(String bankNo1, String bankNo2, Integer money) {
		int result1=am.updateMoney(bankNo1, -money);
		int result2=0;
		if(result1>=1) {
			result2=am.updateMoney(bankNo2, money);
		}
		return result2;
	}

}
