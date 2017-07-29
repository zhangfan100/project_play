package com.HuiShengTec.test.action.cohAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.entity.CoachInfo;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class CoachImageActionTest extends BaseActionJunit{

	
	@Test
	public void testimageCoach() throws Exception {
		request.setRequestURI("/coh/imageCoach"); 
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testaddImage() throws Exception {
		request.setRequestURI("/coh/addImage"); 
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testqueryImages() throws Exception {
		request.setRequestURI("/coh/queryImages"); 
		CoachInfo coachInfo = new CoachInfo();
		coachInfo.setId(24);
		request.getSession().setAttribute("userInfo", coachInfo);
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testmarkOver() throws Exception {
		request.setRequestURI("/coh/markOver"); 
		CoachInfo coachInfo = new CoachInfo();
		coachInfo.setId(24);
		request.getSession().setAttribute("userInfo", coachInfo);
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
