package com.HuiShengTec.base.entity;

import java.util.HashMap;

import com.HuiShengTec.utils.Toolkit;

public class PageInfo {
	private Integer page;
	private Integer rows;
	private HashMap<String, Object> conditions;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public HashMap<String, Object> getConditions() {
		return conditions;
	}
	public void setConditions(HashMap<String, Object> conditions) {
		this.conditions = conditions;
	}
	
	public void addConditions(String key,Object value){
		if(Toolkit.isEmpty(this.conditions)){
			this.conditions=new HashMap<String,Object>();
		}
		if(!Toolkit.isEmpty(value)){
			this.conditions.put(key, value);
		}
		
	}
	
}
