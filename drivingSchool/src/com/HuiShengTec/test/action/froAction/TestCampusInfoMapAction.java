package com.HuiShengTec.test.action.froAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestCampusInfoMapAction extends BaseActionJunit {

	@Test
	public void testqueryCampus() throws Exception {
		request.setRequestURI("/queryCampus"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	@Test
	public void testqueryCampusInfo() throws Exception {
		request.setRequestURI("/queryCampusInfo"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testqueryCampusInfoId() throws Exception {
		request.setRequestURI("/queryCampusInfoId"); 
		request.addParameter("id", "24");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
