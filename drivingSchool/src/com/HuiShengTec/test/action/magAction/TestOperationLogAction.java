package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestOperationLogAction extends BaseActionJunit {


	@Test
	public void testlotteryInfoManage() throws Exception {
		request.setRequestURI("/mag/operationLogManage"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	
	@Test
	public void testqueryOperationLogPage() throws Exception {
		request.setRequestURI("/mag/queryOperationLogPage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testdelOperationLog() throws Exception {
		request.setRequestURI("/mag/delOperationLog"); 
		request.addParameter("ids", "349");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
