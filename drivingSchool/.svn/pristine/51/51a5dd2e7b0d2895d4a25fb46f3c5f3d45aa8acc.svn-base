package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.SalaryInfo;

public interface ISalaryInfoDao extends IBaseDao{
	/**
	 * 分页查询人员信息
	 * @param bean
	 * @return
	 */
	public List<HashMap<String, Object>> querySalaryInfoPage(PageBean bean);

	// 改变其状态 
	public void changeStatus(Map<String, Object> condition);


	//插入新的记录
	public void insertSalaryInfo(SalaryInfo info);
}
