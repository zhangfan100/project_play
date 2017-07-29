package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.entity.SysAdminInfo;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestCoachPaymentAction extends BaseActionJunit {

	@Test
	public void testqueryCoachPaymentInfoPage() throws Exception {
		request.setRequestURI("/mag/queryCoachPaymentInfoPage"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testaddCoachPaymentInfoPage() throws Exception {
		request.setRequestURI("/mag/addCoachPaymentInfoPage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testquerycoachPaymentInfo() throws Exception {
		request.setRequestURI("/mag/querycoachPaymentInfo"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testconfirmAddCoachPayment() throws Exception {
		request.setRequestURI("/mag/confirmAddCoachPayment"); 
		request.addParameter("coachId", "24");
		request.addParameter("coachName", "杨吉");
		request.addParameter("paymentItem", "买白菜");
		request.addParameter("cash", "24.67");
		request.addParameter("realCash", "45.24");
		request.addParameter("coachId", "24");
		SysAdminInfo s = new SysAdminInfo();
		s.setId(3);
		request.getSession().setAttribute("userInfo", s);
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
