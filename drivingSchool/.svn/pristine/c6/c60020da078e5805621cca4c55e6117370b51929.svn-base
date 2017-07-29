package com.HuiShengTec.test.action.cohAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestCohLessonInfoAction extends BaseActionJunit {

	@Test
	public void testcohInfo() throws Exception {
		request.setRequestURI("/coh/historyCohLessonInfo"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testfutureCohLessonInfo() throws Exception {
		request.setRequestURI("/coh/futureCohLessonInfo"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testqueryCohLessonInfo() throws Exception {
		request.setRequestURI("/coh/queryCohLessonInfo"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
