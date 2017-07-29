package com.HuiShengTec.app.magAction;

import org.springframework.beans.factory.annotation.Autowired;
import com.HuiShengTec.app.core.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.app.service.IRolePrivilegeService;
import com.HuiShengTec.base.cache.PropertiesCache;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.utils.Toolkit;

/**
 * 管理员首页
 * @author mihuajun
 *	
 */
@Controller
@RequestMapping("mag")
public class MagIndexAction extends BaseAction {
	
	@Autowired
	private IRolePrivilegeService iRolePrivilegeService;
	
	@RequestMapping("magIndex")
	public ModelAndView index(){
		ModelAndView andView = new ModelAndView("manage/magIndexAction/magIndex");
		andView.addObject("logoPath", PropertiesCache.getValue("jxlogo"));
		andView.addObject("jx_chineseName", PropertiesCache.getValue("jx_chineseName"));
		andView.addObject("jx_englishName", PropertiesCache.getValue("jx_englishName"));
		
		//获取菜单
		Login loginInfo = (Login)getSessionData("loginInfo");
		if(Toolkit.isEmpty(loginInfo) || Toolkit.isEmpty(loginInfo.getRoleId())){//走这里说明登录失败的
			return andView;
		}
		
		//走这里说明登录成功的
		andView.addObject("menu",iRolePrivilegeService.queryPrivilegeMenu(loginInfo.getRoleId()));
		
		return andView;
	}
}
