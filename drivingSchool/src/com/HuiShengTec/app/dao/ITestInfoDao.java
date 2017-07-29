package com.HuiShengTec.app.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.TestInfo;

/**
 * 预约模考
 * @author mihuajun
 *
 */
public interface ITestInfoDao extends IBaseDao {
	public List<HashMap<String, Object>>queryTestInfoPage(PageBean bean);
	public Integer queryStuTestCount(Integer stuId);
	public Integer queryAllDayTestCount(Date date);
	
	public void addTestInfo(TestInfo info);
	
	public void delTestInfo(List<Integer> ids);
	
	public List<HashMap<String, Object>>queryStuTestInfoList(Integer stuId);
	
	public HashMap<String, Object> queryTestDetail(Integer testInfoId);
	
	/**
	 * 根据ID，查询预约模考
	 * @author mihuajun
	 * @createTime 2014-11-19 上午11:31:49
	 * @param id
	 * @return
	 */
	public HashMap<String, Object> queryTestinfoById(Integer id);
}
