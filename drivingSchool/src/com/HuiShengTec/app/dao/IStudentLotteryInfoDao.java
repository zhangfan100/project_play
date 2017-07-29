package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.LotteryInfo;
import com.HuiShengTec.entity.StudentLotteryInfo;

public interface IStudentLotteryInfoDao extends IBaseDao{

	List<HashMap<String, Object>> querystudentLotteryInfoPage(PageBean pageBean);
	
	public void addStudentLotteryInfo(StudentLotteryInfo info);
	
	Integer editStudentLotteryStatus(StudentLotteryInfo info);
	
	public Integer queryStudentLotteryInfoCount(HashMap<String, Object> condition);
	
	
}
