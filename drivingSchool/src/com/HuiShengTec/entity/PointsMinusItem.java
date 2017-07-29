package com.HuiShengTec.entity;

import java.io.Serializable;

/**
 * @author llj
 *
 */
public class PointsMinusItem implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String pointCode;
	private String content;
	private Integer pointValue;
	private Integer pointSubject;
	private Integer pointType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPointCode() {
		return pointCode;
	}
	public void setPointCode(String pointCode) {
		this.pointCode = pointCode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getPointValue() {
		return pointValue;
	}
	public void setPointValue(Integer pointValue) {
		this.pointValue = pointValue;
	}
	public Integer getPointSubject() {
		return pointSubject;
	}
	public void setPointSubject(Integer pointSubject) {
		this.pointSubject = pointSubject;
	}
	public Integer getPointType() {
		return pointType;
	}
	public void setPointType(Integer pointType) {
		this.pointType = pointType;
	}
	

}
