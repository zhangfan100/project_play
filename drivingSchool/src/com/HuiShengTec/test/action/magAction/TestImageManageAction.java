package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestImageManageAction extends BaseActionJunit {

	@Test
	public void testcarBrandManage() throws Exception {
		request.setRequestURI("/mag/imageManage"); 
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testdeleteImage() throws Exception {
		request.setRequestURI("/mag/deleteImage"); 
		request.setMethod("POST");
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testeditImage() throws Exception {
		request.setRequestURI("/mag/editImage"); 
		request.setMethod("POST");
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
}
