package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.CarBrand;

public interface ICarBrandDao extends IBaseDao{
	public List<HashMap<String, Object>> queryCarBrandPage(PageBean page);
	
	public CarBrand queryCarBrandById(Integer id);
	
	public void updateCarBrand(CarBrand brand);
	
	public List<CarBrand> queryCarBrand();
	
	public void addCarBrand(CarBrand brand);
}
