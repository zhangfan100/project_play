package com.HuiShengTec.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SalaryInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer coachId;
	private Integer adminId;
	private Integer salaryType;
	private float cash;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date inuseTime;
	private Integer status;

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

	public Integer getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(Integer salaryType) {
		this.salaryType = salaryType;
	}

	public float getCash() {
		return cash;
	}

	public void setCash(float cash) {
		this.cash = cash;
	}

	public Date getInuseTime() {
		return inuseTime;
	}

	public void setInuseTime(Date inuseTime) {
		this.inuseTime = inuseTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
