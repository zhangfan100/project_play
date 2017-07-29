package com.HuiShengTec.test.action.cohAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.test.basejunit.BaseActionJunit;
import com.HuiShengTec.utils.Toolkit;

public class TestCoachMyStudentAction extends BaseActionJunit {

	@Test
	public void testmyStudent() throws Exception {
		request.setRequestURI("/coh/myStudent"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav.getModel().size());
	}
	@Test
	public void testqueryMyStudentPage() throws Exception {
		request.setRequestURI("/coh/queryMyStudentPage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav.getModel().size());
	}
}
