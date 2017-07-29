package com.HuiShengTec.test.action.cohAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestCoachWeekLessonConfigAction extends BaseActionJunit {
	
	@Test
	public void testToQueryAllWeekSetting() throws Exception {
		request.setRequestURI("/coh/toQueryAllWeekSetting");    
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response); 
        System.out.println(mav.getViewName());
   }

	@Test
	public void testEditSettingInfo() throws Exception {
        request.setRequestURI("/coh/editSettingInfo");    
        request.addParameter("id", "2");    
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav.getViewName());
	}

	@Test
	public void testQueryAllWeekSetting() throws Exception{
		request.setRequestURI("/coh/queryAllWeekSetting"); 
		Login login = new Login();
		login.setUserId(24);
		request.getSession().setAttribute("loginInfo", login);
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav.getModel().size());
	}

	@Test
	public void testEditSettingSubmit() throws Exception {
		request.setRequestURI("/coh/editSettingSubmit"); 
		request.addParameter("id", "1");
		request.addParameter("coachId", "24");
		request.addParameter("weekDay", "0");
		request.addParameter("timeSlot", "1");
		request.addParameter("subject", "1");
		request.addParameter("timeSlotType", "2");
        request.setMethod("POST");    
        // 执行URI对应的action    
        this.excuteAction(request, response);
	}

	@Test
	public void testQueryAllWeekSettingByPage() throws Exception {
		request.setRequestURI("/coh/queryAllWeekSettingByPage"); 
		Login login = new Login();
		login.setUserId(24);
		request.getSession().setAttribute("loginInfo", login);
		request.addParameter("page", "1");
		request.addParameter("rows", "1");
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
	}

}
