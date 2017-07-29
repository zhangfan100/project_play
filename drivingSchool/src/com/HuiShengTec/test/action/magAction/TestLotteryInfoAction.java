package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestLotteryInfoAction extends BaseActionJunit {

	@Test
	public void testlotteryInfoManage() throws Exception {
		request.setRequestURI("/mag/lotteryInfoManage"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testaddLottery() throws Exception {
		request.setRequestURI("/mag/addLottery"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testqueryLotteryInfoPage() throws Exception {
		request.setRequestURI("/mag/queryLotteryInfoPage");
		request.addParameter("beginDate", "2014-05-24");
		request.addParameter("endDate", "2015-05-24");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testeditLottery() throws Exception {
		request.setRequestURI("/mag/editLottery");
		request.addParameter("id", "2");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testqueryLotteryInfo() throws Exception {
		request.setRequestURI("/mag/queryLotteryInfo");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testeditLotterySubmit() throws Exception {
		request.setRequestURI("/mag/editLotterySubmit");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
