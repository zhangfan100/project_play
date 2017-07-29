package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestVehicleMonitorAction extends BaseActionJunit {

	@Test
	public void testpaymentAccountLog() throws Exception {
		request.setRequestURI("/mag/getFirstJudge"); 
		request.setMethod("POST");    
		request.addParameter("lng", "104.053556");
		request.addParameter("lat", "30.680067");
		request.addParameter("carId", "6");
		
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}

