package com.HuiShengTec.base.cache;

import java.util.concurrent.ConcurrentHashMap;

import com.HuiShengTec.entity.Privilege;
import com.HuiShengTec.entity.RolePrivilege;
import com.HuiShengTec.utils.Toolkit;

/**
 * 权限缓存对象
 * @author mihuajun
 * @createTime 2014-11-21 下午3:53:32
 */
public class RolePrivilegeCache {
	private static ConcurrentHashMap<String,RolePrivilege> rolePrivileges = null;
	private static ConcurrentHashMap<String,Privilege> privileges = null;
	
	
	/**
	 * 刷新角色权限关系
	 * @author mihuajun
	 * @createTime 2014-11-21 下午6:40:03
	 * @param rolePrivileges
	 */
	public static void refreshRolePrivileges(ConcurrentHashMap<String,RolePrivilege> rolePrivileges){
		RolePrivilegeCache.rolePrivileges = rolePrivileges;
	}
	
	/**
	 * 刷新权限数据
	 * @author mihuajun
	 * @createTime 2014-11-21 下午6:42:04
	 * @param privileges
	 */
	public static void refreshPrivileges(ConcurrentHashMap<String,Privilege> privileges){
		RolePrivilegeCache.privileges = privileges;
	}
	public static Privilege getPrivilege(String uri){
		return privileges.get(uri);
	}
	public static boolean isInstance(){
		return !Toolkit.isEmpty(privileges);
	}
	
	public static RolePrivilege getRolePrivilege(Integer roleId,Integer privilegeId){
		return rolePrivileges.get(new StringBuffer("k").append(roleId).append("-").append(privilegeId).toString());
	}
	public static void putRolePrivilege(Integer roleId,Integer privilegeId,RolePrivilege rolePrivilege){
		rolePrivileges.put(new StringBuffer("k").append(roleId).append("-").append(privilegeId).toString(),rolePrivilege);
	}
	public static void removeRolePrivilege(Integer roleId,Integer privilegeId){
		rolePrivileges.remove(new StringBuffer("k").append(roleId).append("-").append(privilegeId).toString());
	}
}
