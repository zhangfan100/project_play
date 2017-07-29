package com.HuiShengTec.app.magAction;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.IVehicleMonitorService;
import com.HuiShengTec.utils.PushletUtil;
import com.alibaba.fastjson.JSON;

/**
 * ****************************************************************************
 * 
 * @Description: [车辆实时监控位置]
 * @Author: [llj]
 * @CreateDate: [2015年4月20日 下午2:47:36]
 * @Version: [v1.0]
 */
@RequestMapping("/mag")
@Scope("prototype")
@Controller
public class VehicleMonitorAction extends BaseAction {
	
	@Autowired
	private IVehicleMonitorService iVehicleMonitorService;

	/**
	 * 
	 * @Description: TODO(跳转到车辆地图页面)
	 * @author [llj]
	 */
	@RequestMapping("vehicleMonitorManage")
	public String vehicleMonitorManage() {
		return "manage/vehicleMonitorAction/vehicleMonitorManage";
	}
	
	 /**
	  * 
	  * @Description: TODO(传输GPS)
	  * @author [llj]
	  */
	 @RequestMapping("setGPS")
	 @ResponseBody
	public Integer setGPS(@RequestParam Map<String, String> param) {
		PushletUtil.addPushData("message",JSON.toJSONString(param));
		return 1;
	}
	 
	 /**
	  * 传来车的经(lng)纬(lat)度 在最近的距离标示50m时的第一次返回一个id和title
	  * 如果没得50米 返回null
	  * @author zf
	  */
	 @RequestMapping("getFirstJudge")
	 @ResponseBody 
	 public Map<String, Object> getFirstJudge(@RequestParam Map<String, Object> param) {
		 return iVehicleMonitorService.getFirstJudge(param);
	 }
	 
	
	
}
