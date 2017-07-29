package com.HuiShengTec.app.magAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ISysAdminInfoService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
/**
 * 教学人员管理
 * @author 王泰然
 *
 */
@Controller
@RequestMapping("/mag")
@Scope("prototype")
public class UserManageAction extends BaseAction {
	@Autowired
	private ISysAdminInfoService iSysAdminInfoService;
	
	/**
	 * 管理员管理
	 * @return
	 */
	@RequestMapping("adminManage")
	public String adminManage(){
		return "manage/userManageAction/adminManage";
	}

	@ResponseBody
	@RequestMapping("querySysAdminPage")
	public PageBean querySysAdminPage(PageInfo info){
		return iSysAdminInfoService.querySysAdminInfoPage(info);
	}
	
	@ResponseBody
	@RequestMapping("setAdminStatus")
	public Integer setAdminStatus(String idStr,Integer status){
		iSysAdminInfoService.setAdminStatus(idStr, status);
		return 1;
	}
}
