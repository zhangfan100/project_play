package com.HuiShengTec.app.service;

import java.util.HashMap;
import java.util.List;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.StudentInfo;
import com.HuiShengTec.entity.TestInfo;

public interface ITestInfoService {
	public PageBean queryTestInfoPage(PageInfo info);
	public Integer addTestInfo(TestInfo info);
	public Integer addTestInfo(TestInfo info, StudentInfo stuInfo);
	public void cancelTestInfo(String ids);
	
	public List<HashMap<String, Object>> queryStuTestInfoList(Integer stuId);
	
	public HashMap<String, Object> queryTestDetail(Integer testInfoId);
	
	/**
	 * 取消预约模考
	 * @author mihuajun
	 * @createTime 2014-11-19 上午11:19:44
	 * @param id
	 * @return
	 */
	Integer deletePExam(Integer id);
}
