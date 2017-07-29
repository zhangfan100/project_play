package com.HuiShengTec.entity;

import java.io.Serializable;

public class StationInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String jxlogo;
	private String jx_chineseName;
	private String jx_englishName;
	private String record_nums;
	private String record_cards;
	private String site_domain_name;
	public String getJxlogo() {
		return jxlogo;
	}
	public void setJxlogo(String jxlogo) {
		this.jxlogo = jxlogo;
	}
	public String getJx_chineseName() {
		return jx_chineseName;
	}
	public void setJx_chineseName(String jx_chineseName) {
		this.jx_chineseName = jx_chineseName;
	}
	public String getJx_englishName() {
		return jx_englishName;
	}
	public void setJx_englishName(String jx_englishName) {
		this.jx_englishName = jx_englishName;
	}
	public String getRecord_nums() {
		return record_nums;
	}
	public void setRecord_nums(String record_nums) {
		this.record_nums = record_nums;
	}
	public String getRecord_cards() {
		return record_cards;
	}
	public void setRecord_cards(String record_cards) {
		this.record_cards = record_cards;
	}
	public String getSite_domain_name() {
		return site_domain_name;
	}
	public void setSite_domain_name(String site_domain_name) {
		this.site_domain_name = site_domain_name;
	}
	
	
}
