package com.HuiShengTec.app.mobileStuAction;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ICommentService;
import com.HuiShengTec.app.service.ILessonInfoService;
import com.HuiShengTec.entity.TrainReview;
import com.HuiShengTec.utils.Toolkit;

/**
 * 学生评论添加
 * @author llj
 *
 */
@Controller
@RequestMapping("/mobile")
public class MobStuCommentAction extends BaseAction{
	
//	@Autowired
//	private ILessonInfoService iLessonInfoService;
//	@Autowired
//	private ICommentService iCommentService;
//	
//	/**
//	 * 添加评论跳转
//	 * @param lessonInfoId
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("queryComment")
//	public HashMap<String, Object> addComment(Integer lessonInfoId){
//		return iLessonInfoService.getLessonInfoById(lessonInfoId);
//	}
//	/**
//	 * 添加评论
//	 * @param review
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("addCommentSubmit")
//	public HashMap<String, Object> addCommentSubmit(TrainReview review){
//		review.setIsDisplay(1);
//		review.setIsNew(1);
//		review.setStuId(getCurrLoginStudent().getId());
//		HashMap<String,Object> teacherData = iLessonInfoService.getLessonInfoById(review.getLessonInfoId());
//		review.setCoachId((Integer)teacherData.get("coachId"));
//		int count=0;
//		/**
//		 * 计算总分
//		 */
//		if(!Toolkit.isEmpty(review.getQualityScore())){
//			count++;
//		}else{
//			review.setQualityScore(0F);
//		}
//		if(!Toolkit.isEmpty(review.getRuleScore())){
//			count++;
//		}else{
//			review.setRuleScore(0F);
//		}
//		if(!Toolkit.isEmpty(review.getServiceScore())){
//			count++;
//		}else{
//			review.setServiceScore(0F);
//		}
//		//计算平均分
//		Float totalScore=null;
//		if(count!=0){
//			totalScore=((review.getQualityScore()
//					+review.getRuleScore()
//					+review.getServiceScore()))/count;
//			BigDecimal b = new BigDecimal(totalScore);
//			totalScore = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue(); 
//		}
//		review.setTotalScore(totalScore);
//		iCommentService.addTrainReview(review);
//		return Toolkit.initMapCondition("state", 1);
//	}

}
