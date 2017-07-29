package com.HuiShengTec.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ICoachWeekLessonConfigDao;
import com.HuiShengTec.app.service.ICoachWeekLessonConfigService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.CoachWeekLessonConfig;

@Service
@Transactional
public class CoachWeekLessonConfigServiceImpl implements ICoachWeekLessonConfigService {

	@Autowired
	private ICoachWeekLessonConfigDao iCoachWeekLessonConfigDao;
	
	@Override
	public void insertCoachWeekLessonConfig(CoachWeekLessonConfig coachWeekLessonConfig) {
         iCoachWeekLessonConfigDao.insertCoachWeekLessonConfig(coachWeekLessonConfig);
	}

	/**
	 * 查询所有的课程
	 */
	@Override
	public List<Map<String, Object>> queryAllWeekSetting(Integer coachId) {
//		0 1 2 3 4 5 6
//		1 2 3 4 5 6 0
		return iCoachWeekLessonConfigDao.queryAllWeekSetting(coachId);
	}

	/**
	 * 分页查询所有的课程
	 */
	@Override
	public PageBean queryAllWeekSettingByPage(PageBean pageBean) {
		pageBean.setRows(iCoachWeekLessonConfigDao.queryAllWeekSettingById(pageBean));
		return pageBean;
	}
	
	/**
	 * 通过ID查询教练课程
	 */
	@Override
	public Map<String, Object> queryCoachWeekLessonConfigById(Integer id) {
		return iCoachWeekLessonConfigDao.queryCoachWeekLessonConfigById(id);
	}

	/**
	 * 保存修改的课程
	 */
	@Override
	public Integer editSettingSubmit(CoachWeekLessonConfig coachWeekLessonConfig) {
		int len1= iCoachWeekLessonConfigDao.editSettingSubmit(coachWeekLessonConfig);
		if(len1==0){
			throw new RuntimeException("操作失败");
		}
		return 0;
	}

	@Override
	public void addWeeklessonconfig(Integer id) {
        /**
         * 增加14条记录，默认科目二		
         */
		CoachWeekLessonConfig coachWeekLessonConfig = null;
		for(int i=0;i<14;i++){
			coachWeekLessonConfig = new CoachWeekLessonConfig();
			coachWeekLessonConfig.setCoachId(id);
			coachWeekLessonConfig.setWeekDay(i%7);
			coachWeekLessonConfig.setTimeSlot(i%2==0?1:2);
			coachWeekLessonConfig.setSubject(1);//默认科目二
			coachWeekLessonConfig.setTimeSlotType(2);//默认教练自主模式
			iCoachWeekLessonConfigDao.addWeeklessonconfig(coachWeekLessonConfig);
		}
	}

	/**
	 * 教练加入驾校分配模式 注意把标志位flag设置为true
	 * 
	 */
	@Override
	public Integer joinCoachGroup(Integer weekDay, Integer subject,
			Integer timeSlot, String cohIds) {
		Map<String,Object> param = new HashMap<String, Object>();
		
		param.put("weekDay", weekDay);
		param.put("subject", subject);
		param.put("timeSlot", timeSlot);
		param.put("flag", true);
		for(String item:cohIds.split(",")){
			param.put("coachId", Integer.valueOf(item));
			iCoachWeekLessonConfigDao.changeTimeSlotType(param);
		}
		return 0;
	}

	/**
	 * 移除分组  注意把标志位flag设置为false
	 */
	@Override
	public Integer removeCoachGroup(Integer weekDay, Integer subject,
			Integer timeSlot, String groupIds) {
		
        Map<String,Object> param = new HashMap<String, Object>();
		
		param.put("weekDay", weekDay);
		param.put("subject", subject);
		param.put("timeSlot", timeSlot);
		param.put("flag", false);
		for(String item:groupIds.split(",")){
			param.put("coachId", Integer.valueOf(item));
			iCoachWeekLessonConfigDao.changeTimeSlotType(param);
		}
		return 0;
	}
	
}
