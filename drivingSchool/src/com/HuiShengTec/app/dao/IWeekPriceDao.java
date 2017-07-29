package com.HuiShengTec.app.dao;

import java.util.List;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.entity.WeekPrice;

public interface IWeekPriceDao extends IBaseDao{
	public List<WeekPrice> queryWeekPrice();
	
	/**
	 * 更新星期差价
	 * @author mihuajun
	 * @createTime 2014-11-6 上午2:01:57
	 * @param weekPrice
	 * @return
	 */
	public Integer updateWeekPrice(WeekPrice weekPrice);

}
