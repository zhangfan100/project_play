package com.HuiShengTec.app.stuAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.HuiShengTec.app.core.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.ILessonStatisticsService;
import com.HuiShengTec.base.messageConverter.JSONDateOutputMode;

/**
 * 
 * 学员信息统计
 * @author llj
 *
 */
@Controller
@RequestMapping("stu")
public class LessonStatisticsAction extends BaseAction {
	
	@Autowired
	private ILessonStatisticsService iLessonStatisticsService;
	
	@RequestMapping("studentStatistics")
	public String forwardStudenStatistics(){
		return "student/lessonStatisticsAction/lessonStatistics";
	}
	
	
	
	/**
	 * 学员最近七天培训统计（图表）
	 * @return
	 */
	@RequestMapping("/queryTrainStatistics")
	@ResponseBody
	public Map<String,Object> queryTrainStatistics(){
		JSONDateOutputMode.setJSONDateToTimeMode();
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("stuId",getCurrLoginStudent().getId());
		return iLessonStatisticsService.queryTrainStatistics(param);
	}
	
	/**
	 * 统计学员各项目通过率，制成表格
	 * @return
	 */
	@RequestMapping("/queryTrainStatisticsTable")
	@ResponseBody
	public List<Map<String, Object>> queryTrainStatisticsTable(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("stuId",getCurrLoginStudent().getId());
		return iLessonStatisticsService.queryTrainStatisticsTable(param);
	}
	
	/**
	 * 培训学时统计
	 * @return
	 */
	@RequestMapping("/queryPeriodStatistics")
	@ResponseBody
	public List<Map<String, Object>> queryPeriodStatistics(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("stuId",getCurrLoginStudent().getId());
		return iLessonStatisticsService.queryPeriodStatistics(param);
	}
}
