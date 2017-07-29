package com.HuiShengTec.test.action.cohAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestEditCoachLoginInfoAction extends BaseActionJunit {

	@Test
	public void testcohInfo() throws Exception {
		request.setRequestURI("/coh/coachLoginInfo"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testeditLogInfoSubmit() throws Exception {
		request.setRequestURI("/coh/editLogInfoSubmit"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
