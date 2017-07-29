package com.HuiShengTec.entity;

import java.io.Serializable;

/**
 * @author llj
 *
 */
public class BasicProperty implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	
	private String key;
	
	private String title;
	
	private String value;
	
	private Integer type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
