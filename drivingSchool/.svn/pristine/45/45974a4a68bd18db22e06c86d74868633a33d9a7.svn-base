package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.entity.CampusInfo;
import com.HuiShengTec.entity.Picture;

/**
 * 分校地图
 * @author llj
 *
 */
public interface ICampusInfoDao extends IBaseDao{
	
	/**
	 * 分校地图
	 * @param d
	 * @return
	 */
	public List<Map<String, Object>> queryCampusInfo();
	
	/**
	 * 分校名称
	 * @param id
	 * @return
	 */
	public Map<String, Object> querySchoolName(Integer id);
	/**
	 * 分校img
	 * @param param
	 * @return
	 */
	public Picture separateSchoolImg();
	
	public List<CampusInfo> querySeparateSchoolInfo();
	
	public List<HashMap<String,Object>> querySchoolTeacher(int schoolId);
	
	public void editCampusInfoSubmit(CampusInfo data);

	public void delCampusInfo(Integer id);
	
	public Integer addCampusInfo(CampusInfo data);
	
	public CampusInfo queryCampusInfoId(Integer id);
}
