package com.HuiShengTec.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IFroIndexService {
	
	/**
	 * 查询首页数据
	 * @return
	 */
	public HashMap<String,Object> queryFroIndexData();
	
	/**
	 *  查询所有动态菜单
	 * @return
	 */
	List<Map<String,Object>> queryMenu();
	
	/**
	 * 查询分校对应的教师
	 * @param coachId
	 * @return
	 */
	List<HashMap<String, Object>> queryCoachInfo(Integer campusId);
	
	/**
	 *  查询分校所在学生
	 * @param campusId
	 * @return
	 */
	List<HashMap<String, Object>> querySchoolTopStu(Integer campusId);
}
