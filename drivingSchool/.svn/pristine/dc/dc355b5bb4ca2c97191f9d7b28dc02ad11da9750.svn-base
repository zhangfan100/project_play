package com.HuiShengTec.app.dao;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.ReviewReply;
import com.HuiShengTec.entity.TrainReview;

/**
 * 评论管理dao
 * @author mihuajun
 *
 */
public interface ICommentDao extends IBaseDao {

	List<Map<String, Object>> queryCommentPage(PageBean bean);
	
	/**
	 * 删除评论
	 * @param ids
	 * @return
	 */
	Integer delComment(String[] ids);
	
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
	Integer hideComment(Map<String,Object> param);
	
	/**
	 * 查询评论对应回复
	 * @param id
	 * @return
	 */
	Map<String, Object> queryReply(Map<String,Object> param);
	
	/**
	 * 更新回复
	 * @param reply
	 * @return
	 */
	Integer updateReply(ReviewReply reply);
	
	/**
	 * 新增 回复内容
	 * @param reply
	 * @return
	 */
	int insertReply(ReviewReply reply);
	
	public void addTrainReview(TrainReview review);
	
}
