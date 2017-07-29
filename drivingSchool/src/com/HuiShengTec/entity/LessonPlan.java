package com.HuiShengTec.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author llj
 *
 */
public class LessonPlan implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer coachId;
	private Date date;
	private Integer time;
	private Integer subject;
	private Integer status;
	private Integer studentPlanId;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Integer getSubject() {
		return subject;
	}
	public void setSubject(Integer subject) {
		this.subject = subject;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getStudentPlanId() {
		return studentPlanId;
	}
	public void setStudentPlanId(Integer studentPlanId) {
		this.studentPlanId = studentPlanId;
	}

}
