package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.LotteryInfo;

public interface ILotteryInfoDao extends IBaseDao{
	/**
	 * 查询当前进行的抽奖活动
	 * 功能设计：同一时间段内 只能进行一个抽奖活动（暂时限制）
	 * @return
	 */
	public LotteryInfo queryCurrentLotteryInfo();

	public LotteryInfo queryLotteryInfoById(Integer id);
	
	List<HashMap<String, Object>> queryLotteryInfoPage(PageBean pageBean);
	
	Map<String, Object> queryLotteryInfoId(Integer id);
	
	public String queryStuLotteryCode();
	
	Integer queryLotteryinfo();
	
	List<LotteryInfo> queryLotteryInfo();
	
	Integer addLotteryInfoSubmit(LotteryInfo info);
	
	Integer editLotteryStatus(LotteryInfo info);
	
	Integer editLotteryAllStatus();
	
	Integer editLotterySubmit(LotteryInfo info);
	
	
}
