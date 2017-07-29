package com.HuiShengTec.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SalaryLog implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer coachId;
	private Integer adminId;
	private String name;
	private String code;
	private Integer type;
	private Float cash;
	private Float realCash;
	private Integer accountLogId;
	private Integer status;
	private Integer payWay;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date salaryBeginTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date salaryEndTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date payTime;
	private Integer operatorId;
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCoachId() {
		return coachId;
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Float getCash() {
		return cash;
	}

	public void setCash(Float cash) {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPayWay() {
		return payWay;
	}

	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}

	public Date getSalaryBeginTime() {
		return salaryBeginTime;
	}

	public void setSalaryBeginTime(Date salaryBeginTime) {
		this.salaryBeginTime = salaryBeginTime;
	}

	public Date getSalaryEndTime() {
		return salaryEndTime;
	}

	public void setSalaryEndTime(Date salaryEndTime) {
		this.salaryEndTime = salaryEndTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
