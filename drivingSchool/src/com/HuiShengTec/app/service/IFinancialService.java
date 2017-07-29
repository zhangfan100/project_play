package com.HuiShengTec.app.service;


import java.util.Map;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.SalaryInfo;
import com.HuiShengTec.entity.SalaryLog;

public interface IFinancialService {

	/**
	 * 分页得到发放工资日志
	 * @param fillPageInfo
	 * @return
	 */
	public PageBean getPaymentAccountLog(PageBean pageBean);
	
	
	/**
	 * 初始化员工薪资表
	 * @param salaryInfo
	 * @return
	 */
	public void insertSalaryInfo(SalaryInfo salaryInfo);


	/**
	 * 查询需要结薪人员的情况 带分页
	 * @param pageBean
	 * @return
	 */
	public PageBean queryPaymentAccountByCondition(PageBean pageBean);

	
    /**
     * 保存发放工资到数据库
     * @param salaryLog
     * @return
     */
	public Map<String, Object> paySalarySubmit(SalaryLog salaryLog);


	/**
	 * 查询到发放工资的具体信息
	 * * @author [zf]
	 */
	public PageBean fillFinancialDetail(PageBean bean);

}
