package com.HuiShengTec.app.magAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ICarBrandService;
import com.HuiShengTec.app.service.ICarInfoService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.CarBrand;
import com.HuiShengTec.entity.CarInfo;
import com.HuiShengTec.utils.Toolkit;

@Controller
@RequestMapping("mag")
@Scope("prototype")
public class CarManageAction extends BaseAction {
	@Autowired
	private ICarBrandService iCarBrandService;
	@Autowired
	private ICarInfoService iCarInfoService;

	@RequestMapping("carBrandManage")
	public String carBrandManage(){
		return "manage/carManageAction/carBrandManage";
	}
	
	@ResponseBody
	@RequestMapping("queryCarBrandPage")
	public PageBean queryCarBrandPage(PageInfo info){
		return iCarBrandService.queryCarBrandPage(info);
	}
	
	@RequestMapping("carInfoManage")
	public String carInfoManage(){
		return "manage/carManageAction/carInfoManage";
	}
	
	
	@RequestMapping("editCarBrand")
	public String editCarBrand(Integer brandId){
		request.setAttribute("currCarBrand", iCarBrandService.queryCarBrandById(brandId));
		return "manage/carManageAction/editCarBrand";
	}
	@ResponseBody
	@RequestMapping("editCarBrandSubmit")
	public Integer editCarBrandSubmit(CarBrand data){
		iCarBrandService.saveCarBrand(data);
		return 1;
	}
	
	@ResponseBody
	@RequestMapping("queryCarInfoPage")
	public PageBean queryCarInfoPage(PageInfo info){
		return iCarInfoService.queryCarInfoPage(info);
	}
	@RequestMapping("editCarInfo")
	public String editCarInfo(Integer id){
		CarInfo info = iCarInfoService.queryCarInfoById(id);
		String temp="";
		String[] allowLicences=info.getAllowLicenceType().split(",");
		for (int i = 0; i < allowLicences.length; i++) {
			temp+="'"+allowLicences[i]+"',";
		}
		info.setAllowLicenceType(temp);
		request.setAttribute("currCarInfo",info );
		return "manage/carManageAction/editCarInfo";
	}
	@ResponseBody
	@RequestMapping("editCarInfoSubmit")
	public Integer editCarBrandSubmit(CarInfo data){
		iCarInfoService.updateCarInfo(data);
		return 1;
	}
	
	@RequestMapping("addCarBrand")
	public String addCarBrand(){
		return "manage/carManageAction/addCarBrand";
	}
	
	@ResponseBody
	@RequestMapping("addCarBrandSubmit")
	public Integer addCarBrandSubmit(CarBrand brand){
		iCarBrandService.addCarBrand(brand);
		return 1;
	}
	
	@RequestMapping("addCarInfo")
	public String addCarInfo(){
		return "manage/carManageAction/addCarInfo";
	}
	@RequestMapping("addCarInfoSubmit")
	public Integer addCarInfoSubmit(CarInfo info){
		iCarInfoService.addCarInfo(info);
		return 1;
	}
	
	/**
	 * 查询前四辆的未分配车辆-教练训练车型
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("queryUndistCar")
	@ResponseBody
	public List<Map<String,Object>> queryUndistCar(String q,Integer id){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("q", Toolkit.isEmpty(q)?null:q);
		param.put("id", Toolkit.isEmpty(id)?null:id);
		
		return iCarInfoService.queryUndistCar(param);
	}
}
