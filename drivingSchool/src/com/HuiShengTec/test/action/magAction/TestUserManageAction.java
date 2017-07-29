package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestUserManageAction extends BaseActionJunit {

	@Test
	public void testadminManage() throws Exception {
		request.setRequestURI("/mag/adminManage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testquerySysAdminPage() throws Exception {
		request.setRequestURI("/mag/querySysAdminPage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testsetAdminStatus() throws Exception {
		request.setRequestURI("/mag/setAdminStatus");
		request.addParameter("idStr", "4,5,7");
		request.addParameter("status", "0");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
}
