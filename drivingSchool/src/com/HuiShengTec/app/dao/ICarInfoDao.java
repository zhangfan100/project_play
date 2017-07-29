package com.HuiShengTec.app.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.CarInfo;

public interface ICarInfoDao extends IBaseDao {
	
	public List<HashMap<String, Object>> queryCarInfoPage(PageBean bean);

	public HashMap<String, Object> queryCarInfo(Integer cohId);
	
	public CarInfo queryCarInfoById(Integer id);
	
	public void updateCarInfo(CarInfo info);
	
	public void addCarInfo(CarInfo info);
	
	/**
	 * 查询前四辆的未分配车辆-教练训练车型
	 * @param q
	 * @return
	 */
	public List queryUndistCar(Map<String,Object> param);
	
	public Integer queryFirstFreeCarId(Date beginTime);
}
