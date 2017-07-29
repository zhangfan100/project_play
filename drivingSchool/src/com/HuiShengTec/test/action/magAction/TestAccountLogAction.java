package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestAccountLogAction extends BaseActionJunit {

	@Test
	public void teststatisticalDataPage() throws Exception {
		request.setRequestURI("/mag/statisticalDataPage"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
    
	@Test
	public void testgetStatisticalData() throws Exception {
		request.setRequestURI("/mag/getStatisticalData"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testgetWeekStatisticalData() throws Exception {
		request.setRequestURI("/mag/getWeekStatisticalData"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testgetMonthStatisticalData() throws Exception {
		request.setRequestURI("/mag/getMonthStatisticalData"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testgetQuarterStatisticalData() throws Exception {
		request.setRequestURI("/mag/getQuarterStatisticalData"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testgetYearStatisticalData() throws Exception {
		request.setRequestURI("/mag/getYearStatisticalData"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testfillStatisticalData() throws Exception {
		request.setRequestURI("/mag/fillStatisticalData");
		request.addParameter("statisticType", "1");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
}
