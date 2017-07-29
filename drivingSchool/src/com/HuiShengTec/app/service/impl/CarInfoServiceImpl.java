package com.HuiShengTec.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ICarInfoDao;
import com.HuiShengTec.app.service.ICarInfoService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.CarInfo;
import com.HuiShengTec.utils.Toolkit;

@Service
@Transactional
public class CarInfoServiceImpl implements ICarInfoService {
	@Autowired
	private ICarInfoDao iCarInfoDao;

	public PageBean queryCarInfoPage(PageInfo info){
		PageBean bean = Toolkit.fillPageInfo(info);
		bean.setRows(iCarInfoDao.queryCarInfoPage(bean));
		return bean;
	}
	
	public CarInfo queryCarInfoById(Integer id){
		return iCarInfoDao.queryCarInfoById(id);
	}
	
	public void updateCarInfo(CarInfo info){
		iCarInfoDao.updateCarInfo(info);
	}
	public void addCarInfo(CarInfo info){
		iCarInfoDao.addCarInfo(info);
	}

	
	/**
	 * 查询前四辆的未分配车辆-教练训练车型
	 */
	@Override
	public List queryUndistCar(Map<String,Object> param) {
		// TODO Auto-generated method stub
		return iCarInfoDao.queryUndistCar(param);
	}
		
	
}
