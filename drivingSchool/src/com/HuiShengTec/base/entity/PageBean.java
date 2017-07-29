package com.HuiShengTec.base.entity;

import java.util.HashMap;
import java.util.List;

import com.HuiShengTec.utils.Toolkit;

/**
 * @author wtr
 * 列表分页
 */
public class PageBean {
	private int pageNumber;
	private int pageSize;
	@SuppressWarnings("rawtypes")
	private List rows;
	
	private int total;
	
	private HashMap<String,Object> conditions;
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@SuppressWarnings("rawtypes")
	public List getRows() {
		return rows;
	}
	@SuppressWarnings("rawtypes")
	public void setRows(List rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
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
