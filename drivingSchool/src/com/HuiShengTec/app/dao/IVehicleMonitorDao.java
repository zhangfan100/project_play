package com.HuiShengTec.app.dao;

import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;

public interface IVehicleMonitorDao extends IBaseDao {

	 /**
	  * 传来车的经纬度和车的id 在最近的距离标示50m时的第一次返回一个id和title
	  * @author zf
	  */
	Map<String, Object> getFirstJudge(Map<String, Object> param);

}

