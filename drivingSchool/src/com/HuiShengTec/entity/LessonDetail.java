package com.HuiShengTec.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author llj
 *
 */
public class LessonDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer lessonId;
	private Integer detailCount;
	private Integer campusId;
	private Integer detailType;
	private Integer score;
	private Date beginTime;
	private Date endTime;
	private Integer drivingLength;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLessonId() {
		return lessonId;
	}
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}
	public Integer getDetailCount() {
		return detailCount;
	}
	public void setDetailCount(Integer detailCount) {
		this.detailCount = detailCount;
	}
	public Integer getCampusId() {
		return campusId;
	}
	public void setCampusId(Integer campusId) {
		this.campusId = campusId;
	}
	public Integer getDetailType() {
		return detailType;
	}
	public void setDetailType(Integer detailType) {
		this.detailType = detailType;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
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
	public Integer getDrivingLength() {
		return drivingLength;
	}
	public void setDrivingLength(Integer drivingLength) {
		this.drivingLength = drivingLength;
	}
	
	
}
