package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.test.basejunit.BaseActionJunit;
import com.HuiShengTec.utils.Toolkit;

public class TestCoachGroupAction extends BaseActionJunit{

	@Test
	public void testQueryUnusedCoachPage() throws Exception {
		request.setRequestURI("/mag/queryUnusedCoachPage"); 
		PageInfo info = new PageInfo();
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("weekDay",1);
		pageBean.addConditions("timeSlot",1);
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav.getModel().size());
	}
	@Test
	public void testQueryUsedCoachPage() throws Exception {
		request.setRequestURI("/mag/queryUsedCoachPage"); 
		PageInfo info = new PageInfo();
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("weekDay",1);
		pageBean.addConditions("timeSlot",1);
		pageBean.addConditions("subject",1);
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav.getModel().size());
	}

	@Test
	public void testJoinCoachGroup() throws Exception {
		request.setRequestURI("/mag/joinCoachGroup");    
        request.addParameter("weekDay", "2");    
        request.addParameter("subject", "1");    
        request.addParameter("timeSlot", "1");    
        request.addParameter("cohIds", "24");    
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav.getViewName());
	}

	@Test
	public void testRemoveCoachGroup() throws Exception {
		request.setRequestURI("/mag/removeCoachGroup");    
        request.addParameter("weekDay", "2");    
        request.addParameter("subject", "1");    
        request.addParameter("timeSlot", "1");    
        request.addParameter("groupIds", "24");    
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav.getViewName());
	}

}
