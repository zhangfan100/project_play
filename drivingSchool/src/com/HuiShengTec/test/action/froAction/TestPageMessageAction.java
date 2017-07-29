package com.HuiShengTec.test.action.froAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestPageMessageAction extends BaseActionJunit {

	@Test
	public void testfroIndex() throws Exception {
		request.setRequestURI("/pageMessage/viewNotice"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testviewInfo() throws Exception {
		request.setRequestURI("/pageMessage/viewInfo"); 
		request.addParameter("id", "6");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testprofile() throws Exception {
		request.setRequestURI("/pageMessage/profile"); 
		request.addParameter("kindId", "6");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
