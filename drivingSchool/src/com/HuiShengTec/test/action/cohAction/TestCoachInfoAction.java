package com.HuiShengTec.test.action.cohAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.entity.CoachInfo;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestCoachInfoAction extends BaseActionJunit {

	@Test
	public void testcohInfo() throws Exception {
		request.setRequestURI("/coh/cohInfo"); 
		CoachInfo coachInfo = new CoachInfo();
		coachInfo.setPicId(0);
		request.getSession().setAttribute("userInfo", coachInfo);
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testeditCoachPhoto() throws Exception {
		request.setRequestURI("/coh/editCoachPhoto"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testeditCoachInfoSubmit() throws Exception {
		request.setRequestURI("/coh/editCoachInfoSubmit"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
}
