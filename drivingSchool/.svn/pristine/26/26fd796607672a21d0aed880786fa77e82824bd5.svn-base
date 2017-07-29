package com.HuiShengTec.app.cohAction;

import java.util.HashMap;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ILessonReviewService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 教评论统计
 * @author llj
 *
 */

@Controller
@RequestMapping("coh")
public class LessonReviewAction extends BaseAction {
	
	@Autowired
	private ILessonReviewService iLessonReviewService;
	
	@RequestMapping("/lessonReview")
	public String view(){
		return "coach/lessonReviewAction/lessonReview";
	}
	
	/**
	 * 评论统计
	 * @return
	 */
	@RequestMapping("/querylessonReview")
	@ResponseBody
	public Map<String,Object> querylessonReview(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("cohId",getCurrLoginCoach().getId());
		return iLessonReviewService.queryLessonReview(param);
	}
	
	
}
