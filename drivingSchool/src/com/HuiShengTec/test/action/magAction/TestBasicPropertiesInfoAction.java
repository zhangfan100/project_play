package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestBasicPropertiesInfoAction extends BaseActionJunit{

	@Test
	public void testBasicPropeInfoManage() throws Exception {
		request.setRequestURI("/mag/basicPropeInfoManage"); 
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav.getViewName());
	}
	
	@Test
	public void testQueryBasicPropeInfoPage() throws Exception {
		request.setRequestURI("/mag/queryBasicPropeInfoPage"); 
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav.getViewName());
	}
	
	@Test
	public void testUpdateSbmitBasicPropeInfo() throws Exception {
		request.setRequestURI("/mag/updateSbmitBasicPropeInfo"); 
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav.getViewName());
	}
	
}
