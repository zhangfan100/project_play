package com.HuiShengTec.app.service;

import java.util.List;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.CarBrand;

public interface ICarBrandService {
	public PageBean queryCarBrandPage(PageInfo info);
	public CarBrand queryCarBrandById(Integer id);
	public void saveCarBrand(CarBrand brand);
	public List<CarBrand> queryCarBrand();
	public void addCarBrand(CarBrand brand);
}
