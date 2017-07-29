package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.entity.SysAdminInfo;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestStuPaymentAction extends BaseActionJunit {

	@Test
	public void testqueryStuPaymentInfoPage() throws Exception {
		request.setRequestURI("/mag/queryStuPaymentInfoPage"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testaddStuPaymentInfoPage() throws Exception {
		request.setRequestURI("/mag/addStuPaymentInfoPage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testqueryStuPaymentInfo() throws Exception {
		request.setRequestURI("/mag/queryStuPaymentInfo"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testqueryLessonInfoByStuId() throws Exception {
		request.setRequestURI("/mag/queryLessonInfoByStuId"); 
		request.addParameter("stuId", "65");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testconfirmAddStuPayment() throws Exception {
		request.setRequestURI("/mag/confirmAddStuPayment"); 
		request.addParameter("stuId", "65");
		request.addParameter("stuName", "沈俊东");
		request.addParameter("paymentType", "1");
		request.addParameter("paymentItem", "买了猪肉");
		request.addParameter("cash", "65");
		request.addParameter("realCash", "34");
		request.addParameter("payType", "1");
		SysAdminInfo s = new SysAdminInfo();
		s.setId(3);
		request.getSession().setAttribute("userInfo", s);
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
}
