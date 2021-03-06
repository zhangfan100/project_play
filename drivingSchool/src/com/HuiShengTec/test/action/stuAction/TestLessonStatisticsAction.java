package com.HuiShengTec.test.action.stuAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.entity.StudentInfo;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestLessonStatisticsAction extends BaseActionJunit{

	@Test
	public void teststudentStatistics() throws Exception {
		request.setRequestURI("/stu/studentStatistics"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav.getViewName());
	}
	@Test
	public void testqueryTrainStatistics() throws Exception {
		request.setRequestURI("/stu/queryTrainStatistics"); 
		StudentInfo login = new StudentInfo();
		login.setId(62);
		request.getSession().setAttribute("userInfo", login);
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testqueryTrainStatisticsTable() throws Exception {
		request.setRequestURI("/stu/queryTrainStatisticsTable"); 
		StudentInfo login = new StudentInfo();
		login.setId(62);
		request.getSession().setAttribute("userInfo", login);
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testqueryPeriodStatistics() throws Exception {
		request.setRequestURI("/stu/queryPeriodStatistics"); 
		StudentInfo login = new StudentInfo();
		login.setId(62);
		request.getSession().setAttribute("userInfo", login);
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
}
