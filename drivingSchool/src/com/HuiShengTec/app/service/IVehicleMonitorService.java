package com.HuiShengTec.app.service;

import java.util.Map;

public interface IVehicleMonitorService {

	 /**
	  * 传来车的经纬度和车的id 在最近的距离标示50m时的第一次返回一个id和title
	  * @author zf
	  */
	Map<String, Object> getFirstJudge(Map<String, Object> param);

}

