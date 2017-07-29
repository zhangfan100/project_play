package com.HuiShengTec.app.cohAction;

import org.springframework.beans.factory.annotation.Autowired;
import com.HuiShengTec.app.core.BaseAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.app.service.IRolePrivilegeService;
import com.HuiShengTec.base.cache.PropertiesCache;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.utils.Toolkit;


/**
 * 教员主界面
 * @author 刘霖晋
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("coh")
public class CohIndexAction extends BaseAction {
	
//	@Autowired
//	private IMyStudentService studentService;

	@Autowired
	private IRolePrivilegeService iRolePrivilegeService;
	
	@RequestMapping("cohIndex")
	public ModelAndView cohIndex(){
		ModelAndView andView = new ModelAndView("coach/cohIndexAction/cohIndex");
		andView.addObject("logoPath", PropertiesCache.getValue("jxlogo"));
		andView.addObject("jx_chineseName", PropertiesCache.getValue("jx_chineseName"));
		andView.addObject("jx_englishName", PropertiesCache.getValue("jx_englishName"));
		
		//获取菜单
		Login loginInfo = (Login)getSessionData("loginInfo");
		if(Toolkit.isEmpty(loginInfo) || Toolkit.isEmpty(loginInfo.getRoleId())){
			return andView;
		}
		andView.addObject("menu",iRolePrivilegeService.queryPrivilegeMenu(loginInfo.getRoleId()));
		return andView;
		
	}
//	request.setAttribute("myStudentTotal", studentService.queryMyStudentCount(((CoachInfo )session.getAttribute("userInfo")).getId()));
	
}
