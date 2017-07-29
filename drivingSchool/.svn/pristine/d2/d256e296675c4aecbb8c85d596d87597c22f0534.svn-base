package com.HuiShengTec.app.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IBasicPropertiesDao;
import com.HuiShengTec.app.dao.ICarBrandDao;
import com.HuiShengTec.app.dao.ICoachGroupDao;
import com.HuiShengTec.app.dao.IDatePriceDao;
import com.HuiShengTec.app.dao.IDrivingLicenceDao;
import com.HuiShengTec.app.dao.ILessonPlanDao;
import com.HuiShengTec.app.dao.IStuInfoDao;
import com.HuiShengTec.app.dao.ITimePriceDao;
import com.HuiShengTec.app.dao.IWeekGroupDao;
import com.HuiShengTec.app.dao.IWeekPriceDao;
import com.HuiShengTec.app.service.IPriceService;
import com.HuiShengTec.entity.BasicProperty;
import com.HuiShengTec.entity.CarBrand;
import com.HuiShengTec.entity.DatePrice;
import com.HuiShengTec.entity.DrivingLicence;
import com.HuiShengTec.entity.LessonPlan;
import com.HuiShengTec.entity.StudentInfo;
import com.HuiShengTec.entity.TimePrice;
import com.HuiShengTec.entity.WeekPrice;
import com.HuiShengTec.utils.Toolkit;

@Service
@Transactional
public class PriceServiceImpl implements IPriceService {

	private static final long dayCount = 24 * 3600 * 1000;

	@Autowired
	private IDrivingLicenceDao iDrivingLicenceDao;
	@Autowired
	private IWeekGroupDao iWeekGroupDao;
	@Autowired
	private IBasicPropertiesDao iBasicPropertiesDao;
	@Autowired
	private IWeekPriceDao iWeekPriceDao;
	@Autowired
	private ITimePriceDao iTimePriceDao;
	@Autowired
	private ICarBrandDao iCarBrandDao;
	@Autowired
	private ILessonPlanDao iLessonPlanDao;
	@Autowired
	private IDatePriceDao iDatePriceDao;
	@Autowired
	private ICoachGroupDao iCoachGroupDao;
	@Autowired
	private IStuInfoDao iStuInfoDao;
	
	
	/**
	 * 更新价格列表，
	 */
	public void updatePrice() {
		//
		List<DrivingLicence> licenceList = iDrivingLicenceDao
				.queryCurrentDrivingLicence();
		List<TimePrice> timePriceList = iTimePriceDao.queryCurrTimePriceList();
		List<WeekPrice> weekPriceList = iWeekPriceDao.queryWeekPrice();
		List<CarBrand> carBrandList = iCarBrandDao.queryCarBrand();
		HashMap<Integer, WeekPrice> weekPriceMap = new HashMap<>();
		for (WeekPrice weekPrice : weekPriceList) {
			weekPriceMap.put(weekPrice.getWeekDay(), weekPrice);
		}

		BasicProperty basicPrice = iBasicPropertiesDao
				.queryBasicPropertiesByKey("basicPrice");
		// 查看数据是否初始化
		int planCount = iLessonPlanDao.queryLessonPlanCount();
		// 初始化数据
		if (planCount == 0) {
			initPriceData(licenceList, timePriceList, weekPriceMap, basicPrice,
					carBrandList);
		} else {
			// 删除老旧日期的数据
			iDatePriceDao.deleteOldDatePrice();
			// 已有数据 则删除旧的数据 插入新的数据
			updateCurrDatePrice(licenceList, timePriceList, weekPriceMap,
					basicPrice, carBrandList);
		}
	}

	/**
	 * 刷新所有七天数据
	 * 
	 * @param licenceList
	 * @param timePriceList
	 * @param weekPriceMap
	 * @param basicPrice
	 */
	public void initPriceData(List<DrivingLicence> licenceList,
			List<TimePrice> timePriceList,
			HashMap<Integer, WeekPrice> weekPriceMap, BasicProperty basicPrice,
			List<CarBrand> carBrandList) {
		long currTime = System.currentTimeMillis();
		// 循环7次 初始化数据
		for (int i = 0; i < 9; i++) {
			updateDatePrice(licenceList, timePriceList, weekPriceMap,
					basicPrice, currTime, carBrandList);
			currTime += dayCount;
		}
	}

	/**
	 * 删除过期记录/并生成新纪录
	 * 
	 * @param licenceList
	 * @param timePriceList
	 * @param weekPriceMap
	 * @param basicPrice
	 */
	public void updateCurrDatePrice(List<DrivingLicence> licenceList,
			List<TimePrice> timePriceList,
			HashMap<Integer, WeekPrice> weekPriceMap, BasicProperty basicPrice,
			List<CarBrand> carBrandList) {
		// 录入新价格表
		updateDatePrice(licenceList, timePriceList, weekPriceMap, basicPrice,
				(System.currentTimeMillis()) + dayCount * 8, carBrandList);

	}

	/**
	 * 更新一天的价目
	 * 
	 * @param licenceList
	 * @param timePriceList
	 * @param weekPriceMap
	 * @param basicPrice
	 * @param time
	 */
	public void updateDatePrice(List<DrivingLicence> licenceList,
			List<TimePrice> timePriceList,
			HashMap<Integer, WeekPrice> weekPriceMap, BasicProperty basicPrice,
			long time, List<CarBrand> carBrandList) {
		Date date = new Date(time);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 根据星期获取星期加价
		Float weekPrice = weekPriceMap.get(
				cal.get(Calendar.DAY_OF_WEEK)).getPricePlus();
		for (DrivingLicence licence : licenceList) {
			for (TimePrice timePrice : timePriceList) {
				for (CarBrand carBrand : carBrandList) {
					
					DatePrice datePrice = new DatePrice();
					//设置车辆品牌
					datePrice.setCarBrandId(carBrand.getId());
					// 设置日期
					datePrice.setDate(date);
					// 设置开始时间
					datePrice.setTime(timePrice.getBeginTime());
					datePrice.setLicenceId(licence.getId());
					// 驾照加价
					Float licencePrice = licence.getPricePlus();
					// 获取时间加价
					Float timePlusPrice = timePrice.getPricePlus();
					// 车辆品牌加价
					Float carBrandPrice = carBrand.getPricePlus();
					// 计算出的总价格
					Float totalPrice = weekPrice + licencePrice + timePlusPrice
							+ Float.valueOf(basicPrice.getValue())
							+ carBrandPrice;
					datePrice.setPrice(totalPrice);
					// 添加
					iDatePriceDao.addDatePrice(datePrice);
				}
			}
		}
		//更新教师课程计划信息
		List<HashMap<String, Object>> teacherList = iCoachGroupDao.queryCoachWeekGroup(cal.get(Calendar.DAY_OF_WEEK));
		for (TimePrice price : timePriceList) {
			for (HashMap<String, Object> teacher : teacherList) {
				LessonPlan plan = new LessonPlan();
				plan.setDate(date);
				plan.setTime(price.getBeginTime());
				plan.setCoachId((Integer)teacher.get("coachId"));
				plan.setSubject((Integer)teacher.get("subject"));
				iLessonPlanDao.addLessonPlan(plan);
			}
		}
	}
	public void deleteOldDatePrice(){
		
	}
	public DatePrice queryPlanDateTimePrice(Integer stuId,Integer coachId,Date studyDate,String time){
		
		StudentInfo stuInfo =iStuInfoDao.queryStuInfo(stuId);
		
		if(stuInfo.getLessonStep()==1){
			if(stuInfo.getCoachId()==null){
				return null;
			}
			HashMap<String, Object> condition = new HashMap<>();
			condition.put("stuId", stuId);
			condition.put("coachId", coachId);
			condition.put("studyDate", studyDate);
			condition.put("time", time);
			return iDatePriceDao.queryPlanDateTimePrice(condition);
		}else{
			return null;
		}
	}
	@Override
	public List<TimePrice> queryAllTimePriceList() {
		return iTimePriceDao.queryAllTimePriceList();
	}

	@Override
	public List<TimePrice> queryTimePrice(){
		return iTimePriceDao.queryCurrTimePriceList();
	}
	
	/**
	 * 查询价格表
	 */
	public List<HashMap<String, Object>> queryDatePrice(Integer licenceId,Integer carBrandId,Date selectDate){
		HashMap<String, Object> condition = new HashMap<>();
		if(!Toolkit.isEmpty(selectDate)){
			condition.put("selectDate", selectDate);
		}
		List<TimePrice> timePriceList= iTimePriceDao.queryCurrTimePriceList();
		condition.put("timeList", timePriceList);
		condition.put("carBrandId", carBrandId);
		if(Toolkit.isEmpty(licenceId)){
			licenceId=6;
		}
		condition.put("licenceId", licenceId);
		return iTimePriceDao.queryPriceByConditions(condition);
	}
	
	
	
	@Override
	public Integer editTimePriceSubmit(TimePrice timePriceInfo) {
		return iTimePriceDao.editTimePriceSubmit(timePriceInfo);
	}
	
	@Override
	public Integer editTimePriceStatus(Map<String,Object> param) {
		// TODO Auto-generated method stub
		return iTimePriceDao.editTimePriceStatus(param)>0?0:1;
	}

	@Override
	public List<WeekPrice> queryWeekManage() {
		// TODO Auto-generated method stub
		return iWeekPriceDao.queryWeekPrice();
	}

	@Override
	public Integer editWeekManageSubmit(WeekPrice weekPrice) {
		// TODO Auto-generated method stub
		return iWeekPriceDao.updateWeekPrice(weekPrice);
	}
	
	@Override
	public Integer editDrivingLicenceStatus(Map<String,Object> param) {
		// TODO Auto-generated method stub
		return iDrivingLicenceDao.editDrivingLicenceStatus(param);
	}
	
	/**
	 * 编辑驾驶证差价 价格
	 */
	@Override
	public Integer editDrivingLicenceSubmit(DrivingLicence drivingLicence) {
		// TODO Auto-generated method stub
		return iDrivingLicenceDao.editDrivingLicenceSubmit(drivingLicence);
	}
	
	/**
	 * 更新七天价格
	 */
	@Override
	public Integer updateSevenDaySubmit(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return iTimePriceDao.updateSevenDaySubmit(param)>0?0:1;
	}
	
	
	
}
