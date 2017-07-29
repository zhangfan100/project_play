package com.HuiShengTec.base.ExceptionResolver;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.app.service.IExceptionLogService;
import com.HuiShengTec.entity.ExceptionLog;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.utils.Toolkit;


public class ExceptionHandler implements HandlerExceptionResolver {
	
	@Autowired
	private IExceptionLogService iExceptionHandler;
	
	/**
	 * 统一异常处理方式
	 */
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception ex) {
		
		ex.printStackTrace();
		
		Login loginInfo = (Login)request.getSession().getAttribute("loginInfo");
		
		//获取异常所有信息
		StringWriter sw = new StringWriter();
		ex.printStackTrace(new PrintWriter(sw,true));
		
		ExceptionLog log = new ExceptionLog();
		log.setExceptionContent(sw.toString());
		log.setExceptionTitle(ex.getCause()==null?ex.toString():ex.getCause().toString());
		
		if(!Toolkit.isEmpty(loginInfo)){
			log.setUserFlag(loginInfo.getRoleType());
			log.setUserName(loginInfo.getUsername());
		}
		
		iExceptionHandler.saveException(log);
		return null;
	}
	
}
