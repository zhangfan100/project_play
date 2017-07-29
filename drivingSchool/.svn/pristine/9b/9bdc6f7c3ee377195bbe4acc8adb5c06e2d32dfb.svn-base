package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;
import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.entity.DatePrice;

public interface IDatePriceDao extends IBaseDao {
	public void addDatePrice(DatePrice data);
	public void deleteOldDatePrice();
	public DatePrice queryPlanDateTimePrice(HashMap<String, Object> condition);
	/**
	 * 查询出从今天以后的所有数据
	 * @return
	 */
	public List<DatePrice> queryCurrentDataPrice();
}
