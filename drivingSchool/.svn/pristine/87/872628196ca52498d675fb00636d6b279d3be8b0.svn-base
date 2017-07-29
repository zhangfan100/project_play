package com.HuiShengTec.app.froAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.IFroIndexService;
import com.HuiShengTec.base.action.BaseAction;
import com.HuiShengTec.base.cache.PropertiesCache;

@Controller
@Scope("prototype")
public class FroIndexAction extends BaseAction {
	@Autowired
	private IFroIndexService iFroIndexService;

	/**
	 * 前台主页
	 * @return
	 */
	@RequestMapping("froIndex")
	public String froIndex(){
		HashMap<String, Object> map = iFroIndexService.queryFroIndexData();
		request.setAttribute("IndexData", map);
		PropertiesCache.fillRequestParam(request);
		//设置友情网站连接
		pushRequestValue("friend_links", PropertiesCache.getBasicPropertiesByType(55));
		return "front/froIndexAction/froIndex";
	}
	
	/**
	 * 查询所有动态菜单 
	 * @return
	 */
	@RequestMapping("/queryMenu")
	@ResponseBody
	public List<Map<String,Object>> queryMenu(){
		return iFroIndexService.queryMenu();
	}
	
	@ResponseBody
	@RequestMapping("querySchoolTeacher")
	public List<HashMap<String,Object>> querySchoolTeacher(Integer schoolId){
		return iFroIndexService.queryCoachInfo(schoolId);
	}
	@ResponseBody
	@RequestMapping("querySchoolStudent")
	public List<HashMap<String,Object>> querySchoolStudent(Integer schoolId){
		return iFroIndexService.querySchoolTopStu(schoolId);
	}
}
