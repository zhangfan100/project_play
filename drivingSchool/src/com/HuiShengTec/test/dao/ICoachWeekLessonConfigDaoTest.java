package com.HuiShengTec.test.dao;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.HuiShengTec.app.dao.ICoachWeekLessonConfigDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.CoachWeekLessonConfig;
import com.HuiShengTec.test.basejunit.AbstractJunit;
import com.HuiShengTec.utils.Toolkit;

public class ICoachWeekLessonConfigDaoTest extends AbstractJunit{
	
	@Autowired
	private ICoachWeekLessonConfigDao iCoachWeekLessonConfigDao;
	@Test
	public void queryAllWeekSettingTest(){
		System.out.println(iCoachWeekLessonConfigDao.queryAllWeekSetting(24));
	}
	
	
	@Test
	public void queryAllWeekSettingByIdTest(){
		PageInfo info = new PageInfo();
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("coachId",24);
		System.out.println(iCoachWeekLessonConfigDao.queryAllWeekSettingById(pageBean));
	}
	
	@Test
	public void testQueryCoachWeekLessonConfigById() {
		System.out.println(iCoachWeekLessonConfigDao.queryCoachWeekLessonConfigById(24));
	}

	@Test
	public void testEditSettingSubmit() {
		CoachWeekLessonConfig coachWeekLessonConfig = new CoachWeekLessonConfig(1, 24, 0, 1, 1, 2);
		System.out.println(iCoachWeekLessonConfigDao.editSettingSubmit(coachWeekLessonConfig));
	}

	@Test
	public void testAddWeeklessonconfig() {
		CoachWeekLessonConfig coachWeekLessonConfig = null;
		for(int i=0;i<14;i++){
			coachWeekLessonConfig = new CoachWeekLessonConfig();
			coachWeekLessonConfig.setCoachId(11);
			coachWeekLessonConfig.setWeekDay(i%7);
			coachWeekLessonConfig.setTimeSlot(i%2==0?1:2);
			coachWeekLessonConfig.setSubject(1);//默认科目二
			coachWeekLessonConfig.setTimeSlotType(2);//默认教练自主模式
			iCoachWeekLessonConfigDao.addWeeklessonconfig(coachWeekLessonConfig);
		}
	}

	@Test
	public void testJoinCoachGroup() {
       
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("weekDay", 1);
		param.put("subject", 1);
		param.put("timeSlot", 1);
		param.put("flag", true);
		param.put("coachId", 24);
		iCoachWeekLessonConfigDao.changeTimeSlotType(param);
	}

	@Test
	public void testRemoveCoachGroup() {
		  
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("weekDay", 1);
		param.put("subject", 1);
		param.put("timeSlot", 1);
		param.put("flag", false);
		param.put("coachId", 24);
		iCoachWeekLessonConfigDao.changeTimeSlotType(param);
	}
}
