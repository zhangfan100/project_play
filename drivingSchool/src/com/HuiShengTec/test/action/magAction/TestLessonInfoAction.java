package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.entity.SysAdminInfo;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestLessonInfoAction extends BaseActionJunit {

	@Test
	public void testlessonInfoManage() throws Exception {
		request.setRequestURI("/mag/lessonInfoManage"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testqueryLessonInfoPage() throws Exception {
		request.setRequestURI("/mag/queryLessonInfoPage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testshowPaymentInfo() throws Exception {
		request.setRequestURI("/mag/showPaymentInfo"); 
		request.addParameter("id", "392");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testgetPaymentInfo() throws Exception {
		request.setRequestURI("/mag/getPaymentInfo"); 
		request.addParameter("id", "392");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testconfirmPayment() throws Exception {
		request.setRequestURI("/mag/confirmPayment"); 
		request.addParameter("lessonInfoId", "393");
		request.addParameter("cash", "392");
		request.addParameter("cashContent", "交钱了");
		request.addParameter("id", "392");
		SysAdminInfo s = new SysAdminInfo();
		s.setId(1);
		request.getSession().setAttribute("userInfo", s);
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testgetTotalPrice() throws Exception {
		request.setRequestURI("/mag/getTotalPrice"); 
		request.addParameter("stuId", "65");
		request.addParameter("cohId", "27");
		request.addParameter("studyDate", "2015-4-19");
		request.addParameter("studyTime", "08:00-09:59");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testaddLessonInfo() throws Exception {
		request.setRequestURI("/mag/addLessonInfo"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testqueryStuLessonPlanInfo() throws Exception {
		request.setRequestURI("/mag/queryStuLessonPlanInfo"); 
		request.addParameter("stuId", "65");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testqueryTeacherTimePlan() throws Exception {
		request.setRequestURI("/mag/queryTeacherTimePlan"); 
		request.addParameter("stuId", "65");
		request.addParameter("studyDate", "2015-4-19");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testaddLessonInfoSubmit() throws Exception {
		request.setRequestURI("/mag/addLessonInfoSubmit"); 
		String s = "[{'stuId':'64','lessonCode':'未保存','studyDate':'2015-04-15','subject':1,'studyTime':'08:00-10:59','name':'杨吉','price':'791','status':-1,'student':1,'cohId':27}]";
		request.addParameter("jsonStr", s);
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testcancelLessonPlan() throws Exception {
		request.setRequestURI("/mag/cancelLessonPlan"); 
		request.addParameter("idStr", "400");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	
}
