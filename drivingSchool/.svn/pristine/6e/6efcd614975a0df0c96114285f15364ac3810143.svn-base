package com.HuiShengTec.app.dao;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.LessonReview;
import com.HuiShengTec.entity.ReviewReply;

/**
 * 教员评分统计
 * @author llj
 *
 */
public interface ILessonReviewDao extends IBaseDao {
	
	/**
	 * 评分统计
	 * @param string
	 * @return
	 */
	List<Map<String, Object>> queryLessonReview(String cohId);

	/**
	 * 评论查询
	 * @param bean
	 * @return
	 */
	List<Map<String, Object>> queryLessonReviewPage(PageBean bean);
	
	/**
	 * 删除评论
	 * @param ids
	 * @return
	 */
	Integer delLessonReview(String[] ids);
	
	/**
	 * 删除回复
	 * @param ids
	 * @return
	 */
	Integer delReply(String[] ids);
	
	/**
	 * 隐藏评论
	 * @param ids
	 * @return
	 */
	Integer hideLessonReview(Map<String,Object> param);
	
	/**
	 * 新增 回复内容
	 * @param reply
	 * @return
	 */
	int insertReply(ReviewReply reply);
	
	public void addLessonReview(LessonReview lessonReview);
	
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
