package com.HuiShengTec.app.magAction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ILessonInfoService;
import com.HuiShengTec.app.service.IMonthTotalPriceService;
import com.HuiShengTec.app.service.IPriceService;
import com.HuiShengTec.app.service.ITimePriceService;
import com.HuiShengTec.base.annotation.Token;
import com.HuiShengTec.base.cache.PropertiesCache;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.base.messageConverter.JSONDateOutputMode;
import com.HuiShengTec.entity.DatePrice;
import com.HuiShengTec.utils.Toolkit;

@Controller
@RequestMapping("mag")
public class LessonInfoAction extends BaseAction {
	@Autowired
	private ILessonInfoService iLessonInfoService;
	@Autowired
	private ITimePriceService iTimePriceService;
	@Autowired
	private IPriceService iPriceService;
	@Autowired
	private IMonthTotalPriceService iMonthTotalPriceService;

	
	/**
	 * 课程管理跳转
	 * 
	 * @return
	 */
	@RequestMapping("lessonInfoManage")
	public String lessonInfoManage() {
		return "manage/lessonInfoAction/lessonInfoManage";
	}

	@ResponseBody
	@RequestMapping("queryLessonInfoPage")
	public PageBean queryLessonInfoPage(PageInfo info) {
		JSONDateOutputMode.setJSONDateToTimeMode();
		return iLessonInfoService.queryLessonInfoPage(info);
	}
	
	/**
	 * 前台缴费的详情
	 * @param id
	 * @return
	 */
	@RequestMapping("showPaymentInfo")
	public String showPaymentInfo(Integer id) {
		pushRequestValue("record", iLessonInfoService.queryStuLessonInfoDetail(id));
		return "manage/lessonInfoAction/infoPayment";
	}
	
	/**
	 * 前台得到需要缴费的详情
	 * @param id
	 * @return
	 */
	@RequestMapping("getPaymentInfo")
	public String getPaymentInfo(Integer id) {
		//JSONDateOutputMode.setJSONDateToTimeMode();
		pushRequestValue("record", iLessonInfoService.queryStuLessonInfoDetail(id));
		return "manage/lessonInfoAction/goPayment";
	}
	
	/**
	 * 后台ajax确认缴费
	 * @param id
	 * @return
	 */
	@RequestMapping("confirmPayment")
	@ResponseBody
	public void confirmPayment(Integer lessonInfoId,float cash,String cashContent) {
		iLessonInfoService.confirmPayment(lessonInfoId,cash,getCurrLoginAdmin().getId(),cashContent);
	}
	
	@ResponseBody
	@RequestMapping("getTotalPrice")
	public Map<String, Object> getTotalPrice(Integer stuId, Integer cohId,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date studyDate, String studyTime) {
		return iMonthTotalPriceService.getTotalPrice(stuId,cohId,studyDate,studyTime);
	}

	/**
	 * 预约课程跳转
	 * 
	 * @return
	 * @throws ParseException
	 */
	@Token(addToken = true)
	@RequestMapping("addLessonInfo")
	public String addLessonInfo() throws ParseException {
		// 启用的价格列表(status 为1标示启用的)
		request.setAttribute("timePriceTitle",
				iTimePriceService.queryUsedTimePrice());
		// 当前日期，去掉时间
		long currDate = Toolkit.getCurrDateWithoutTime().getTime();
		request.setAttribute("currDate", currDate);
		// 设置中的单人约课上限（在basicproperty表中约束了单人约课次数最多为3）
		request.setAttribute("lessonPlanLimit",
				PropertiesCache.getValue("lessonSingleLimit"));
		return "manage/lessonInfoAction/addLessonInfo";
	}

	/**
	 * 根据学生ID查询学生约课记录
	 * 
	 * @param stuId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryStuLessonPlanInfo")
	public List<HashMap<String, Object>> queryStuLessonPlanInfo(Integer stuId) {
		return iLessonInfoService.queryStuLessonPlanInfo(stuId);
	}

	/**
	 * 根据学生ID 获取允许约课的教师课程计划 (版本2)
	 * 
	 * @param stuId
	 * @param studyDate
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryTeacherTimePlan")
	public List<HashMap<String, Object>> queryTeacherTimePlan(Integer stuId,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date studyDate) {
		return iLessonInfoService.queryCoachTimePlan(stuId, studyDate);
	}

	/**
	 * 查询课程价格
	 * 
	 * @param stuId
	 * @param coachId
	 * @param studyDate
	 * @param time
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryPlanDateTimePrice")
	public DatePrice queryPlanDateTimePrice(Integer stuId, Integer coachId,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date studyDate, String time) {
		DatePrice price = iPriceService.queryPlanDateTimePrice(stuId, coachId,
				studyDate, time);
		if (Toolkit.isEmpty(price)) {
			price = new DatePrice();
		}
		return price;
	}

	/**
	 * 
	 * @param jsonStr
	 * @return [{"stuId":"65","lessonCode":"未保存","studyDate":"2015-04-15","subject":1,"studyTime":"08:00-10:59","name":"杨吉","price":"791","status":-1},]
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping("addLessonInfoSubmit")
	public HashMap<String, Object> addLessonInfoSubmit(String jsonStr) throws ParseException  {
		return iLessonInfoService.addLessonInfo(jsonStr);
	}

	
	

	
	 @ResponseBody
	 @RequestMapping("cancelLessonPlan")
	 public Integer cancelLessonPlan(String idStr) {
       iLessonInfoService.cancleLessonPlan(idStr);
	   return 1;
	 }

	 @RequestMapping("showLessonInfoDetail")
	 public String showLessonInfoDetail(Integer lessonInfoId){
		 pushRequestValue("lessonInfo",iLessonInfoService.queryStuLessonInfoDetail(lessonInfoId));
		 pushRequestValue("lessonDetail",iLessonInfoService.queryLessonMinusDetail(lessonInfoId));
		 pushRequestValue("jx_chineseName",PropertiesCache.getValue("jx_chineseName"));
		 pushRequestValue("printDate", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
		 return "manage/lessonInfoAction/showLessonInfoDetail";
	 }
	
	// /**
	// * 补齐数据
	// * @return
	// */
	// @ResponseBody
	// @RequestMapping("rebuildCurrLessonPlan")
	// public HashMap<String, Object> rebuildCurrLessonPlan(){
	// return iLessonInfoService.rebuildCurrLessonPlan();
	// }
}
