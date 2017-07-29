package com.HuiShengTec.app.service.impl;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IAccountLogDao;
import com.HuiShengTec.app.dao.IFinancialDao;
import com.HuiShengTec.app.dao.ISalarLogDao;
import com.HuiShengTec.app.service.IFinancialService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.AccountLog;
import com.HuiShengTec.entity.SalaryInfo;
import com.HuiShengTec.entity.SalaryLog;
import com.HuiShengTec.utils.Toolkit;

@Service
@Transactional
public class FinancialServiceImpl implements IFinancialService {
	
	@Autowired
	private IFinancialDao iFinancialDao;
	@Autowired
	private IAccountLogDao iAccountLogDao;
	@Autowired
	private ISalarLogDao iSalarLogDao;

	/**
	 * 分页查询工作发放情况
	 */
	@Override
	public PageBean getPaymentAccountLog(PageBean pageBean) {
		pageBean.setRows(iFinancialDao.getPaymentAccountLog(pageBean));
		return pageBean;
	}

	/**
	 * 插入记录
	 */
	@Override
	public void insertSalaryInfo(SalaryInfo salaryInfo) {
		iFinancialDao.insertSalaryInfo(salaryInfo);
	}

	/**
	 * 查询需要结薪人员的情况 带分页
	 */
	@Override
	public PageBean queryPaymentAccountByCondition(PageBean pageBean) {
		pageBean.setRows(iFinancialDao.queryPaymentAccountByCondition(pageBean));
		return pageBean;
	}

	/**
	 * 保存数据到数据库里
	 */
	@Override
	public Map<String, Object> paySalarySubmit(SalaryLog salaryLog) {
		AccountLog accountLog = new AccountLog();
		accountLog.setCash(salaryLog.getCash());
		accountLog.setAccountType(2);
		accountLog.setPayType(salaryLog.getPayWay());
		accountLog.setUserId(salaryLog.getOperatorId());
		if(salaryLog.getStatus()==0){
			accountLog.setStatus(0);
		}else{
			accountLog.setStatus(1);
		}
		//插入数据收入支出账务表
		iAccountLogDao.insertAccountLog(accountLog);
		//插入数据到工资发放表
		salaryLog.setAccountLogId(accountLog.getId());
		iSalarLogDao.insertSalaryLog(salaryLog);
		return Toolkit.getMapStatus(1);
	}

	@Override
	public PageBean fillFinancialDetail(PageBean bean) {
		bean.setRows(iFinancialDao.fillFinancialDetail(bean));
		return bean;
	}

}
