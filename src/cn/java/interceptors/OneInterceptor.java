package cn.java.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * Description: 拦截器,拦截Controller,不拦截jsp
 * author: Khalil
 */
public class OneInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("OneInterceptor-------------preHandle()");
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
//		if(username==null) {
//			request.getRequestDispatcher("/index.jsp");
//		}
		//返回false不放行，true放行
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("OneInterceptor-------------postHandle()");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("OneInterceptor-------------afterCompletion()");
		
	}


}
