package com.HuiShengTec.entity;

import java.io.Serializable;

/**
 * @author llj
 *
 */
public class CoachGroup implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer groupId;
	private Integer coachId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Integer getCoachId() {
		return coachId;
	}
	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}
	
}
