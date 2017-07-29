package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.entity.DatePrice;
import com.HuiShengTec.entity.TimePrice;
import com.HuiShengTec.entity.WeekPrice;

public interface IPriceDao extends IBaseDao {
	public List<TimePrice> queryTimePrice();
	
	public List<WeekPrice> queryWeekPrice();
	
	public Integer queryDatePriceCount();
	
	public void addDatePrice(DatePrice price);
	
	public void delPastDatePrice();
	
	public List<HashMap<String, Object>> queryPriceByConditions(HashMap<String, Object> condition);

	public Integer updateSevenDaySubmit(Map<String, Object> param);
	
	public DatePrice queryDatePriceByCondition(DatePrice price);
}