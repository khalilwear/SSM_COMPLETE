package cn.java.utils;

import java.io.File;
import java.io.IOException;
import java.rmi.server.ObjID;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

//文件上传工具类
public class FilesUpload {
	
	//上传多个文件并返回文件的相对路径
	public static Map<String, Object> uploadfiles(HttpServletRequest request,MultipartRequest files) {
		Map<String, Object> filePathMap=new HashMap<String, Object>();
		try {
		Map<String, MultipartFile> filesMap=files.getFileMap();
		Set<String> keySet=filesMap.keySet();
		for(String key:keySet) {
			MultipartFile file=filesMap.get(key);
			String originalFilename=file.getOriginalFilename();
			String uuid=UUID.randomUUID().toString();
			//C:\Program Files\\Tomcat\\webapps\\spring-51cto\\upload
			String path=request.getServletContext().getRealPath("/upload");
			String basePath=path.split("webapps")[0]+"webapps\\upload";
			System.out.println(basePath);
			File fileUpload=new File(basePath);
			if(!fileUpload.exists()) {//如果文件夹不存在则创建
				fileUpload.mkdir();
			}
			//保存文件
			String filePath=basePath+"\\"+uuid+originalFilename;
			file.transferTo(new File(filePath));
			//将路径保存到map集合中
			String positivePath="upload/"+uuid+originalFilename;//相对路径
			filePathMap.put(uuid, positivePath);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePathMap;
	}
	
}
