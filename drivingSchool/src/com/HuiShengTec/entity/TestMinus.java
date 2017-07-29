package com.HuiShengTec.entity;

import java.io.Serializable;

/**
 * @author llj
 *
 */
public class TestMinus implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer pointsMinusId;
	private Integer testDetailId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPointsMinusId() {
		return pointsMinusId;
	}
	public void setPointsMinusId(Integer pointsMinusId) {
		this.pointsMinusId = pointsMinusId;
	}
	public Integer getTestDetailId() {
		return testDetailId;
	}
	public void setTestDetailId(Integer testDetailId) {
		this.testDetailId = testDetailId;
	}
	

}
