package com.HuiShengTec.entity;

import java.io.Serializable;

/**
 * @author zf
 *
 */
public class MapMark implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String lng;
	private String lat;
	private Integer sceneId;
	private String title;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getSceneId() {
		return sceneId;
	}
	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}

	
}
