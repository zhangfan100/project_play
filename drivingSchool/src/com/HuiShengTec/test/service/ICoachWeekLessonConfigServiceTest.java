package com.HuiShengTec.test.service;

import java.text.ParseException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.HuiShengTec.app.dao.IAccountLogDao;
import com.HuiShengTec.app.service.ICoachWeekLessonConfigService;
import com.HuiShengTec.app.stuAction.StuLessonInfoAction;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.CoachWeekLessonConfig;
import com.HuiShengTec.test.basejunit.AbstractJunit;
import com.HuiShengTec.utils.Toolkit;

public class ICoachWeekLessonConfigServiceTest extends AbstractJunit{
	
	
	@Autowired
	private IAccountLogDao iAccountLogDao;
	@Autowired
	private StuLessonInfoAction stuLessonInfoAction;
	//科目二  [{"cohId":"27","lessonCode":"未保存","studyDate":"2015-04-06","subject":1,"studyTime":"12:00-13:59","price":"未保存","status":-1}]
	//科目三  [{"cohId":"24","lessonCode":"未保存","studyDate":"2015-04-08","subject":"2","studyTime":"aft","name":"杨吉","price":"未保存","status":"-1"}]
	@Test
	public  void  isValidateDataTest() throws ParseException{
		String km2 = "[{\"cohId\":\"27\",\"lessonCode\":\"未保存\",\"studyDate\":\"2015-04-10\",\"subject\":1,\"studyTime\":\"12:00-13:59\",\"price\":\"未保存\",\"status\":-1}]";
		String km3 = "[{\"cohId\":\"24\",\"lessonCode\":\"未保存\",\"studyDate\":\"2015-04-05\",\"subject\":\"2\",\"studyTime\":\"aft\",\"name\":\"杨吉\",\"price\":\"未保存\",\"status\":\"-1\"}]";
		System.out.println(km2);
		//System.out.println(stuLessonInfoAction.isValidateData(km3));
	}

	@Autowired
	private ICoachWeekLessonConfigService iCoachWeekLessonConfigService;
	
	@Test
	public void testQueryAllWeekSetting() {
		System.out.println(iCoachWeekLessonConfigService.queryAllWeekSetting(24));
	}

	@Test
	public void testQueryAllWeekSettingByPage() {
		PageInfo info = new PageInfo();
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("coachId",24);
		iCoachWeekLessonConfigService.queryAllWeekSettingByPage(pageBean);
		System.out.println(pageBean);
	}

	@Test
	public void testQueryCoachWeekLessonConfigById() {
		System.out.println(iCoachWeekLessonConfigService.queryCoachWeekLessonConfigById(24));
	}

	@Test
	public void testEditSettingSubmit() {
		CoachWeekLessonConfig coachWeekLessonConfig = new CoachWeekLessonConfig(1, 24, 0, 1, 1, 2);
		System.out.println(iCoachWeekLessonConfigService.editSettingSubmit(coachWeekLessonConfig));
	}

	@Test
	public void testAddWeeklessonconfig() {
		iCoachWeekLessonConfigService.addWeeklessonconfig(1);
	}

	@Test
	public void testJoinCoachGroup() {
		iCoachWeekLessonConfigService.joinCoachGroup(1, 2, 1, "24");
	}

	@Test
	public void testRemoveCoachGroup() {
		iCoachWeekLessonConfigService.removeCoachGroup(1, 2, 1, "24");
	}

}
