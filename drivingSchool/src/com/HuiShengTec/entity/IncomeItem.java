package com.HuiShengTec.entity;

import java.io.Serializable;

public class IncomeItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String itemTag;
	private Integer itemType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemTag() {
		return itemTag;
	}

	public void setItemTag(String itemTag) {
		this.itemTag = itemTag;
	}

	public Integer getItemType() {
		return itemType;
	}

	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

}
