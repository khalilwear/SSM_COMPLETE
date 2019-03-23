package cn.java.controller.front;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.java.entity.Persons;
import cn.java.entity.QQ;
import cn.java.service.PersonsService;

@Controller
@RequestMapping("/front/")
public class FrontController {
	@Autowired
	private PersonsService ps;
	
	@RequestMapping("getPersonById")
	@ResponseBody
	public Persons getPersonById(Long id) {
		return ps.selectByPrimaryKey(id);
	}
	
	@RequestMapping("transMoney")
	@ResponseBody
	public int transMoney(String bankNo1,String bankNo2,Integer money) {
		//返回1成功
		return ps.transMoney(bankNo1, bankNo2, money);
	}
	
	@RequestMapping("testException")
	public void testException() {
		String str=null;
		str.length();
	}
	//获取register传过来的json数据
	@RequestMapping("getJson")
	@ResponseBody//@RequestBody接收json，封装到map里面
	//public boolean getJson(@RequestBody Map<String, Object> jsonMap) {
	public boolean getJson(@RequestBody QQ jsonMap) {
		System.out.println("getJson:"+jsonMap);
		return true;
	}
}
