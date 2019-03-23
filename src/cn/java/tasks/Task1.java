package cn.java.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task1 {

	//@Scheduled(fixedRate=2000) 每隔两秒执行
	//cron 固定时间 秒 分 时 日 月 年  
	//cron="0/2 38 16 * * ?" 0/2表示每隔两秒执行
 	//@Scheduled(cron="0 38 16 * * ?")
	@Scheduled(fixedRate=2000)
	public void task1() {
		Date cTime=new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str=sdf.format(cTime);
		System.out.println(str);
	}
}
