package cn.java.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@RequestMapping("Login")
	private void Login() {
		System.out.println("AdminController==================");
	}
	
	public void addOrder() {
		
	}
}
