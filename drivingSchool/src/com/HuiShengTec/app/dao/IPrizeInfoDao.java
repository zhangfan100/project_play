package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.PrizeInfo;

public interface IPrizeInfoDao extends IBaseDao{

	List<HashMap<String, Object>> queryPrizeInfo(PageBean pageBean);
	
	Map<String, Object> queryPrizeInfoId(Integer id);
	
	List<PrizeInfo> queryPrizeListByLotteryId(Integer lotteryId);
	
	public void prizeCountMinus(Integer id);
	
	Integer editPrizeInfoSubmit(PrizeInfo info);
	
	List<HashMap<String, Object>> queryPrizeInfoList(Integer stuId);
	
	Integer addPrizeInfoSubmit(PrizeInfo info);
	
}
