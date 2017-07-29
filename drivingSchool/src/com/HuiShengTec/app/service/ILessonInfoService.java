package com.HuiShengTec.app.service;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;

public interface ILessonInfoService {
	
	public PageBean queryLessonInfoPage(PageInfo info);
	
	public HashMap<String, Object> queryStuLessonInfoDetail(Integer id);

	public List<HashMap<String, Object>> queryStuLessonPlanInfo(Integer stuId);

	public List<HashMap<String, Object>> queryCoachTimePlan(Integer stuId,
			Date planDate);
	
	public HashMap<String, Object> addLessonInfo(String jsonStr) throws ParseException;
	
	public List<HashMap<String, Object>> queryOrderLessionInfo(Integer userId);
	
	/**
	 * ajax加载课程预约
	 * @param stuId
	 * @return
	 */
	public List<HashMap<String, Object>> queryStuLessonInfoPlanList(Integer stuId);
	
	/**
	 * 查询科目二和三所有完成和完成异常的总合
	 * @param stuId
	 * @return
	 */
	public HashMap<String, Object> queryStuLessonInfoCount(Integer stuId);

	/**
	 * 前台ajax取消预约
	 * @param idStr
	 */
	public void cancleLessonPlan(String idStr);

	/**
	 * 加载科目二或者科目三的培训完成 培训异常的详情
	 * @param id
	 * @param subject
	 * @return
	 */
	public List<HashMap<String, Object>> queryStuLessonTrainInfo(Integer id,
			Integer subject);

	/**
	 * 添加评论跳转
	 * @param lessonInfoId
	 * @return
	 */
	public HashMap<String,Object> getLessonInfoById(Integer lessonInfoId);

	public List<HashMap<String, Object>> queryLessonMinusDetail(Integer lessonInfoId);

	/**
	 * 管理员后台确认缴费
	 * @param id
	 * @param id2
	 */
	public void confirmPayment(Integer lessonInfoId,float cash, Integer sysId,String cashContent);

	/**
	 * 查询出学生预约中没有缴费的
	 * @param stuId
	 * @return
	 */
	public List<Map<String, Object>> queryLessonInfoByStuId(Integer stuId);

}
