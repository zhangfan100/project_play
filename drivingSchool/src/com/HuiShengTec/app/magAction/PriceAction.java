package com.HuiShengTec.app.magAction;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.IBasicPropertiesService;
import com.HuiShengTec.app.service.ICarBrandService;
import com.HuiShengTec.app.service.IDrivingLicenceService;
import com.HuiShengTec.app.service.IPriceService;
import com.HuiShengTec.base.action.BaseAction;
import com.HuiShengTec.entity.DrivingLicence;
import com.HuiShengTec.entity.TimePrice;
import com.HuiShengTec.entity.WeekPrice;

/**
 * 价格管理
 * @author mihuajun
 * @createTime 2014-11-6 上午12:43:19
 */
@Controller
@RequestMapping("mag")
public class PriceAction extends BaseAction{
	
	@Autowired
	private IDrivingLicenceService iDrivingLicenceService;
	
	@Autowired
	private IPriceService iPriceService;
	
	@Autowired
	private IBasicPropertiesService iBasicPropertiesService;
	
	@Autowired
	private ICarBrandService iCarBrandService;
	
	
	/**
	 * 价格管理菜单栏
	 * @return
	 */
	@RequestMapping("priceMenuBar")
	public String priceMenuBar(){
		return "manage/priceAction/priceMenuBar";
	}
	
	/**
	 * 时段差价管理页
	 * @return
	 */
	@RequestMapping("timeManage")
	public String timeManage(){
		return "manage/priceAction/timeManage";
	}
	
	/**
	 * 星期差价管理页
	 * @return
	 */
	@RequestMapping("weekManage")
	public String weekManage(){
		return "manage/priceAction/weekManage";
	}
	
	/**
	 * 驾照差价管理页
	 * @return
	 */
	@RequestMapping("drivingLicenseManage")
	public String drivingLicenseManage(){
		return "manage/priceAction/drivingLicenseManage";
	}
	
	/**
	 * 品牌差价管理页
	 * @return
	 */
	@RequestMapping("vehicleManage")
	public String vehicleManage(){
		return "manage/carManageAction/carBrandManage";
	}
	
	/**
	 * 基础差价管理页
	 * @return
	 */
	@RequestMapping("baseManage")
	public String baseManage(){
		request.setAttribute("basicPrice",iBasicPropertiesService.getBasicPropInfoKey("basicPrice"));
		return "manage/priceAction/baseManage";
	}
	
	/**
	 * 七天价格管理页
	 * @return
	 */
	@RequestMapping("sevenDayManage")
	public String sevenDayManage(Model model){
		model.addAttribute("carBrands",iCarBrandService.queryCarBrand());
		model.addAttribute("timePrice", iPriceService.queryTimePrice());
		model.addAttribute("drivingLicence", iDrivingLicenceService.queryCurrentDrivingLicence());
		return "manage/priceAction/sevenDayManage";
	}
	
	/**
	 * 查询驾照类型
	 * @return
	 */
	@RequestMapping("/queryAllDrivingLicence")
	@ResponseBody
	public List<DrivingLicence> queryAllDrivingLicence(){
		return iDrivingLicenceService.queryAllDrivingLicence();
	}
	
	/**
	 * 查询七天价格
	 * @param licenceType
	 * @param carFlag
	 * @return
	 */
	@RequestMapping("/querySevenPrice")
	@ResponseBody
	public List<HashMap<String, Object>> querySevenPrice(Integer licenceId,Integer carBrandId){
		return iPriceService.queryDatePrice(licenceId,carBrandId,null);
	}
	
	/**
	 * 更新七天价格
	 * @param licenceType
	 * @param carFlag
	 * @param date
	 * @param time
	 * @param price
	 * @return
	 */
	@RequestMapping("/updateSevenDaySubmit")
	@ResponseBody
	public Integer updateSevenDaySubmit(Integer licenceId,Integer carBrandId,String date,Integer time,Integer price){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("licenceId", licenceId);
		param.put("carBrandId", carBrandId);
		param.put("date", date);
		param.put("time", time);
		param.put("price", price);
		return iPriceService.updateSevenDaySubmit(param);
	}
	
	/**
	 * 查询时段差价,所有状态
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/queryAllTimePriceList")
	@ResponseBody
	public List<TimePrice> queryAllTimePriceList(){
		return iPriceService.queryAllTimePriceList();
	}
	
	
	/**
	 *时间价格-编辑信息提交
	 * @param timePriceInfo
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/editTimePriceSubmit")
	public void editTimePriceSubmit(TimePrice timePriceInfo) throws IOException{
		iPriceService.editTimePriceSubmit(timePriceInfo);
		printSingleWordJson(1);
	}
	
	/**
	 * 时间价格-启用、禁用
	 * @author mihuajun
	 * @createTime 2014-11-6 上午1:15:15
	 * @param ids
	 * @param status
	 * @return
	 */
	@RequestMapping("/editTimePriceStatus")
	@ResponseBody
	public Integer editTimePriceStatus(String ids,Integer status){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("status", status);
		param.put("ids", ids.split(","));
		return iPriceService.editTimePriceStatus(param);
	}
	
	/**
	 * 星期差价
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/queryWeekManage")
	@ResponseBody
	public List<WeekPrice> queryWeekManage(){
		return iPriceService.queryWeekManage();
	}
	
	/**
	 *编辑信息提交
	 * @param weekPriceInfo
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/editWeekManageSubmit")
	@ResponseBody
	public void editWeekPriceSubmit(WeekPrice weekPriceInfo) throws IOException{
		iPriceService.editWeekManageSubmit(weekPriceInfo);
		printSingleWordJson(1);
	}
	
	/**
	 * 编辑驾驶证差价状态
	 * @author mihuajun
	 * @createTime 2014-11-6 上午2:12:33
	 */
	@RequestMapping("editDrivingLicenceStatus")
	@ResponseBody
	public void editDrivingLicenceStatus(Integer status,String ids){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("status", status);
		param.put("ids", ids.split(","));
		iPriceService.editDrivingLicenceStatus(param);
	}
	
	/**
	 * 编辑驾驶证差价 价格
	 * @author mihuajun
	 * @createTime 2014-11-6 上午2:29:06
	 * @param drivingLicence
	 * @return
	 */
	@RequestMapping("editDrivingLicenceSubmit")
	@ResponseBody
	public Integer editDrivingLicenceSubmit(DrivingLicence drivingLicence){
		return iPriceService.editDrivingLicenceSubmit(drivingLicence);
	}
}
