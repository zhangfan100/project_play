package com.HuiShengTec.entity;

import java.io.Serializable;

public class WeekPrice implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer weekDay;
	private Float pricePlus;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(Integer weekDay) {
		this.weekDay = weekDay;
	}
	public Float getPricePlus() {
		return pricePlus;
	}
	public void setPricePlus(Float pricePlus) {
		this.pricePlus = pricePlus;
	}
}
