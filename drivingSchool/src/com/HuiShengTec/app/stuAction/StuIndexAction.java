package com.HuiShengTec.app.stuAction;


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
 * 学员主界面
 * @author llj
 *
 */
@Controller
@RequestMapping("stu")
public class StuIndexAction extends BaseAction{
	@Autowired
	private IRolePrivilegeService iRolePrivilegeService;
	
	
	@RequestMapping("stuIndex")
	public ModelAndView index(String sign){
		
		ModelAndView andView = new ModelAndView("student/stuIndexAction/stuIndex");
		andView.addObject("logoPath", PropertiesCache.getValue("jxlogo"));
		andView.addObject("jx_chineseName", PropertiesCache.getValue("jx_chineseName"));
		andView.addObject("jx_englishName", PropertiesCache.getValue("jx_englishName"));
		andView.addObject("jx_englishName", PropertiesCache.getValue("jx_englishName"));
		andView.addObject("sign", Toolkit.isEmpty(sign)?"myinfo":sign);
		
		//设置友情网站连接
		pushRequestValue("friend_links", PropertiesCache.getBasicPropertiesByType(55));
		//获取菜单
				Login loginInfo = (Login)getSessionData("loginInfo");
				if(Toolkit.isEmpty(loginInfo) || Toolkit.isEmpty(loginInfo.getRoleId())){
					return andView;
				}
				PropertiesCache.fillRequestParam(request);
				andView.addObject("stumenu",iRolePrivilegeService.queryPrivilegeMenu(loginInfo.getRoleId()));
				return andView;
		}
				

	/**
	 * 我的课程
	 * @return
	 */
	@RequestMapping("mycourse")
	public String myCourse(){
		if (!Toolkit.isEmpty(getCurrLoginInfo())) {
			return "redirect:queryStuLessonInfoPlanList";
		}
		request.setAttribute("sign", "mycourse");
		return "student/loginAction/stuLogin";
	}
	/**
	 * 在线预约
	 * @return
	 */
	@RequestMapping("onlinebooking")
	public String onlineBooking(){
		if (!Toolkit.isEmpty(getCurrLoginInfo())) {
			return "redirect:addLessonInfo";
		}
		request.setAttribute("sign", "onlinebooking");
		return "student/loginAction/stuLogin";
	}
}
