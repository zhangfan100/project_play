package com.HuiShengTec.test.action.stuAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestLessonDetailAction extends BaseActionJunit{

	@Test
	public void testToTrainDetail() throws Exception {
		request.setRequestURI("/stu/toTrainDetail"); 
        request.setMethod("POST");    
        request.addParameter("trainCode", "16");
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav.getViewName());
	}
	
	@Test
	public void testQueryByTrainCode() throws Exception {
		request.setRequestURI("/stu/queryByTrainCode"); 
		request.setMethod("POST");    
		request.addParameter("trainCode", "14");
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testToDeductionInfo() throws Exception {
		request.setRequestURI("/stu/toDeductionInfo"); 
		request.setMethod("POST");    
		request.addParameter("trainCode", "14");
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testQueryByCode() throws Exception {
		request.setRequestURI("/stu/queryByCode"); 
		request.setMethod("POST");    
		request.addParameter("trainCode", "14");
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}

}
