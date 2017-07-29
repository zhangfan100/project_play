package com.HuiShengTec.app.service;

import java.util.Map;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.ReviewReply;
import com.HuiShengTec.entity.TrainReview;

/**
 * 评论管理
 * @author mihuajun
 *
 */
public interface ICommentService {
	
	/**
	 * 分页显示评论
	 * @param bean
	 * @return
	 */
	PageBean queryCommentPage(PageBean bean);
	
	/**
	 * 根据IDS删除评论
	 * @param param
	 * @return
	 */
	Integer delComment(String[] ids);
	
	/**
	 * 隐藏评论
	 * @param split
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
	
	public void addTrainReview(TrainReview review);

}
