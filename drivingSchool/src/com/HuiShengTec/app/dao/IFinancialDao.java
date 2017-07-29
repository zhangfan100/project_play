package com.HuiShengTec.app.dao;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.SalaryInfo;

public interface IFinancialDao extends IBaseDao {

	/**
	 * 分页的到
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> getPaymentAccountLog(PageBean pageBean);

	/**
	 * 初始化员工薪资
	 * @param salaryInfo
	 * @return
	 */
	public void insertSalaryInfo(SalaryInfo salaryInfo);

	/**
	 * 查询将要发放工资的人员情况 带分页
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> queryPaymentAccountByCondition(PageBean pageBean);

	/**
	 * 查询到发放工资的具体信息
	 * * @author [zf]
	 */
	public List<Map<String, Object>> fillFinancialDetail(PageBean pageBean);

}
