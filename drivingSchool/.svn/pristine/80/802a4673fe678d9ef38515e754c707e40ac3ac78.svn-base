package com.HuiShengTec.app.stuAction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ILessonInfoService;
import com.HuiShengTec.app.service.IMonthTotalPriceService;
import com.HuiShengTec.app.service.IPriceService;
import com.HuiShengTec.app.service.IStuInfoService;
import com.HuiShengTec.app.service.ITimePriceService;
import com.HuiShengTec.base.cache.PropertiesCache;
import com.HuiShengTec.base.messageConverter.JSONDateOutputMode;
import com.HuiShengTec.entity.StudentInfo;
import com.HuiShengTec.utils.Toolkit;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("stu")
public class StuLessonInfoAction extends BaseAction {

	@Autowired
	private ILessonInfoService iLessonInfoService;
	@Autowired
	private ITimePriceService iTimePriceService;
	@Autowired
	private IPriceService iPriceService;
	@Autowired
	private IStuInfoService iStuInfoService;
	@Autowired
	private IMonthTotalPriceService iMonthTotalPriceService;
	
	/**
	 * 找可以预约的选课
	 * @return
	 * @throws ParseException 
	 */
	@ResponseBody
	@RequestMapping("findLessonInfo")
	public List<HashMap<String, Object>> findLessonInfo(@DateTimeFormat(pattern="yyyy-MM-dd") Date studyDate) throws ParseException{
		return iLessonInfoService.queryCoachTimePlan(getCurrLoginInfo().getUserId(), studyDate);
	}
	
	/**
	 * 通过传来的参数得到价格和车辆类型
	 * @param studyDate
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping("getTotalPriceAndCarType")
	public Map<String, Object> getTotalPriceAndCarType(Integer cohId,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date studyDate, String studyTime) {
		return iMonthTotalPriceService.getTotalPrice(getCurrLoginStudent().getId(), cohId, studyDate, studyTime);
	}
	
	/**
	 * 跳转至科目三选课界面
	 * @return
	 */
	@RequestMapping("toSubject3AddLesson")
	public String toSubject3AddLesson(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 1);
		pushRequestValue("beginDate", sdf.format(calendar.getTime()));
		calendar.add(Calendar.DATE, 7);
		pushRequestValue("endDate", sdf.format(calendar.getTime()));
		return "student/stuLessonInfoAction/subject3AddLesson";
	}
	
	/**
	 * 查询已选科目三
	 * @param stuId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryOrderLessionInfo")
	public List<HashMap<String, Object>> queryOrderLessionInfo(){
		return iLessonInfoService.queryOrderLessionInfo(getCurrLoginStudent().getId());
	}
	
	/**
	 * 用来验证数据是否合法
	 * @param jsonStr
	 * @return
	 * @throws ParseException 
	 */
	@SuppressWarnings("unchecked")
	private boolean isValidateData(String jsonStr) throws ParseException{
		@SuppressWarnings("rawtypes")
		List<HashMap> data = JSON.parseArray(jsonStr, HashMap.class);
		for (HashMap<String, Object> map : data) {
				String subject = null;//用来记录科目
				String date = null;//用来记录时间
				for(Map.Entry<String, Object> m : map.entrySet()){
					if("subject".equalsIgnoreCase(m.getKey())){//验证传来的科目是否与登录学生的进度一样
						String subjectStr = m.getValue().toString();
						if("".equals(subjectStr.trim()) || subjectStr == null){//说明传来的为空
							return false;
						}
						StudentInfo studentInfo = iStuInfoService.queryStuInfo(this.getCurrLoginStudent().getId());
						if(!subjectStr.trim().equals(studentInfo.getLessonStep()+"")){//传来的科目id不等于学生应该的科目
							return false;
						}
						if(date!=null){//说明已经初始化了时间
							Date beginDate=new Date(System.currentTimeMillis()+24*60*60*1000);
							Date endDate=new Date(System.currentTimeMillis()+8*24*60*60*1000);
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
							Date selectDate = sdf.parse(date);
							beginDate = sdf.parse(Toolkit.parseDate(beginDate, "yyyy-MM-dd"));
							//根据subject验证时间范围的允许情况  科目三，二是从明天到接下来的一周
							if(selectDate.compareTo(endDate)>0 || selectDate.compareTo(beginDate) < 0){
								return false;
							}
						}
						subject = subjectStr;
						continue;
					}
					if("cohId".equalsIgnoreCase(m.getKey())){//教练ID就验证是否是大于0的整数
						String cohIdStr = m.getValue().toString();
						if("".equals(cohIdStr.trim()) || cohIdStr == null){//说明传来的为空
							return false;
						}
						if(!cohIdStr.matches("[0-9]+")){//是否纯数字
							return false;
						}
						if(Integer.parseInt(cohIdStr)<=0){//是否是大于0的整数
							return false;
						}
						continue;
					}//cohId
					if("lessonCode".equalsIgnoreCase(m.getKey())){//只需要重新给他赋值 管他以前对不对
						if(!"未保存".equals(m.getValue().toString().trim())){
							return false;
						}
						continue;
					}
					if("studyDate".equalsIgnoreCase(m.getKey())){
						String studyDateStr = m.getValue().toString();
						if("".equals(studyDateStr) || studyDateStr == null){//说明传来的为空
							return false;
						}
						//验证是否是yyyy-MM-dd格式的日期
						String eL = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
						Pattern p = Pattern.compile(eL);
						Matcher matcher = p.matcher(studyDateStr);
						boolean dateFlag = matcher.matches();
						if (!dateFlag) {//格式错误
							return false;
						}
						if(subject!=null){//说明已经初始化了科目
							Date beginDate=new Date(System.currentTimeMillis()+24*60*60*1000);
							Date endDate=new Date(System.currentTimeMillis()+8*24*60*60*1000);
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
							beginDate = sdf.parse(Toolkit.parseDate(beginDate, "yyyy-MM-dd"));
							Date selectDate = sdf.parse(studyDateStr);
							//根据subject验证时间范围的允许情况  科目三，二是从明天到接下来的一周
							if(selectDate.compareTo(endDate)>0 || selectDate.compareTo(beginDate) < 0){
								return false;
							}
						}
						date = studyDateStr;
						continue;
					}//studeyDate
					if("status".equalsIgnoreCase(m.getKey())){//只需要重新给他赋值 管他以前对不对
						if(!"-1".equals(m.getValue().toString().trim())){
							return false;
						}
						continue;
					}
					if(map.size()==9){
						if("studyTime".equalsIgnoreCase(m.getKey())){//只需要判断值是否是aft或者mor这两个结果
	                        if(!"aft".equals(m.getValue().toString().trim()) && !"mor".equals(m.getValue().toString().trim())){
	                        	return false;
	                        }
	                        continue;
						}
						if("name".equalsIgnoreCase(m.getKey())){//验证名字不为空
							if("".equals(m.getValue().toString().trim()) || m.getValue().toString().trim()==null){
								return false;
							}
							continue;
						}
					}else{
						if("studyTime".equalsIgnoreCase(m.getKey())){//该格式为10:00-11:59
	                        if("".equals(m.getValue().toString().trim()) || m.getValue().toString().trim()==null){
	                        	return false;
	                        }
						}
					}
				}
		}
		return true;
	}
	/**
	 * 前台ajax保存对选课的数据
	 * @param jsonStr
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping("saveLessonInfoPlanSubmit")
	public HashMap<String,Object> saveLessonInfoPlanSubmit(String jsonStr) throws ParseException{
		//进来先得进行数据验证 
 		if(!isValidateData(jsonStr)){//返回false说明没有通过验证
			return Toolkit.initMapCondition("status", "-1");
		}
		int stuId = getCurrLoginInfo().getUserId();
		StringBuffer sb = new StringBuffer(jsonStr);//传入的只有一个数据
		sb = sb.insert(sb.length()-2, ",\"stuId\":\""+stuId+"\"");
		return iLessonInfoService.addLessonInfo(sb.toString());
	}

	/**
	 * 跳转至科目二选课界面
	 * @return
	 */
	@RequestMapping("toSubject2AddLesson")
	public String toSubject2AddLesson(){
		pushRequestValue("lessonPlanLimit", PropertiesCache.getValue("lessonSingleLimit"));
		pushRequestValue("stuType", getCurrLoginStudent().getStuType());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 1);
		pushRequestValue("beginDate", sdf.format(calendar.getTime()));
		calendar.add(Calendar.DATE, 7);
		pushRequestValue("endDate", sdf.format(calendar.getTime()));
		// 启用的价格列表(status 为1标示启用的)
		request.setAttribute("timePriceTitle",
						JSON.toJSON(iTimePriceService.queryUsedTimePrice()));
		return "student/stuLessonInfoAction/addSubject2LessonInfo";
	}
	
	
	
//	
//	/**
//	 * 预约信息提交
//	 * @author mihuajun
//	 * @createTime 2014-11-11 上午10:57:56
//	 * @param jsonStr
//	 * @return
//	 * @throws ParseException
//	 */
//	@ResponseBody
//	@RequestMapping("addLessonInfoSubmit")
//	public Integer addLessonInfoSubmit(String jsonStr) throws ParseException{
//		try{
//			return iLessonInfoService.addLessonInfo(jsonStr,getCurrLoginStudent());
//		}catch(RuntimeException r){
//			if("课程已被预约".equals(r.getMessage())){
//				logger.debug("课程已被预约");
//				return 1;
//			}
//		}
//		return 0;
//	}
//	
//
//	@RequestMapping("addLessonInfo")
//	public String addLessnInfo() throws ParseException {
//		//学生约课信息
//		List<HashMap<String, Object>> list = iLessonInfoService
//		.queryStuLessonPlanInfo(getCurrLoginStudent().getId());
//		request.setAttribute("stuLessonPlanInfoData",list);
//		//限制约课数量
//		request.setAttribute("stuLessonPlanInfoDataCount", list.size());
//		request.setAttribute("lessonPlanLimit",
//				PropertiesCache.getValue("lessonSingleLimit"));
//		//启用的时段
//		request.setAttribute("timePriceTitle",
//				iTimePriceService.queryUsedTimePrice());
//		//约课日期范围
//		Date beginDate = new Date(Toolkit.getCurrDateWithoutTime().getTime()+24*60*60*1000);
//		request.setAttribute("beginDate", Toolkit.parseDate(beginDate, null));
//		Date endDate = new Date(Toolkit.getCurrDateWithoutTime().getTime()+24*60*60*1000*7);
//		request.setAttribute("endDate", Toolkit.parseDate(endDate, null));
//		//判断学员模式 1-老模式 0-新模式
//		int stuType=Toolkit.isEmpty(getCurrLoginStudent().getCoachId())?0:1;
//		request.setAttribute("stuType", stuType);
//		
//		//当前时间
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, 1);
//		request.setAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
//		
//		//设置中的单人约课上限
//		request.setAttribute("lessonPlanLimit", PropertiesCache.getValue("lessonSingleLimit"));
//		return "student/stuLessonInfoAction/addLessonInfo";
//	}
//	
	/**
	 * 显示老师排课信息
	 * @author mihuajun
	 * @createTime 2014-11-10 上午11:35:43
	 * @param stuId
	 * @param subject
	 * @param studyDate
	 * @return
	 * @throws ParseException 
	 */
	@ResponseBody
	@RequestMapping("queryTeacherTimePlan")
	public List<HashMap<String, Object>> queryTeacherTimePlan(
			@DateTimeFormat(pattern="yyyy-MM-dd") Date studyDate) throws ParseException {
		return iLessonInfoService.queryCoachTimePlan(getCurrLoginStudent().getId(), studyDate);
	}
//	
//	/**
//	 * 新模式之，查询相应时间价格
//	 * @author mihuajun
//	 * @createTime 2014-11-10 下午4:28:42
//	 * @param coachId
//	 * @param studyDate
//	 * @param time
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("queryPlanDateTimePrice")
//	public DatePrice queryPlanDateTimePrice(Integer coachId,
//			@DateTimeFormat(pattern="yyyy-MM-dd") Date studyDate,
//			Integer time){
//		return iPriceService.queryPlanDateTimePrice(getCurrLoginStudent().getId(), coachId, studyDate, time);
//	}
//	
	/**
	 * 查询已选课程
	 * @author mihuajun
	 * @createTime 2014-11-10 下午5:34:03
	 * @param stuId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryStuLessonPlanInfo")
	public List<HashMap<String, Object>> queryStuLessonPlanInfo(){
		JSONDateOutputMode.setJSONDateToDateMode();
		return iLessonInfoService.queryStuLessonPlanInfo(getCurrLoginStudent().getId());
	}
//	
	/**
	 * 前台ajax取消预约
	 * @param idStr
	 * @return
	 */
	@ResponseBody
	@RequestMapping("cancelLessonPlan")
	public Integer cancelLessonPlan(String idStr) {
		iLessonInfoService.cancleLessonPlan(idStr);
		return 1;
	}
	
	/**
	 * ajax查询用户预约课程培训
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryStuLessonInfoPlanList")
	public List<HashMap<String, Object>> queryStuLessonInfoPlanList(){
		//把日期输出格式设置成带有时间的 默认是没有时间的
		JSONDateOutputMode.setJSONDateToTimeMode();
		return iLessonInfoService.queryStuLessonInfoPlanList(getCurrLoginStudent().getId());
	}
	/**
	 * 跳转到用户预约课程培训页面
	 * @return
	 */
	@RequestMapping("toQueryStuLessonInfoPlanListPage")
	public String toQueryStuLessonInfoPlanListPage(){
		return "student/stuLessonInfoAction/lessonPlanManage";
	}
	
	//得到培训详细的科目二，科目三所有的完成和完成异常的
	@RequestMapping("lessonHistoryManage")
	public String lessonHistoryManage(){
		request.setAttribute("subCount", iLessonInfoService.queryStuLessonInfoCount(getCurrLoginStudent().getId()));
		return "student/stuLessonInfoAction/lessonHistoryManage";
	}
	
	@ResponseBody
	@RequestMapping("qureyStuLessonTrainInfo")
	public List<HashMap<String, Object>> qureyStuLessonTrainInfo(Integer subject){
		return iLessonInfoService.queryStuLessonTrainInfo(getCurrLoginStudent().getId(), subject);
	}
}
