package com.HuiShengTec.app.magAction;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ILessonReviewService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.ReviewReply;
import com.HuiShengTec.utils.Toolkit;

/**
 * 评论管理
 * 
 * @author llj
 * 
 */

@Controller
@RequestMapping("mag")
public class MagLessonReviewAction extends BaseAction {
	@Autowired
	private ILessonReviewService iLessonReviewService;

	@RequestMapping("/magLessonReview")
	public String view() {
		return "manage/magLessonReviewAction/magLessonReview";
	}

	@RequestMapping("/queryLessonReviewPage")
	@ResponseBody
	public PageBean queryLessonReviewPage(PageInfo info, @DateTimeFormat(pattern="yyyy-MM-dd")Date beginDate, @DateTimeFormat(pattern="yyyy-MM-dd")Date endDate, String keyWord) {
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("beginDate", beginDate);
		pageBean.addConditions("endDate", endDate);
		pageBean.addConditions("keyWord", keyWord);
		return iLessonReviewService.queryLessonReviewPage(pageBean);

	}
	

	/**
	 * 评论回复
	 */
	@ResponseBody
	@RequestMapping("/updateReply")
	public Integer updateReply(ReviewReply reply){
		return iLessonReviewService.updateReply(reply);
	}
	/**
	 * queryReply
	 */
	@ResponseBody
	@RequestMapping("/queryReply")
	public Map<String,Object> queryReply(Integer id,Integer reviewId){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("reviewId", reviewId);
		return iLessonReviewService.queryReply(param);
	}
	

	/**
	 * 根据ID，删除评论
	 * 有值是，根据ID删除，无值是删除全部
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delLessonReview")
	@ResponseBody
	public Integer delLessonReview(String ids){
		String[] param = null;
		if(ids!=null)
			param = ids.split(",");
		return iLessonReviewService.delLessonReview(param);
	}
	

	/**
	 * 隐藏评论
	 */
	@ResponseBody
	@RequestMapping("/hideLessonReview")
	public Integer hideLessonReview(String ids,Integer isDisplay){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("isDisplay", isDisplay);
		param.put("ids", ids.split(","));
		return iLessonReviewService.hideLessonReview(param);
	}
}
