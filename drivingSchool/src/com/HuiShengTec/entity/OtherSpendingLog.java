package com.HuiShengTec.entity;

import java.io.Serializable;
import java.util.Date;

public class OtherSpendingLog implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer accountLogId;
	private String spendingPerson;
	private String content;
	private Date time;
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountLogId() {
		return accountLogId;
	}

	public void setAccountLogId(Integer accountLogId) {
		this.accountLogId = accountLogId;
	}

	public String getSpendingPerson() {
		return spendingPerson;
	}

	public void setSpendingPerson(String spendingPerson) {
		this.spendingPerson = spendingPerson;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
