package com.HuiShengTec.app.service;

import java.util.Map;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.ReviewReply;

/**
 * 教学评论统计
 * @author llj
 *
 */
public interface ILessonReviewService {
	
	/**
	 * 评分统计
	 * @param param
	 * @return
	 */
	Map<String, Object> queryLessonReview(Map<String, Object> param);

	/**
	 * 分页显示评论
	 * @param bean
	 * @return
	 */
	PageBean queryLessonReviewPage(PageBean bean);
	
	/**
	 * 根据IDS删除评论
	 * @param param
	 * @return
	 */
	Integer delLessonReview(String[] ids);
	/**
	 * 隐藏
	 * @param param
	 * @return
	 */
	Integer hideLessonReview(Map<String, Object> param);
	/**
	 * 更新回复
	 * @param reply
	 * @return
	 */
	Integer updateReply(ReviewReply reply);
	
	/**
	 * 查询评论对应回复
	 * @param id
	 * @return
	 */
	Map<String, Object> queryReply(Map<String,Object> param);
}
