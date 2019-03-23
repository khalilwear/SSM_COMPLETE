package cn.java.controller.app;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import cn.java.utils.FilesUpload;


@Controller
@RequestMapping("/upload")
public class FileUploadController {
	//单文件上传
	@RequestMapping("singleFileUpload")
	public void singleFileUpload(@RequestParam(name="bigHeadImage")MultipartFile file,HttpServletRequest request) throws Exception {
		//1、获取上传的图片的实际名称
		String originalFilename=file.getOriginalFilename();
		//2、获取的是file控件name的属性值，此处为bigHeadImage
		String name=file.getName();
		System.out.println("originalFileame："+originalFilename);
		System.out.println("name："+name);
		//String path=request.getServletContext().getRealPath("/upload");//"/"代表“服务器/工程名”
		String uuid=UUID.randomUUID().toString();//避免文件重名
		//3、将文件保存到指定目录下
		File filePath= new File("C:\\Program Files\\Tomcat\\webapps\\upload\\"+uuid+originalFilename);
		file.transferTo(filePath);
	}
	
	@RequestMapping("getUploadPath")
	public void getUploadPath(HttpServletRequest request) {
		//getRealPath方法已过时
		//String path=request.getRealPath("/upload");
		//四个作用域pageContext-->request-->session-->application
		ServletContext sc=request.getServletContext();
		String path=sc.getRealPath("/upload");//"/"代表“服务器/工程名”
		System.out.println(path);
	}
	@Test
	public void testUUID() {
		//网卡号加时间戳
		String uuid=UUID.randomUUID().toString();
		System.out.println(uuid);
	}
	//多文件上传
	@RequestMapping("multipleFileUpload")
	public void multipleFileUpload(MultipartRequest files,String username,HttpServletRequest request) throws Exception {
		Map<String, Object> filesMap=FilesUpload.uploadfiles(request, files);
		System.out.println(filesMap);
	}
	
	
	
	
	
	
	
	
	
	
	
}
