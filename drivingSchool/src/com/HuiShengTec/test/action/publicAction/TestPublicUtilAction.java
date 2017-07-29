package com.HuiShengTec.test.action.publicAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestPublicUtilAction extends BaseActionJunit {

	@Test
	public void testgetVerificationCode() throws Exception {
		request.setRequestURI("/getVerificationCode");  
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response); 
        System.out.println(mav);
    }
	
	@Test
	public void testqueryCurrLicenceList() throws Exception {
		request.setRequestURI("/queryCurrLicenceList");  
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response); 
		System.out.println(mav);
	}
	
	@Test
	public void testqueryCurrCarBrand() throws Exception {
		request.setRequestURI("/queryCurrCarBrand");  
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response); 
		System.out.println(mav);
	}
	
}
