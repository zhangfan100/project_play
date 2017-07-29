package com.HuiShengTec.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author llj
 *
 */
public class CarInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String carCode;
	private Integer carBrandId;
	private Integer licenceType;
	private String licenceCode;
	private String allowLicenceType;
	private Integer carType;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updateTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date lifeEndDate;
	private String licenceOrgan;
	private Integer status;
	private String carIP;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getCarBrandId() {
		return carBrandId;
	}
	public void setCarBrandId(Integer carBrandId) {
		this.carBrandId = carBrandId;
	}
	public String getCarCode() {
		return carCode;
	}
	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}
	public Integer getLicenceType() {
		return licenceType;
	}
	public void setLicenceType(Integer licenceType) {
		this.licenceType = licenceType;
	}
	public String getLicenceCode() {
		return licenceCode;
	}
	public void setLicenceCode(String licenceCode) {
		this.licenceCode = licenceCode;
	}
	public String getAllowLicenceType() {
		return allowLicenceType;
	}
	public void setAllowLicenceType(String allowLicenceType) {
		this.allowLicenceType = allowLicenceType;
	}
	public Integer getCarType() {
		return carType;
	}
	public void setCarType(Integer carType) {
		this.carType = carType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getLifeEndDate() {
		return lifeEndDate;
	}
	public void setLifeEndDate(Date lifeEndDate) {
		this.lifeEndDate = lifeEndDate;
	}
	public String getLicenceOrgan() {
		return licenceOrgan;
	}
	public void setLicenceOrgan(String licenceOrgan) {
		this.licenceOrgan = licenceOrgan;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCarIP() {
		return carIP;
	}
	public void setCarIP(String carIP) {
		this.carIP = carIP;
	}
}
