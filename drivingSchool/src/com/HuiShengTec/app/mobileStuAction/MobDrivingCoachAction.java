package com.HuiShengTec.app.mobileStuAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ICampusInfoService;
import com.HuiShengTec.app.service.ICoachInfoService;

/**
 * 找驾校找教练
 * @author llj
 */
@RequestMapping("/mobile")
@Controller
@Scope("prototype")
public class MobDrivingCoachAction extends BaseAction{
	@Autowired
	private ICampusInfoService iCampusInfoService;
	@Autowired
	private ICoachInfoService iCoachInfoService;
	
	/**
	 * 找驾校
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryCampusInfo")
	public List<Map<String, Object>> queryCampusInfo(){
		return iCampusInfoService.queryCampusInfo();
	}
	
	/**
	 * 找教练
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryCoachInfoById")
	public List<HashMap<String, Object>> queryCoachInfoById(Integer campusId){
		return iCoachInfoService.queryCoachInfoById(campusId);
	}
}
