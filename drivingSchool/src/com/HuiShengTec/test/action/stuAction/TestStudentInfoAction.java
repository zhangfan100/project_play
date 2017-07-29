package com.HuiShengTec.test.action.stuAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.entity.StudentInfo;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestStudentInfoAction extends BaseActionJunit{

	@Test
	public void testeditStudentInfo() throws Exception {
		request.setRequestURI("/stu/editStudentInfo"); 
		StudentInfo login = new StudentInfo();
		login.setId(62);
		request.getSession().setAttribute("userInfo", login);
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav.getViewName());
	}
	
	@Test
	public void testeditStuLoginInfo() throws Exception {
		request.setRequestURI("/stu/editStuLoginInfo"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav.getViewName());
	}
	@Test
	public void testeditStudentInfoSubmit() throws Exception {
		request.setRequestURI("/stu/editStudentInfoSubmit"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav.getViewName());
	}

}
