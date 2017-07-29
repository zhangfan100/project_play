package com.HuiShengTec.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author llj
 *
 */
public class ExceptionLog implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String exceptionTitle;
	private String exceptionContent;
	private Date exceptionTime;
	private String userName;
	private Integer userFlag;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getExceptionTitle() {
		return exceptionTitle;
	}
	public void setExceptionTitle(String exceptionTitle) {
		this.exceptionTitle = exceptionTitle;
	}
	public String getExceptionContent() {
		return exceptionContent;
	}
	public void setExceptionContent(String exceptionContent) {
		this.exceptionContent = exceptionContent;
	}
	public Date getExceptionTime() {
		return exceptionTime;
	}
	public void setExceptionTime(Date exceptionTime) {
		this.exceptionTime = exceptionTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserFlag() {
		return userFlag;
	}
	public void setUserFlag(Integer userFlag) {
		this.userFlag = userFlag;
	}
	

}
