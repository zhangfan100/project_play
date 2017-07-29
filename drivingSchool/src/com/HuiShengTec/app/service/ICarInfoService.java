package com.HuiShengTec.app.service;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.CarInfo;

public interface ICarInfoService {
	public PageBean queryCarInfoPage(PageInfo info);
	public CarInfo queryCarInfoById(Integer id);
	public void updateCarInfo(CarInfo info);
	public void addCarInfo(CarInfo info);
	
	/**
	 * 查询前四辆的未分配车辆-教练训练车型
	 * @param q
	 * @return
	 */
	public List queryUndistCar(Map<String,Object> param);
}
