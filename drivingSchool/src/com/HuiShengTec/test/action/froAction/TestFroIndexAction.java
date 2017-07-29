package com.HuiShengTec.test.action.froAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestFroIndexAction extends BaseActionJunit {

	@Test
	public void testfroIndex() throws Exception {
		request.setRequestURI("/froIndex"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testqueryMenu() throws Exception {
		request.setRequestURI("/queryMenu"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testQuerySchoolTeacher() throws Exception {
		request.setRequestURI("/querySchoolTeacher"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testquerySchoolStudent() throws Exception {
		request.setRequestURI("/querySchoolStudent"); 
		request.setMethod("POST");    
		request.addParameter("schoolId", "63");
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	
}
