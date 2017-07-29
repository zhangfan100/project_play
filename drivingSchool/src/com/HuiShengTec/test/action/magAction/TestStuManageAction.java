package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestStuManageAction extends BaseActionJunit {

	@Test
	public void teststuManage() throws Exception {
		request.setRequestURI("/mag/stuManage"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	@Test
	public void testaddStudentSubmit() throws Exception {
		request.setRequestURI("/mag/addStudentSubmit"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
