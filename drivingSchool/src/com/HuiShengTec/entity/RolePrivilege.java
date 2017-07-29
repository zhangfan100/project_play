package com.HuiShengTec.entity;

import java.io.Serializable;

/**
 * @author mihuajun
 *
 */
public class RolePrivilege implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer roleId;
	private Integer privilegeId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(Integer privilegeId) {
		this.privilegeId = privilegeId;
	}
	
	
}
