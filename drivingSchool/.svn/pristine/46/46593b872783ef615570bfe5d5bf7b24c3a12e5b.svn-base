package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.entity.Login;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestMessageAction extends BaseActionJunit {


	@Test
	public void testmessageManage() throws Exception {
		request.setRequestURI("/mag/messageManage"); 
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testaddMessage() throws Exception {
		request.setRequestURI("/mag/addMessage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testeditMessage() throws Exception {
		request.setRequestURI("/mag/editMessage"); 
		request.addParameter("id", "2");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testqueryMessagePage() throws Exception {
		request.setRequestURI("/mag/queryMessagePage"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testqueryMessageKind() throws Exception {
		request.setRequestURI("/mag/queryMessageKind"); 
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testaddMessageSubmit() throws Exception {
		request.setRequestURI("/mag/addMessageSubmit");
		Login login = new Login();
		login.setUserId(1);
		request.getSession().setAttribute("loginInfo", login);
		request.addParameter("kindID", "1");
		request.addParameter("title", "23dfg");
		request.addParameter("content", "231");
		request.addParameter("seperateSchoolId", "1");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	@Test
	public void testeditMessageSubmit() throws Exception {
		request.setRequestURI("/mag/editMessageSubmit");
		Login login = new Login();
		login.setUserId(1);
		request.getSession().setAttribute("loginInfo", login);
		request.addParameter("kindID", "1");
		request.addParameter("id", "42");
		request.addParameter("title", "22222222222222");
		request.addParameter("content", "3333333333");
		request.addParameter("seperateSchoolId", "1");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testdeleteMessageByID() throws Exception {
		request.setRequestURI("/mag/deleteMessageByID");
		request.addParameter("kindId", "1");
		request.addParameter("ids", "42");
		request.setMethod("POST");    
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	
}
