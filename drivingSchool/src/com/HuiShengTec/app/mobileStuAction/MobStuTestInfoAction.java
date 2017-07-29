package com.HuiShengTec.app.mobileStuAction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.IStuInfoService;
import com.HuiShengTec.app.service.ITestInfoService;
import com.HuiShengTec.base.cache.PropertiesCache;
import com.HuiShengTec.entity.TestInfo;
import com.HuiShengTec.utils.Toolkit;
/**
 * 模考历史
 * @author llj
 *
 */
@RequestMapping("mobile")
@Controller("mobileStuTestInfoAction")
public class MobStuTestInfoAction extends BaseAction {
	@Autowired
	private ITestInfoService iTestInfoService;
	@Autowired
	private IStuInfoService infoService;
	
	/**
	 * 约考界面
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryTestInfo")
	public Map<String, Object> queryTestInfo() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("price", PropertiesCache.getValue("testPrice"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		calendar.add(calendar.DATE, 1);
		result.put("beginDate", sdf.format(calendar.getTime()));
		calendar.add(calendar.DATE, 7);
		result.put("endDate", sdf.format(calendar.getTime()));
		return result;
	}

	
	/**
	 * 查询模考历史记录
	 */
	@ResponseBody
	@RequestMapping("queryStuTestInfo")
	public List<HashMap<String, Object>> queryStuTestInfoList(){
		return iTestInfoService.queryStuTestInfoList(getCurrLoginStudent().getId());
	}
	
	/**
	 * 预约模考
	 * @param info
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping("addTestInfoSubmit")
	public HashMap<String, Object> addTestInfoSubmit(TestInfo info) throws ParseException {
		Integer test=iTestInfoService.addTestInfo(info, getCurrLoginStudent());
		if(test==0){
			//预约成功
			return Toolkit.initMapCondition("state", 0);
		}else if(test==1){
			// 判断约考的时期(必须提交一天预约)
			return Toolkit.initMapCondition("state", 1);
		}else if(test==2){
			// 单人考试限制
			return Toolkit.initMapCondition("state", 2);
		}else if(test==3){
			// 考试人数是否已满
			return Toolkit.initMapCondition("state", 3);
		}
		return null;
		
	}
	/**
	 * 取消预约
	 * @param id
	 */
	@ResponseBody
	@RequestMapping("cancelPExam")
	public HashMap<String, Object> cancelPExam(String id){
		if(!Toolkit.isEmpty(id)){
			iTestInfoService.cancelTestInfo(id);
			HashMap<String, Object> result = (HashMap<String, Object>) infoService.queryStudentInfo(getCurrLoginStudent().getId());
			String path = (String) result.get("path");
			result.put("path",Toolkit.isEmpty(path) ? null : request.getContextPath() + path);
			return result;
		}else{
			return Toolkit.initMapCondition("error", 0);
		}
		
	}
}
