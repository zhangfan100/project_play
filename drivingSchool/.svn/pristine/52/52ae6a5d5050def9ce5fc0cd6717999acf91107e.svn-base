package com.HuiShengTec.app.magAction;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.IRolePrivilegeService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.Role;
import com.HuiShengTec.utils.Toolkit;

@Controller
@RequestMapping("mag")
@Scope("prototype")
public class RolePrivilegeAction extends BaseAction {
	@Autowired
	private IRolePrivilegeService iRolePrivilegeService;

	/**
	 * 角色权限管理界面
	 * 
	 * @return
	 */
	@RequestMapping("roleManage")
	public String roleManage() {
		return "manage/rolePrivilegeAction/roleManage";
	}

	@ResponseBody
	@RequestMapping("queryRolePage")
	public PageBean queryRolePage(PageInfo info, Integer roleType) {
		if (Toolkit.isEmpty(roleType)) {
			roleType = 3;
		}
		info.addConditions("roleType", roleType);
		return iRolePrivilegeService.queryRolePage(info);
	}
	
	/**
	 * 查询指定角色权限
	 * @author mihuajun
	 * @createTime 2014-11-7 下午3:16:27
	 * @param roleType
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryRoleByType")
	public List<Role> queryRoleByType(Integer roleType) {
		return iRolePrivilegeService.queryRoleByType(roleType);
	}

	/**
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping("rolePrivilegeEdit")
	public String rolePrivilegeEdit(Integer roleId) {
		request.setAttribute("rolePrivilege", Toolkit.toJson(
				iRolePrivilegeService.queryRolePrivilege(roleId), null));
		request.setAttribute("roleId", roleId);
		return "manage/rolePrivilegeAction/rolePrivilegeEdit";
	}
	/**
	 * 提交修改角色权限
	 * @param rolePrivilege
	 * @param roleId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("rolePrivilegeEditSubmit")
	public Integer rolePrivilegeEditSubmit(String rolePrivilege,Integer roleId) {
		iRolePrivilegeService.updateRolePrivilege(rolePrivilege, roleId);
		return 1;
	}

}
