package com.HuiShengTec.app.service;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.CoachWeekLessonConfig;

public interface ICoachWeekLessonConfigService {

	/**
	 * 插入数据
	 * @param coachWeekLessonConfig
	 */
	public void insertCoachWeekLessonConfig(CoachWeekLessonConfig coachWeekLessonConfig);
	
	/**
	 * 查询所有的课程设置
	 * @param coachId
	 * @return
	 */
	public List<Map<String, Object>> queryAllWeekSetting(Integer coachId);
	
	/**
	 * 分页查询课程设置
	 * @param pageBean
	 * @return
	 */
	public PageBean queryAllWeekSettingByPage(PageBean pageBean);

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
	 * @param id
	 */
	public void addWeeklessonconfig(Integer id);

	/**
	 * 加入分组
	 * @param weekDay
	 * @param subject
	 * @param timeSlot
	 * @param cohIds
	 * @return
	 */
	public Integer joinCoachGroup(Integer weekDay, Integer subject,
			Integer timeSlot, String cohIds);

	/**
	 * 移除分组
	 * @param weekDay
	 * @param subject
	 * @param timeSlot
	 * @param groupIds
	 * @return
	 */
	public Integer removeCoachGroup(Integer weekDay, Integer subject,
			Integer timeSlot, String groupIds);
}
