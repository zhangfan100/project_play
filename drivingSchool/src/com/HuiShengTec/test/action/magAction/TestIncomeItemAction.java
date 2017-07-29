package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestIncomeItemAction extends BaseActionJunit {

	@Test
	public void testqueryItemByKeyWord() throws Exception {
		request.setRequestURI("/mag/queryItemByKeyWord"); 
		request.setMethod("POST");  
		//request.addParameter("q", "");
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	
	@Test
	public void testincomeItemManage() throws Exception {
		request.setRequestURI("/mag/incomeItemManage"); 
		request.setMethod("POST");  
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testaddIncomeItem() throws Exception {
		request.setRequestURI("/mag/addIncomeItem"); 
		request.setMethod("POST");  
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testeditIncomeItem() throws Exception {
		request.setRequestURI("/mag/editIncomeItem"); 
		request.addParameter("id", "1");
		request.setMethod("POST");  
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testsubmitEditIncomeItem() throws Exception {
		request.setRequestURI("/mag/submitEditIncomeItem"); 
		request.setMethod("POST");  
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testqueryIncomeItemByPage() throws Exception {
		request.setRequestURI("/mag/queryIncomeItemByPage"); 
		request.setMethod("POST");  
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	
}
