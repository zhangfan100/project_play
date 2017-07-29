package com.HuiShengTec.app.Interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.base.annotation.Token;

/**
 * token注解拦截器，防止form重复提交
 * @author mihuajun
 * @createTime 2014-11-5 下午10:00:34
 */
public class TokenInterceptor implements HandlerInterceptor{
	
	private final Logger logger = Logger.getLogger(TokenInterceptor.class.getName());
	
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exception)
			throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView modelAndView) throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		logger.debug("表单提交拦截器拦截器");
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		Token token = method.getAnnotation(Token.class);
		
		//无token注解不操作
		if(token==null)
			return true;
		
		//添加token标记
		boolean addToken = token.addToken();
		if(addToken){
			request.getSession(false).setAttribute("token", "token");
		}
		
		//移除token标记
		 boolean delToken = token.delToken();
		 if(delToken){
			String serverToken = (String)request.getSession(false).getAttribute("token");
			String clientToken = (String)request.getParameter("token");
			if(serverToken == null || clientToken == null ||!clientToken.equals(serverToken)){
				logger.debug("重复提交..  method:"+method.getName()+" url:"+request.getRequestURI());
				return false;
			}
			request.getSession(false).removeAttribute("token");
		 }
		return true;
	}

}
