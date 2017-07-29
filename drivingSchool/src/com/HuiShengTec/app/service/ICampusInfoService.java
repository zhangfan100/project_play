package com.HuiShengTec.app.service;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.entity.CampusInfo;
import com.HuiShengTec.entity.Picture;

/**
 * 
 * 分校地图搜索
 * @author llj
 *
 */
public interface ICampusInfoService {
	
	/**
	 * 分校地图搜索
	 * @param param
	 * @return
	 */
	public List<Map<String, Object>> queryCampusInfo();
	
	/**
	 * 分校名称搜索
	 * @param param
	 * @return
	 */
	public Map<String, Object> queryCampusName(Integer id);
	
	/**
	 * 分校img
	 * @return
	 */
	public Picture campusInfoImg();
	/**
	 * 修改
	 * @param data
	 */
	public void editCampusInfoSubmit(CampusInfo data);
	/**
	 * 删除
	 * @param ID
	 */
	public void delCampusInfo(Integer id);


	public Integer addCampusInfo(CampusInfo data);
	
	
	public CampusInfo queryCampusInfoId(Integer id);
}
