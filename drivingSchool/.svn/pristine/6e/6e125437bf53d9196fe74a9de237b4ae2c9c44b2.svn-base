package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;

public interface ICoachGroupDao extends IBaseDao {
	public List<HashMap<String, Object>> queryCoachWeekGroup(Integer weekDay);
	
	/**
	 * 分页显示空闲的教练
	 * @author mihuajun
	 * @createTime 2014-11-12 下午4:52:08
	 * @param pageBean
	 * @return
	 */
	public List<Map<String,Object>> queryUnusedCoachPage(PageBean pageBean);
	
	/**
	 * 分页显示非空闲的教练
	 * @author mihuajun
	 * @createTime 2014-11-12 下午4:52:08
	 * @param pageBean
	 * @return
	 */
	public List<Map<String,Object>> queryUsedCoachPage(PageBean pageBean);
	
	/**
	 * 加入分组教练
	 * @author mihuajun
	 * @createTime 2014-11-13 上午10:29:12
	 * @param param
	 */
	public void insertCoachGroup(Map<String, Object> param);
	
	/**
	 * 移除教练分组
	 * @author mihuajun
	 * @createTime 2014-11-13 上午10:29:29
	 * @param split
	 * @return
	 */
	public int removeCoachGroup(String[] split);
	
	/**
	 * 根据日期及课目类别，查找所在ID
	 * @author mihuajun
	 * @createTime 2014-11-13 上午10:29:44
	 * @param weekDay
	 * @param subject
	 * @return
	 */
	public Integer queryWeekGroupId(Map<String,Object> param);
	
	
	public List<HashMap<String, Object>> queryCoachGroupInfo();
}
