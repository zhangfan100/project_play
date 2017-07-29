package com.HuiShengTec.test.action.publicAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestLoginAction extends BaseActionJunit {

	@Test
	public void testlogin() throws Exception {
		request.setRequestURI("/coh/login");  
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response); 
        System.out.println(mav);
    }
	
	@Test
	public void testmaglogin() throws Exception {
		request.setRequestURI("mag/login");  
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response); 
		System.out.println(mav);
	}
	
	@Test
	public void testresetPassword() throws Exception {
		request.setRequestURI("mag/resetPassword");  
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response); 
		System.out.println(mav);
	}
	
}
