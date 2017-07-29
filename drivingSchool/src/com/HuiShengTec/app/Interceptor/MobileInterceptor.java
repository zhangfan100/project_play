package com.HuiShengTec.app.Interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.app.service.ILoginService;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.utils.Toolkit;

/**
 * @author 王泰然
 * @createTime 2014/11/17 10:35
 */
public class MobileInterceptor implements HandlerInterceptor{
	private final String mobile = "/mobile/";
	
	@Autowired
	private ILoginService iLoginService;
	
	private final Logger logger = Logger.getLogger(MobileInterceptor.class.getName());
	
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exception)
			throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView modelAndView) throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		logger.debug("手机端接口拦截器");
		HttpSession session =request.getSession();
		String mobileFlag=request.getParameter("mobileFlag");
		//非移动端请求让其通过
		String url= request.getRequestURI();
		if(url.indexOf(mobile)==-1){
			return true;
		}else {
			//如果未传输mobileFlag，拦截请求
			if(Toolkit.isEmpty(mobileFlag)){
				if(url.endsWith(mobile+"validateUserName")){
					return true;
				}else if(url.endsWith(mobile+"validateCode")){
					return true;
				}else if(url.endsWith(mobile+"validateEmail")){
					return true;
				}else if(url.endsWith(mobile+"registerStuSbmitInfo")){
					return true;
				}
				response.setStatus(320);
				return false;
			}else{
				if(url.endsWith(mobile+"queryStuInfo")){
					return true;
				}
				String currMobileFlFlag = (String)session.getAttribute("mobileFlag");
				if(!mobileFlag.equals(currMobileFlFlag)){
					//标识不同 表示重新登录
					session.removeAttribute("mobileFlag");
					session.removeAttribute("loginInfo");
					session.removeAttribute("userInfo");
					session.setAttribute("mobileFlag", mobileFlag);
				}
			}
			
		}
		//获取登陆信息
		Login loginInfo = (Login) session.getAttribute("loginInfo");
		//如获取失败，则重新定位登录信息
		if(Toolkit.isEmpty(loginInfo)){
			loginInfo = iLoginService.queryLoginInfoByMobileFlag(mobileFlag);
		}
		if(Toolkit.isEmpty(loginInfo)){
			//重新定位失败则拦截请求
			response.setStatus(320);
			return false;
		}else{
			//定位成功则补齐session内信息
			session.setAttribute("loginInfo", loginInfo);
			session.setAttribute("userInfo", iLoginService.queryUserInfo(loginInfo));
		}
		return true;
	}

}
