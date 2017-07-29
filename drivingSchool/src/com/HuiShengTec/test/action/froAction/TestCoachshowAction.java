package com.HuiShengTec.test.action.froAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestCoachshowAction extends BaseActionJunit {


	@Test
	public void testRedirectCoachshow() throws Exception {
		request.setRequestURI("/coachshow/redirectCoachshow"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testtoCoachDetail() throws Exception {
		request.setRequestURI("/coachshow/toCoachDetail"); 
		request.addParameter("id", "24");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
}
