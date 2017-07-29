package com.HuiShengTec.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.Privilege;
import com.HuiShengTec.entity.Role;
import com.HuiShengTec.entity.RolePrivilege;

public interface IRolePrivilegeService{
	public PageBean queryRolePage(PageInfo info);
	public List<HashMap<String, Object>> queryRolePrivilege(Integer roleId);
	public void updateRolePrivilege(String rolePrivilege,Integer roleId);
	
	/**
	 * 查询所属权限菜单
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> queryPrivilegeMenu(Integer roleId);
	
	/**
	 * roleType
	 * @author 查询指定角色权限
	 * @createTime 2014-11-7 下午3:17:35
	 * @param roleType
	 * @return
	 */
	List<Role> queryRoleByType(Integer roleType);
	
	/**
	 * 查询所有权限
	 * @author mihuajun
	 * @createTime 2014-11-21 下午4:19:04
	 * @return
	 */
	ConcurrentHashMap<String, Privilege> queryAllPrivilege();
	/**
	 * 查询所有权限角色关系RolePrivileges
	 * @author mihuajun
	 * @createTime 2014-11-21 下午6:53:38
	 * @return
	 */
	ConcurrentHashMap<String, RolePrivilege> queryAllRolePrivilege();
}
