package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.LessonInfo;

public interface ILessonInfoDao extends IBaseDao {
	public List<HashMap<String, Object>> queryLessonInfoPage(PageBean page);
	public List<HashMap<String, Object>> queryStuLessonPlanInfo(Integer stuId);
	public Integer addLessonInfo(LessonInfo info);
	public Integer querySingleLessonInfoIdByCode(String lessonCode);
	public void delLessonInfo(List<Integer> list);
	public List<HashMap<String, Object>> queryCohLessonInfo(PageBean page);
	
	public List<HashMap<String, Object>> queryStuLessonInfoList(HashMap<String, Object> condition);
	//查询所有的科目二 三完成和完成异常的总人数
	public List<HashMap<String, Object>> queryStuLessonInfoCount(Integer stuId);
	
	/**
	 * 查询科目二 科目三培训完成 异常的详情
	 * @param condition
	 * @return
	 */
	public List<HashMap<String, Object>> queryStuLessonTrainInfo(HashMap<String,Object> condition);


	public HashMap<String, Object> queryStuLessonInfoDetail(Integer lessonInfoId);
	
	public List<HashMap<String, Object>> queryLessonMinusDetail(Integer lessonInfoId);
	
	public LessonInfo queryDataByIdForUpdate(Integer id);

	public HashMap<String, Object> getLessonInfoById(int id);
	
	
	
	/**
	 * 第二版查询教师课程记录
	 * @param param
	 * @return
	 */
	public List<HashMap<String, Object>> queryCohLessonPlan(HashMap<String, Object> param);
	
	public List<HashMap<String, Object>> queryOrderLessionInfo(Integer userId);
	/**
	 * ajax通过登录学生id得到预约课程
	 * @param stuId
	 * @return
	 */
	public List<HashMap<String, Object>> queryStuLessonInfoPlanList(
			Integer stuId);
	/**
	 * 取消预约时 删除lessoninfo表中对应的ID
	 * @param idStr
	 */
	public void delLessonInfo(int idStr);
	/**
	 * 确认缴费
	 */
	public void confirmPayment(HashMap<String, Object> condition);
	
	/**
	 * 查询出学生预约中没有缴费的
	 * @param stuId
	 * @return
	 */
	public List<Map<String, Object>> queryLessonInfoByStuId(Integer stuId);
	
	
} 
