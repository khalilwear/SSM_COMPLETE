package cn.java.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class QQ {
	//regex 正则表达式，只能用于字符串，不能用于int类型；message 报错信息
	@NotEmpty(message="没有昵称")
	@Pattern(regexp="[\\u4e00-\\u9fa5]{4,10}",message="昵称为4-10位汉字")
	private String nick;
	
	@Pattern(regexp="\\w{3,6}",message="密码3-6个")
	private String password;
	
	@Pattern(regexp="1[3578]\\d{9}",message="手机号错误")
	private String phone;
	
	@NotNull(message="请填写邮箱")
	@Email(message="输入邮箱格式有误")
	private String email;
	
	//min和max只能为整数
	@Min(value=1,message="年龄太小")
	@Max(value=150,message="年龄太大")
	private Integer age;

	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "QQ [nick=" + nick + ", password=" + password + ", phone=" + phone + ", email=" + email
				+ ", age=" + age + "]";
	}
	
	
}
