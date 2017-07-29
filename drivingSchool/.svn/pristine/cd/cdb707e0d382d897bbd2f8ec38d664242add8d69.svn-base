package com.HuiShengTec.test.action.magAction;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestExcelDownLoadAction extends BaseActionJunit {

	@Test
	public void testdownLoadData() throws Exception {
		request.setRequestURI("/mag/downLoadData"); 
		request.addParameter("statisticType", "1");
		request.addParameter("beginTime", "2015-05-05");
		request.addParameter("endTime", "2015-05-05");
        request.setMethod("POST");    
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
    
}
