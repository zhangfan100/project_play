package com.HuiShengTec.app.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ICommentDao;
import com.HuiShengTec.app.service.ICommentService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.ReviewReply;
import com.HuiShengTec.entity.TrainReview;

/**
 * 评论管理
 * @author mihuajun
 *
 */
@Transactional
@Service
public class CommentServiceImpl implements ICommentService {
	
	@Autowired
	private ICommentDao iCommentDao;
	
	/**
	 * 分页显示评论
	 * @param bean
	 * @return
	 */
	@Override
	public PageBean queryCommentPage(PageBean bean) {
		// TODO Auto-generated method stub
		bean.setRows(iCommentDao.queryCommentPage(bean));
		return bean;
	}
	
	/**
	 * 根据IDS删除评论
	 * @param param
	 * @return
	 */
	@Override
	public Integer delComment(String[] ids) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		int len2 = iCommentDao.delReply(ids);
		int len1 = iCommentDao.delComment(ids);
		
		return len1>0?0:1;
	}
	
	/**
	 * 隐藏评论
	 * @param split
	 * @return
	 */
	@Override
	public Integer hideComment(Map<String,Object> param) {
		// TODO Auto-generated method stub
		return iCommentDao.hideComment(param)>0?0:1;
	}

	
	
	/**
	 * 查询评论对应回复
	 * @param id
	 * @return
	 */
	@Override
	public Map<String, Object> queryReply(Map<String,Object> param) {
		// TODO Auto-generated method stub
		return iCommentDao.queryReply(param);
	}
	
	/**
	 * 更新回复
	 */
	@Override
	public Integer updateReply(ReviewReply reply) {
		// TODO Auto-generated method stub
		int len = 0;
		//无就插入，有就更新
		if(reply.getId()==null || reply.getId().toString().isEmpty()){
			len = iCommentDao.insertReply(reply);
		}else{
			len = iCommentDao.updateReply(reply);
		}
		
		return len>0?0:1;
	}
	public void addTrainReview(TrainReview review){
		iCommentDao.addTrainReview(review);
	}
}	

