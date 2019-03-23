package cn.java.controller.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * @Description:统一的异常处理
 * @author: Khalil
 * @date:   2019年3月20日 上午11:49:04   
 * @version V1.0 
 * @Copyright: 2019 Khalil. All rights reserved.
 */
@ControllerAdvice
public class GlobalExceptHandler {
	
	private static Logger logger=Logger.getLogger(GlobalExceptHandler.class);
	
	@ExceptionHandler(Exception.class)
	public String handException(Exception ex) {
		//ex.printStackTrace();
		//将错误信息单独保存到一个文件夹中（khalil.log）---->使用log4j
		String errorMesage=ex.getMessage();//简介的报错信息
		logger.debug(errorMesage);//把log写到khalil.log文件中
//		PrintStream ps;
//		try {
//			FileOutputStream fos=new FileOutputStream("E://SpringMVC/khalil.log",true);//true为默认追加
//			ps = new PrintStream(fos);
//			//1，获取系统当前时间，将时间记录到文件中
//			Date date=new Date();
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
//			String time=sdf.format(date);
//			ps.write(time.getBytes("utf-8"));
//			//换行
//			ps.write("\r\n".getBytes("utf-8"));
//			//2、将错误信息写入指定文件中去
//			ex.printStackTrace(ps);
//			//关闭流
//			ps.close();
//			fos.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "error/error.jsp";
	}
}
