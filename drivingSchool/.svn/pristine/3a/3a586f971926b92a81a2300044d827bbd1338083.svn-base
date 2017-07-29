package com.HuiShengTec.test.action.cohAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.entity.CoachInfo;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestLessonReviewAction extends BaseActionJunit {

	@Test
	public void testLessonReview() throws Exception {
		request.setRequestURI("/coh/lessonReview"); 
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testQuerylessonReview() throws Exception {
		request.setRequestURI("/coh/querylessonReview"); 
		CoachInfo coachInfo = new CoachInfo();
		coachInfo.setId(24);
		request.getSession().setAttribute("userInfo", coachInfo);
		request.setMethod("POST");
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
