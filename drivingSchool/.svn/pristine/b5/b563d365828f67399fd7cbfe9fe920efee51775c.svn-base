package com.HuiShengTec.app.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.entity.DatePrice;
import com.HuiShengTec.entity.DrivingLicence;
import com.HuiShengTec.entity.TimePrice;
import com.HuiShengTec.entity.WeekPrice;



public interface IPriceService {
	public void updatePrice();
	
	public DatePrice queryPlanDateTimePrice(Integer stuId,Integer coachId,Date studyDate,String time);
	
	public List<TimePrice> queryTimePrice();
	
	public List<HashMap<String, Object>> queryDatePrice(Integer licenceId,Integer carBrandId,Date selectDate);
	
	List<TimePrice> queryAllTimePriceList();
	
	public Integer editTimePriceStatus(Map<String, Object> param);

	public Integer editTimePriceSubmit(TimePrice timePriceInfo);

	public List<WeekPrice> queryWeekManage();
	
	public Integer editWeekManageSubmit(WeekPrice weekPrice);
	
	public Integer editDrivingLicenceStatus(Map<String,Object> param);
	
	/**
	 * 编辑驾驶证差价 价格
	 * @author mihuajun
	 * @createTime 2014-11-6 上午2:29:35
	 * @param drivingLicence
	 */
	public Integer editDrivingLicenceSubmit(DrivingLicence drivingLicence);
	
	/**
	 * 更新七天价格
	 * @author mihuajun
	 * @createTime 2014-11-6 上午11:37:07
	 * @param param
	 * @return
	 */
	public Integer updateSevenDaySubmit(Map<String, Object> param);

	/*	public Integer updateSevenDaySubmit(Map<String, Object> param);

*/}
