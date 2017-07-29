package com.HuiShengTec.test.action.magAction;


import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import com.HuiShengTec.test.basejunit.BaseActionJunit;

public class TestMagLessonReviewAction extends BaseActionJunit {

	@Test
	public void testmagLessonReview() throws Exception {
		request.setRequestURI("/mag/magLessonReview"); 
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav);
	}
	
	@Test
	public void testqueryLessonReviewPage() throws Exception {
		request.setRequestURI("/mag/queryLessonReviewPage"); 
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
	
	@Test
	public void testupdateReply() throws Exception {
		request.setRequestURI("/mag/updateReply"); 
		request.addParameter("reviewId", "9");
		request.addParameter("replyContent", "开快点撒");
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
	}
}
