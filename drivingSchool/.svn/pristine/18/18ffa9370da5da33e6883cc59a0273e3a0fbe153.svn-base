package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestSignInLogAction extends BaseActionJunit {

	@Test
	public void testsignInLogManage() throws Exception {
		request.setRequestURI("/mag/signInLogManage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testquerySignInLogPage() throws Exception {
		request.setRequestURI("/mag/querySignInLogPage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
