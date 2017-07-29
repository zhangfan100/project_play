package com.HuiShengTec.app.mobileStuAction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.HuiShengTec.app.service.ILessonDetailService;
import com.HuiShengTec.app.service.ILessonInfoService;
import com.HuiShengTec.app.service.ILoginService;
import com.HuiShengTec.app.service.IPriceService;
import com.HuiShengTec.app.service.IStuInfoService;
import com.HuiShengTec.app.service.ITimePriceService;
import com.HuiShengTec.base.cache.PropertiesCache;
import com.HuiShengTec.base.messageConverter.JSONDateOutputMode;
import com.HuiShengTec.entity.DatePrice;
import com.HuiShengTec.utils.Toolkit;

/**
 * llj
 * @author 
 * 预约 课程
 */
@RequestMapping("/mobile")
@Controller
public class MobStuLessonInfoAction extends BaseAction{
//	@Autowired
//	private ILessonInfoService iLessonInfoService;
//	@Autowired
//	private IStuInfoService iStuInfoService;
//	@Autowired
//	private IStuInfoService infoService;
//	@Autowired
//	private ILoginService iLoginService;
//	@Autowired
//	private ITimePriceService iTimePriceService;
//	@Autowired
//	private IPriceService iPriceService;
//	@Autowired
//	private ILessonDetailService iLessonDetailService;
//	/**
//	 * 查询当前学生当天的预约 我的预约
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("queryCurrLessonInfo")
//	public List<HashMap<String, Object>> queryCurrLessonInfo(){
//		JSONDateOutputMode.setJSONDateToTimeMode();
//		return iLessonInfoService.queryStuLessonInfoPlanList(getCurrLoginStudent().getId());
//		
//	}
//	/**
//	 * 查询已选课程
//	 * @param stuId
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("queryStuLessonPlanInfo")
//	public List<HashMap<String, Object>> queryStuLessonPlanInfo(){
//		JSONDateOutputMode.setJSONDateToDateMode();
//		JSONDateOutputMode.setJSONDateToTimeMode();
//		return iLessonInfoService.queryStuLessonPlanInfo(getCurrLoginStudent().getId());
//	}
//	/**
//	 * 预约信息提交
//	 * @param jsonStr
//	 * @return
//	 * @throws ParseException
//	 */
//	@ResponseBody
//	@RequestMapping("addLessonInfoSubmit")
//	public HashMap<String, Object> addLessonInfoSubmit(String jsonStr) throws ParseException{
//		iLessonInfoService.addLessonInfo(jsonStr,getCurrLoginStudent());
//		return Toolkit.initMapCondition("state", 1);
//	}
//	
//	/**
//	 * 预约信息
//	 * @throws ParseException
//	 */
//	@RequestMapping("/queryLessonInfo")
//	@ResponseBody
//	public Map<String, Object> queryLessnInfo() throws ParseException {
//		Map<String, Object> result = new HashMap<String, Object>();
//		//学生约课信息
//		List<HashMap<String, Object>> list = iLessonInfoService.queryStuLessonPlanInfo(getCurrLoginStudent().getId());
//		result.put("stuLessonPlanInfoData", list);
//		//限制约课数量
//		result.put("stuLessonPlanInfoDataCount", list.size());
//		result.put("lessonPlanLimit", PropertiesCache.getValue("lessonSingleLimit"));
//		//启用的时段
//		result.put("timePriceTitle", iTimePriceService.queryUsedTimePrice());
//		//约课日期范围
//		Date beginDate = new Date(Toolkit.getCurrDateWithoutTime().getTime()+24*60*60*1000);
//		result.put("beginDate",  Toolkit.parseDate(beginDate, null));
//		Date endDate = new Date(Toolkit.getCurrDateWithoutTime().getTime()+24*60*60*1000*7);
//		result.put("endDate",Toolkit.parseDate(endDate, null));
//		//判断学员模式 1-老模式 0-新模式
//		int stuType=Toolkit.isEmpty(getCurrLoginStudent().getCoachId())?0:1;
//		result.put("stuType", stuType);
//		
//		//当前时间
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, 1);
//		result.put("today", new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
//		
//		//设置中的单人约课上限
//		result.put("lessonPlanLimit", PropertiesCache.getValue("lessonSingleLimit"));
//		return result;
//	}
//	
//	/**
//	 * 显示老师排课信息
//	 * @param stuId
//	 * @param subject
//	 * @param studyDate
//	 * @return
//	 * @throws ParseException 
//	 */
//	@ResponseBody
//	@RequestMapping("queryTeacherTimePlan")
//	public List<HashMap<String, Object>> queryTeacherTimePlan(Integer subject,@DateTimeFormat(pattern="yyyy-MM-dd") Date studyDate) throws ParseException {
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, 1);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		
//		HashMap<String, Object> condition = new HashMap<String, Object>();
//		condition.put("studyDate", Toolkit.isEmpty(studyDate)?sdf.parse(sdf.format(cal.getTime())):studyDate);
//		condition.put("subject", Toolkit.isEmpty(subject)?1:subject);
//		condition.put("stuId", getCurrLoginStudent().getId());
//		return iLessonInfoService.queryTeacherTimePlan(condition);
//	}
//	/**
//	 * 查询相应时间价格
//	 * @param coachId
//	 * @param studyDate
//	 * @param time
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("queryPlanDateTimePrice")
//	public HashMap<String, Object> queryPlanDateTimePrice(Integer coachId,@DateTimeFormat(pattern="yyyy-MM-dd") Date studyDate,Integer time){
//		DatePrice price=iPriceService.queryPlanDateTimePrice(getCurrLoginStudent().getId(), coachId, studyDate, time);
//		
//		return Toolkit.initMapCondition("price", price==null?0:price.getPrice());
//	}
//	/**
//	 * 培训详细 统计
//	 * @param coachId
//	 * @param studyDate
//	 * @param time
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/lessonHistoryManage")
//	public HashMap<String, Object> lessonHistoryManage(){
//		return iLessonInfoService.queryStuLessonInfoCount(getCurrLoginStudent().getId());
//	}
//	/**
//	 * 培训详细 分科目筛选
//	 * @param coachId
//	 * @param studyDate
//	 * @param time
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("qureyStuLessonTrainInfo")
//	public List<HashMap<String, Object>> qureyStuLessonTrainInfo(Integer subject){
//		return iLessonInfoService.queryStuLessonTrainInfo(getCurrLoginStudent().getId(), subject);
//	}
//	
//	/**
//	 * 取消预约
//	 * @param id
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("cancelLessonPlan")
//	public HashMap<String, Object> cancelLessonPlan(String idStr) {
//		if(!Toolkit.isEmpty(idStr)){
//			iLessonInfoService.cancleLessonPlan(idStr);
//			HashMap<String, Object> result = (HashMap<String, Object>) infoService.queryStudentInfo(getCurrLoginStudent().getId());
//			String path = (String) result.get("path");
//			result.put("path",Toolkit.isEmpty(path) ? null : request.getContextPath() + path);
//			return result;
//		}else{
//			return Toolkit.initMapCondition("error", 0);
//		}
//	}
}
