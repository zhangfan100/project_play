package com.HuiShengTec.test.action.stuAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.entity.StudentInfo;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class StuTestInfoActionTest extends BaseActionJunit {

	@Test
	public void testaddTestInfo() throws Exception {
		request.setRequestURI("/stu/addTestInfo"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	@Test
	public void testInfoManage() throws Exception {
		request.setRequestURI("/stu/testInfoManage"); 
		StudentInfo st = new StudentInfo();
		st.setId(103);
		request.getSession().setAttribute("userInfo", st);
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testcancelPExam() throws Exception {
		request.setRequestURI("/stu/cancelPExam"); 
		request.addParameter("id", "265");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
