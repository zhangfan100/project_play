package com.HuiShengTec.app.magAction;

import java.util.List;
import com.HuiShengTec.app.core.BaseAction;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.ICampusInfoService;
import com.HuiShengTec.entity.CampusInfo;
import com.HuiShengTec.utils.Toolkit;

/**
 * 驾校管理
 * @author lj
 *
 */
@RequestMapping("/mag")
@Scope("prototype")
@Controller
public class CampusInfoAction extends BaseAction{
	
	@Autowired
	private ICampusInfoService iCampusInfoService;
	
	/**
	 * 驾校管理
	 * @return
	 */
	@RequestMapping("/campusInfo")
	public String view(){
		return "manage/campusInfoAction/campusInfo";
	}
	
	@RequestMapping("/queryCampusInfo")
	@ResponseBody
	public List<Map<String,Object>> queryCampusInfo(){
		
		return iCampusInfoService.queryCampusInfo();
		
	}
	@RequestMapping("editCampusInfoId")
	public String editCampusInfoId(Integer campusInfoId){
		request.setAttribute("campusInfo", iCampusInfoService.queryCampusInfoId(campusInfoId));
		return "manage/campusInfoAction/editCampuInfo";
	}
	@ResponseBody
	@RequestMapping("/editCampusInfoSubmit")
	public Integer editCampusInfoSubmit(CampusInfo data){
		iCampusInfoService.editCampusInfoSubmit(data);
		return 1;
	}
	
	@ResponseBody
	@RequestMapping("/delCampusInfo")
	public Integer delCampusInfo(Integer id){
		iCampusInfoService.delCampusInfo(id);
		return 1;
	}
	
	@ResponseBody
	@RequestMapping("/addCampusInfo")
	public Integer addCampusInfo(CampusInfo data){
		 if(!Toolkit.isEmpty(iCampusInfoService.addCampusInfo(data))){
			 return 1;
			 }
		 return 0;
	}

}
