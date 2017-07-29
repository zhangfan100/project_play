package com.HuiShengTec.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author llj
 *
 */
public class OperationLog implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer functionId;
	private Date time;
	private String userName;
	private Integer userType;
	private String iP;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFunctionId() {
		return functionId;
	}
	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getiP() {
		return iP;
	}
	public void setiP(String iP) {
		this.iP = iP;
	}
	

}
