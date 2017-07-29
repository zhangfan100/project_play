package com.HuiShengTec.app.service;


import java.util.HashMap;
import java.util.List;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.StudentInfo;
import com.HuiShengTec.entity.StudentLotteryInfo;

public interface IStudentLotteryInfoService {

	PageBean querystudentLotteryInfoPage(PageBean pageBean);
	
	public HashMap<String, Object> doLottery(StudentInfo stuInfo,Integer lotteryInfoId);
	
	List<HashMap<String, Object>> queryPrizeInfoList(StudentInfo stuInfo);
	
	Integer editStudentLotteryStatus(StudentLotteryInfo info);
	
}
