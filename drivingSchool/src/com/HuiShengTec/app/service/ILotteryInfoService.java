package com.HuiShengTec.app.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.LotteryInfo;
import com.HuiShengTec.entity.StudentInfo;

public interface ILotteryInfoService {
	
	PageBean queryLotteryInfoPage(PageBean pageBean);
	
	Map<String, Object> queryLotteryInfoId(Integer id);
	
	Integer editLotterySubmit(LotteryInfo info);
	
	HashMap<String, Object> queryStuLotteryInfo(StudentInfo stuInfo);
	
	List<LotteryInfo>queryLotteryInfo();
	
	Integer addLotteryInfoSubmit(LotteryInfo info,Integer role);
	
	Integer editLotteryStatus(LotteryInfo info);

}
