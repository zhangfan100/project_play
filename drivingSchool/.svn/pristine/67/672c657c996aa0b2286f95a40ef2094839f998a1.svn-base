package com.HuiShengTec.app.mobileCoachAction;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ILessonReviewService;
import com.HuiShengTec.utils.Toolkit;

/**
 * 教评论统计
 * @author llj
 */

@Controller
@RequestMapping("cohMobile")
public class MobLessonReviewAction extends BaseAction{
	
	@Autowired
	private ILessonReviewService iLessonReviewService;
	
	/**
	 * 评论统计
	 * @return
	 */
	@RequestMapping("/querylessonReview")
	@ResponseBody
	public Map<String,Object> querylessonReview(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("cohId",getCurrLoginCoach().getId());
		Map<String, Object> data=iLessonReviewService.queryLessonReview(param);
	    return Toolkit.initMapCondition("data", data);
	}

}
