package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestCampusInfoAction extends BaseActionJunit {

	@Test
	public void testBasicPropeInfoManage() throws Exception {
		request.setRequestURI("/mag/campusInfo"); 
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testqueryCampusInfo() throws Exception {
		request.setRequestURI("/mag/queryCampusInfo"); 
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testeditCampusInfoId() throws Exception {
		request.setRequestURI("/mag/editCampusInfoId"); 
		request.addParameter("campusInfoId", "24");
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testeditCampusInfoSubmit() throws Exception {
		request.setRequestURI("/mag/editCampusInfoSubmit"); 
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testaddCampusInfo() throws Exception {
		request.setRequestURI("/mag/addCampusInfo"); 
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
