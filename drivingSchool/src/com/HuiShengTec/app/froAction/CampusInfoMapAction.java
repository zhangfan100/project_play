package com.HuiShengTec.app.froAction;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.ICampusInfoService;
import com.HuiShengTec.base.action.BaseAction;
import com.HuiShengTec.base.cache.PropertiesCache;


/**
 * 地图
 * @author llj
 *
 */
@Controller
@Scope("prototype")
public class CampusInfoMapAction extends BaseAction {
	
	@Autowired
	private ICampusInfoService iCampusInfoService;
	
	@RequestMapping("/queryCampus")
	public String view(){
		PropertiesCache.fillRequestParam(request);
		//设置友情网站连接
		pushRequestValue("friend_links", PropertiesCache.getBasicPropertiesByType(55));
		return "front/campusInfoMapAction/campusInfoMap";
	}
	
	@RequestMapping("/queryCampusInfo")
	@ResponseBody
	public List<Map<String,Object>> queryCampus(){
		return iCampusInfoService.queryCampusInfo();
	}
	
	/**
	 * 根据驾校名称查询驾校信息
	 * @throws UnsupportedEncodingException 
	 * */
	@RequestMapping("/queryCampusInfoId")
	@ResponseBody
	public Map<String,Object> queryCampusName(Integer id){
		return iCampusInfoService.queryCampusName(id);
		
	}
	
	
	
	
}
