package com.HuiShengTec.app.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.app.service.IOperationLogService;
import com.HuiShengTec.app.service.IRolePrivilegeService;
import com.HuiShengTec.base.cache.RolePrivilegeCache;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.OperationLog;
import com.HuiShengTec.entity.Privilege;
import com.HuiShengTec.utils.Toolkit;

public class PrivilegeInterceptor implements HandlerInterceptor{
	
	private final Logger logger = Logger.getLogger(PrivilegeInterceptor.class.getName());
	
	@Autowired
	private IOperationLogService logService;
	
	@Autowired
	private IRolePrivilegeService iRolePrivilegeService;
	
	
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exception)
			throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView modelAndView) throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		logger.debug("权限拦截器");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		uri = uri.substring(uri.indexOf(contextPath)+contextPath.length()).replaceAll("//", "/");
		
		
		String sign = "";
		if(!Toolkit.isEmpty(request.getParameter("sign"))){
			sign = "&sign="+request.getParameter("sign");
		}
		
		Privilege privilege = RolePrivilegeCache.getPrivilege(uri); 
		
		//无该url记录
		if(privilege==null){
			logger.debug("privilege: 404 "+uri);
			response.setStatus(404);
			request.getRequestDispatcher("/WEB-INF/jsp/error/404.jsp").forward(request, response);
			//当返回true时，处理执行链会继续，当返回false时，则不会去执行Controller的方法
			return false;
		}
		//来宾权限
		if(privilege.getRoleType()==0 || !privilege.getLoginFlag()){
			return true;
		}
		
		//来到这里以后就需要验证权限鸟
		Integer roleType = privilege.getRoleType();
		Login login = (Login)request.getSession().getAttribute("loginInfo");
		if(login==null || !login.getRoleType().equals(roleType) || Toolkit.isEmpty(RolePrivilegeCache.getRolePrivilege(login.getRoleId(), privilege.getId()))){
			switch (roleType) {
			case 1:
				//不要说直接重定向到登录页，弄死你
				request.getRequestDispatcher("/WEB-INF/jsp/error/403.jsp?forward="+contextPath+"/stu/login"+sign).forward(request, response);
				break;
			case 2:
				request.getRequestDispatcher("/WEB-INF/jsp/error/403.jsp?forward="+contextPath+"/coh/login"+sign).forward(request, response);
				break;
			case 3:
				request.getRequestDispatcher("/WEB-INF/jsp/error/403.jsp?forward="+contextPath+"/mag/login"+sign).forward(request, response);
				break;
			}
			logger.debug("privilege: 403 "+uri);
			return false;
		}
		
		//为1时需要保存操作日志
		if(privilege.getLogFlag()){
			OperationLog log = new OperationLog();
			log.setFunctionId(privilege.getId());
			log.setUserName(login.getUsername());
			log.setUserType(login.getRoleType());
			log.setiP(Toolkit.getIpAddr(request));
			logService.saveOperationLog(log);
		}
		
		return true;
	}

}
