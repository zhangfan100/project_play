package com.HuiShengTec.entity;

import java.io.Serializable;

/**
 * @author llj
 *
 */
public class DrivingLicence implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private Float pricePlus;
	private Boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Float getPricePlus() {
		return pricePlus;
	}
	public void setPricePlus(Float pricePlus) {
		this.pricePlus = pricePlus;
	}
	

}
