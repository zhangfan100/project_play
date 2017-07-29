package com.HuiShengTec.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ICarBrandDao;
import com.HuiShengTec.app.service.ICarBrandService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.CarBrand;
import com.HuiShengTec.utils.Toolkit;

@Service
@Transactional
public class CarBrandServiceImpl implements ICarBrandService {
	@Autowired
	private ICarBrandDao iCarBrandDao;

	public PageBean queryCarBrandPage(PageInfo info){
		PageBean bean =Toolkit.fillPageInfo(info);
		bean.setRows(iCarBrandDao.queryCarBrandPage(bean));
		return bean;
	}
	
	public CarBrand queryCarBrandById(Integer id){
		return iCarBrandDao.queryCarBrandById(id);
	}
	
	public void saveCarBrand(CarBrand brand){
		iCarBrandDao.updateCarBrand(brand);
	}
	public List<CarBrand> queryCarBrand(){
		return iCarBrandDao.queryCarBrand();
	}
	
	public void addCarBrand(CarBrand brand){
		iCarBrandDao.addCarBrand(brand);
	}
	
}
