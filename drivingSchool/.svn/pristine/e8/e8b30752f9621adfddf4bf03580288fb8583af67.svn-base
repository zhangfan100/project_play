package com.HuiShengTec.app.dao;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.CoachWeekLessonConfig;

public interface ICoachWeekLessonConfigDao extends IBaseDao{

	/**
	 * 新增周课程设置
	 * @param coachWeekLessonConfig
	 */
	public void insertCoachWeekLessonConfig(CoachWeekLessonConfig coachWeekLessonConfig);
	
	/**
	 * 查询出所有的课程设置
	 * @param coachWeekLessonConfig
	 */
	public List<Map<String, Object>> queryAllWeekSetting(Integer coachId);
	
	/**
	 * 分页查询课程设置
	 * @param pageBean
	 * @return
	 */
	public List<CoachWeekLessonConfig> queryAllWeekSettingById(PageBean pageBean);

	/**
	 * 通过教练id得到课程设置
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryCoachWeekLessonConfigById(Integer id);

	/**
	 * 保存修改的课程设置
	 * @param coachWeekLessonConfig
	 * @return
	 */
	public Integer editSettingSubmit(CoachWeekLessonConfig coachWeekLessonConfig);

	/**
	 * 添加课程设置
	 * @param coachWeekLessonConfig
	 */
	public void addWeeklessonconfig(CoachWeekLessonConfig coachWeekLessonConfig);

	
	/**
	 * 对教练模式进行更改 当param 中关键字是flag的值为true时 是转化为驾校模式  否则转化为自主模式
	 * @param param
	 * @param flag
	 */
	public void changeTimeSlotType(Map<String, Object> param);

}
