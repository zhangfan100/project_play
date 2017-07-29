package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestStudentLotteryInfoAction extends BaseActionJunit {

	@Test
	public void teststudentLotteryInfoManage() throws Exception {
		request.setRequestURI("/mag/studentLotteryInfoManage"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	@Test
	public void testquerystudentLotteryInfoPage() throws Exception {
		request.setRequestURI("/mag/querystudentLotteryInfoPage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
