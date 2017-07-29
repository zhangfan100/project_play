package com.HuiShengTec.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author llj
 *
 */
public class SignInLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer userId;
	private String userName;
	private Integer roleType;
	private Date loginTime;
	private String loginIP;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getRoleType() {
		return roleType;
	}
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginIP() {
		return loginIP;
	}
	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}
	

}
