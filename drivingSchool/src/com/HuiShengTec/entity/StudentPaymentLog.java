package com.HuiShengTec.entity;

import java.io.Serializable;
import java.util.Date;

public class StudentPaymentLog implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer stuId;
	private String stuName;
	private Integer paymentType;
	private String paymentItem;
	private float cash;
	private float realCash;
	private Integer accountLogId;
	private Date payTime;
	private Integer opeartionUserId;
	private String userName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentItem() {
		return paymentItem;
	}

	public void setPaymentItem(String paymentItem) {
		this.paymentItem = paymentItem;
	}

	public float getCash() {
		return cash;
	}

	public void setCash(float cash) {
		this.cash = cash;
	}

	public float getRealCash() {
		return realCash;
	}

	public void setRealCash(float realCash) {
		this.realCash = realCash;
	}

	public Integer getAccountLogId() {
		return accountLogId;
	}

	public void setAccountLogId(Integer accountLogId) {
		this.accountLogId = accountLogId;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Integer getOpeartionUserId() {
		return opeartionUserId;
	}

	public void setOpeartionUserId(Integer opeartionUserId) {
		this.opeartionUserId = opeartionUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
