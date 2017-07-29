package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestPrizeInfoAction extends BaseActionJunit {


	@Test
	public void testaddPrizeInfo() throws Exception {
		request.setRequestURI("/mag/addPrizeInfo"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testeditPrizeInfo() throws Exception {
		request.setRequestURI("/mag/editPrizeInfo"); 
		request.addParameter("id", "13");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testaddPrizeInfoSubmit() throws Exception {
		request.setRequestURI("/mag/addPrizeInfoSubmit"); 
		request.addParameter("id", "17");
		request.addParameter("prizeName", "2134");
		request.addParameter("picId", "2");
		request.addParameter("type", "1");
		request.addParameter("prizeCount", "17");
		request.addParameter("prizeBeginDate", "2014-01-20 22:12:45");
		request.addParameter("prizeEndDate", "2014-01-20 22:12:45");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testeditPrizeInfoSubmit() throws Exception {
		request.setRequestURI("/mag/editPrizeInfoSubmit"); 
		request.addParameter("id", "17");
		request.addParameter("prizeName", "2222222222");
		request.addParameter("picId", "2");
		request.addParameter("type", "1");
		request.addParameter("prizeCount", "17");
		request.addParameter("prizeBeginDate", "2014-01-20 22:12:45");
		request.addParameter("prizeEndDate", "2014-01-20 22:12:45");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
