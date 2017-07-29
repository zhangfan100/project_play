package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestMagInfoAction extends BaseActionJunit {


	@Test
	public void testexceptionLogManage() throws Exception {
		request.setRequestURI("/mag/editMagInfo"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testeditMagPassword() throws Exception {
		request.setRequestURI("/mag/editMagPassword"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testeditMagInfoSubmit() throws Exception {
		request.setRequestURI("/mag/editMagInfoSubmit"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
