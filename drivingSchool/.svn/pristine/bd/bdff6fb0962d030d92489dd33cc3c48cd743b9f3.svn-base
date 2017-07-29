package com.HuiShengTec.app.mobileStuAction;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ILessonStatisticsService;
import com.HuiShengTec.base.messageConverter.JSONDateOutputMode;
import com.HuiShengTec.utils.Toolkit;

/**
 * 培训统计接口
 * @author mihuajun
 * @createTime 2014-11-17 下午12:05:36
 */


@RequestMapping("/mobile")
@Controller
@Scope("prototype")
public class MobLessonStatisticsAction extends BaseAction {
	
	@Autowired
	private ILessonStatisticsService iLessonStatisticsService;
	
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
	public Map<String, Object> queryPeriodStatistics(){
		Map<String,Object> param = Toolkit.initMapCondition("stuId", getCurrLoginStudent().getId());
		JSONDateOutputMode.setJSONDateToTimeMode();
		List<Map<String, Object>> data=iLessonStatisticsService.queryPeriodStatistics(param);
		Map<String,Object> result = Toolkit.initMapCondition("data", data);
		result.put("time", new Date());
		return result;
	}
}
