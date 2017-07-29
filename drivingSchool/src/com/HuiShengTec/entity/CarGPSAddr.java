package com.HuiShengTec.entity;

import java.io.Serializable;
import java.util.Date;

public class CarGPSAddr implements Serializable {

	private String gpsAddr;
	private Integer carId;
	private Date lastUpdateTime;
	public String getGpsAddr() {
		return gpsAddr;
	}
	public void setGpsAddr(String gpsAddr) {
		this.gpsAddr = gpsAddr;
	}
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	
}
