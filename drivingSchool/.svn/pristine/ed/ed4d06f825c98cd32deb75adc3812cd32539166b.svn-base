package com.HuiShengTec.app.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ILessonReviewDao;
import com.HuiShengTec.app.service.ILessonReviewService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.ReviewReply;

/**
 * 评分统计
 * @author llj
 *
 */
@Service
@Transactional
public class LessonReviewServiceImpl implements ILessonReviewService {
	
	@Autowired
	private ILessonReviewDao iLessonReviewDao;
	
	/**
	 * 评分统计
	 */
	@Override
	public Map<String, Object> queryLessonReview(Map<String, Object> param) {
		// TODO Auto-generated method stub
		Integer coachId=(Integer)param.get("cohId");
		String cohId = Integer.toString(coachId);
		List<Map<String,Object>> list = iLessonReviewDao.queryLessonReview(cohId);
		Map<String,Object> result = new HashMap<String, Object>();
		
		double score = 0;
		int total = 0;
		for(Map<String,Object> item:list){
			result.put(String.valueOf(item.get("totalScore")),item.get("total"));
			score += ((BigDecimal )item.get("score")).doubleValue();
			total+= (Long) item.get("total");
		}
		//计算得出综合评分
		result.put("compositeScore", score/(total==0?1:total));
		return result;
	}

	@Override
	public PageBean queryLessonReviewPage(PageBean bean) {
				bean.setRows(iLessonReviewDao.queryLessonReviewPage(bean));
				return bean;
	}

		/**
		 * 根据IDS删除评论
		 * @param param
		 * @return
		 */
		@Override
		public Integer delLessonReview(String[] ids) {
			// TODO Auto-generated method stub
			@SuppressWarnings("unused")
			//删除回复
			int len2 = iLessonReviewDao.delReply(ids);
			//删除评论
			int len1 = iLessonReviewDao.delLessonReview(ids);
			
			return len1>0?0:1;
		}
		
		/**
		 * 隐藏评论
		 * @param split
		 * @return
		 */
		@Override
		public Integer hideLessonReview(Map<String,Object> param) {
			// TODO Auto-generated method stub
			return iLessonReviewDao.hideLessonReview(param)>0?0:1;
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
				len = iLessonReviewDao.insertReply(reply);
			}else{
				len = iLessonReviewDao.updateReply(reply);
			}
			
			return len>0?0:1;
		}

		@Override
		public Map<String, Object> queryReply(Map<String, Object> param) {
			// TODO Auto-generated method stub
			return iLessonReviewDao.queryReply(param);
		}

	}
	
