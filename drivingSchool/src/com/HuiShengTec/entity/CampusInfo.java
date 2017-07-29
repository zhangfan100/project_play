package com.HuiShengTec.entity;

import java.io.Serializable;

/**
 * 驾校分校
 * @author llj
 *
 */
public class CampusInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String phone;
	private String campusCode;
	private String address;
	private String GPSAddress;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getCampusCode() {
		return campusCode;
	}
	public void setCampusCode(String campusCode) {
		this.campusCode = campusCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGPSAddress() {
		return GPSAddress;
	}
	public void setGPSAddress(String gPSAddress) {
		GPSAddress = gPSAddress;
	}
	
}
