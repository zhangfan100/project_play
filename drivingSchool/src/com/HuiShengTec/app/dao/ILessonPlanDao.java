package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.entity.LessonPlan;

public interface ILessonPlanDao extends IBaseDao {
	public Integer queryLessonPlanCount();
	public void addLessonPlan(LessonPlan plan);
	
	public List<HashMap<String, Object>> queryLessonPlanByCoachId(HashMap<String, Object> condition);
	public List<HashMap<String, Object>> queryLessonPlanByDuty(HashMap<String, Object> condition);

	public void updateLessonPlan(LessonPlan plan);
	
	public void resetLessonPlan(List<Integer> list);
	
	public Integer queryIsUseLessonPlan(Map<String, Object> param);
	
	public HashMap<String, Object> queryIsExistLessonPlan(HashMap<String, Object> param);
	/**
	 * 取消预约 时修改课程表的状态为没有预约 并且设置学生Id为null
	 * @param idStr
	 */
	public void resetLessonPlan(int idStr);
	
}
