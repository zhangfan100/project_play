package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.entity.Privilege;
import com.HuiShengTec.entity.Role;
import com.HuiShengTec.entity.RolePrivilege;

public interface IRolePrivilegeDao extends IBaseDao { 
	public List<HashMap<String, Object>> queryRolePrivilege(Role role);
	public void addRolePrivilege(RolePrivilege rp);
	public Integer delRolePrivilege(RolePrivilege rp);
	
	/**
	 * 查询所属权限菜单
	 * @return
	 */
	public List<Map<String, Object>> queryPrivilegeMenu(Integer roleId);
	
	/**
	 * 查询所有权限
	 * @author mihuajun
	 * @createTime 2014-11-21 下午4:19:54
	 * @return
	 */
	public List<Privilege> queryAllPrivilege();
	/**
	 * 查询所有权限角色关系RolePrivileges
	 * @author mihuajun
	 * @createTime 2014-11-21 下午6:53:49
	 * @return
	 */
	public List<RolePrivilege> queryAllRolePrivilege();
	
}
