package com.HuiShengTec.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Accountstatistics implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer type;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;
	private float totalCash;
	private float everydayCash;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date statisticTime;
	private Integer statisticType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public float getTotalCash() {
		return totalCash;
	}
	public void setTotalCash(float totalCash) {
		this.totalCash = totalCash;
	}
	public float getEverydayCash() {
		return everydayCash;
	}
	public void setEverydayCash(float everydayCash) {
		this.everydayCash = everydayCash;
	}
	public Date getStatisticTime() {
		return statisticTime;
	}
	public void setStatisticTime(Date statisticTime) {
		this.statisticTime = statisticTime;
	}
	public Integer getStatisticType() {
		return statisticType;
	}
	public void setStatisticType(Integer statisticType) {
		this.statisticType = statisticType;
	}
	
	
}
