package com.HuiShengTec.entity;

import java.io.Serializable;
import java.util.Date;

public class TrainReview implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer  coachId;
	private String  content;
	private Date    reviewTime;
	private Integer stuId;
	private Integer isHide;
	private Float   totalScore;
	private Float   qualityScore;
	private Float   ruleScore;
	private Float   serviceScore;
	private Integer replyCount;
	private Integer isDisplay;
	private Integer isNew;
	private Integer lessonInfoId;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public Integer getIsHide() {
		return isHide;
	}
	public void setIsHide(Integer isHide) {
		this.isHide = isHide;
	}
	public Float getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Float totalScore) {
		this.totalScore = totalScore;
	}
	public Float getQualityScore() {
		return qualityScore;
	}
	public void setQualityScore(Float qualityScore) {
		this.qualityScore = qualityScore;
	}
	public Float getRuleScore() {
		return ruleScore;
	}
	public void setRuleScore(Float ruleScore) {
		this.ruleScore = ruleScore;
	}
	public Float getServiceScore() {
		return serviceScore;
	}
	public void setServiceScore(Float serviceScore) {
		this.serviceScore = serviceScore;
	}
	public Integer getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
	public Integer getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
	}
	public Integer getIsNew() {
		return isNew;
	}
	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}
	public Integer getLessonInfoId() {
		return lessonInfoId;
	}
	public void setLessonInfoId(Integer lessonInfoId) {
		this.lessonInfoId = lessonInfoId;
	}
}
