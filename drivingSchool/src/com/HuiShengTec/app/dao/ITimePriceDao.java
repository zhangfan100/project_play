package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.entity.TimePrice;

public interface ITimePriceDao extends IBaseDao {
	/**
	 * 查询当前启用的时间
	 * @return
	 */
	public List<TimePrice> queryCurrTimePriceList();
	public List<TimePrice> queryAllTimePriceList();
	
	/**
	 * 启用、禁用时间段
	 * @author mihuajun
	 * @createTime 2014-11-6 上午1:32:13
	 * @param param
	 * @return
	 */
	public Integer editTimePriceStatus(Map<String, Object> param);
	
	/**
	 * 编辑时间段价格
	 * @author mihuajun
	 * @createTime 2014-11-6 上午1:48:17
	 * @param timePriceInfo
	 * @return
	 */
	public Integer editTimePriceSubmit(TimePrice timePriceInfo);
	
	/**
	 * 查询价格表
	 * @author mihuajun
	 * @createTime 2014-11-6 上午3:00:26
	 * @param condition
	 * @return
	 */
	public List<HashMap<String, Object>> queryPriceByConditions(
			HashMap<String, Object> condition);
	
	/**
	 * 更新七天价格
	 * @author mihuajun
	 * @createTime 2014-11-6 上午11:39:10
	 * @param param
	 * @return
	 */
	public Integer updateSevenDaySubmit(Map<String, Object> param);
}
