package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestExceptionLogAction extends BaseActionJunit{

	
	
	@Test
	public void testexceptionLogManage() throws Exception {
		request.setRequestURI("/mag/exceptionLogManage"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testqueryExceptionLogPage() throws Exception {
		request.setRequestURI("/mag/queryExceptionLogPage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testdelExceptionLog() throws Exception {
		request.setRequestURI("/mag/delExceptionLog"); 
		request.setMethod("POST");  
		request.addParameter("ids", "14764");
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testqueryExceptionLogById() throws Exception {
		request.setRequestURI("/mag/queryExceptionLogById"); 
		request.setMethod("POST");  
		request.addParameter("id", "14765");
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
