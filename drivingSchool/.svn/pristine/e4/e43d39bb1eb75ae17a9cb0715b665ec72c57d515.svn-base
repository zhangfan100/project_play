package com.HuiShengTec.test.action.stuAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.entity.Login;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestStuIndexAction extends BaseActionJunit{

	@Test
	public void teststuIndex() throws Exception {
		request.setRequestURI("/stu/stuIndex"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav.getModel().size());
	}
	@Test
	public void testmycourse() throws Exception {
		request.setRequestURI("/stu/mycourse"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav.getViewName());
	}
	@Test
	public void testonlinebooking() throws Exception {
		request.setRequestURI("/stu/onlinebooking"); 
		Login login = new Login();
		login.setUserId(62);
		request.getSession().setAttribute("loginInfo", login);
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav.getViewName());
	}
}
