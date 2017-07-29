package com.HuiShengTec.app.service;

import java.util.Map;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.PrizeInfo;

public interface IPrizeInfoService {
	
	PageBean queryPrizeInfo(PageBean pageBean);
	
	Map<String, Object> queryPrizeInfoId(Integer id);
	
	Integer editPrizeInfoSubmit(PrizeInfo info);
	
	Integer addPrizeInfoSubmit(PrizeInfo info);
	
	
}
