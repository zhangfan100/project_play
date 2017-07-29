package com.HuiShengTec.entity;

import java.io.Serializable;

/**
 * @author mihuajun
 *
 */
public class Privilege implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String url;
	private Integer roleType;
	//是用来判断对应菜单是否需要登录显示
	private Boolean loginFlag;
	//判断操作是否需要记录到日志中
	private Boolean logFlag;
	private String content;
	private Boolean isMenu;
	private Integer pid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(Boolean loginFlag) {
		this.loginFlag = loginFlag;
	}
	public Boolean getLogFlag() {
		return logFlag;
	}
	public void setLogFlag(Boolean logFlag) {
		this.logFlag = logFlag;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getRoleType() {
		return roleType;
	}
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}
	public Boolean getIsMenu() {
		return isMenu;
	}
	public void setIsMenu(Boolean isMenu) {
		this.isMenu = isMenu;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	
}
