package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestPriceAction extends BaseActionJunit {


	@Test
	public void testpriceMenuBar() throws Exception {
		request.setRequestURI("/mag/priceMenuBar"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testtimeManage() throws Exception {
		request.setRequestURI("/mag/timeManage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testweekManage() throws Exception {
		request.setRequestURI("/mag/weekManage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testdrivingLicenseManage() throws Exception {
		request.setRequestURI("/mag/drivingLicenseManage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testvehicleManage() throws Exception {
		request.setRequestURI("/mag/vehicleManage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	
	@Test
	public void testbaseManage() throws Exception {
		request.setRequestURI("/mag/baseManage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testsevenDayManage() throws Exception {
		request.setRequestURI("/mag/sevenDayManage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testqueryAllDrivingLicence() throws Exception {
		request.setRequestURI("/mag/queryAllDrivingLicence"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testquerySevenPrice() throws Exception {
		request.setRequestURI("/mag/querySevenPrice"); 
		request.addParameter("licenceId", "6");
		request.addParameter("carBrandId", "11");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	
	@Test
	public void testupdateSevenDaySubmit() throws Exception {
		request.setRequestURI("/mag/updateSevenDaySubmit"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testqueryAllTimePriceList() throws Exception {
		request.setRequestURI("/mag/queryAllTimePriceList"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testqueryWeekManage() throws Exception {
		request.setRequestURI("/mag/queryWeekManage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
}
