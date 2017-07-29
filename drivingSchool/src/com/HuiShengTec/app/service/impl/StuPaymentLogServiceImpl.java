package com.HuiShengTec.app.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IAccountLogDao;
import com.HuiShengTec.app.dao.IStuPaymentLogDao;
import com.HuiShengTec.app.service.IStuPaymentLogService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.AccountLog;
import com.HuiShengTec.entity.StudentPaymentLog;
import com.HuiShengTec.utils.Toolkit;

@Service
@Transactional
public class StuPaymentLogServiceImpl implements IStuPaymentLogService {

	@Autowired
	private IStuPaymentLogDao iStuaymentLogDao;
	@Autowired
	private IAccountLogDao iAccountLogDao;
	
	@Override
	public PageBean queryStuPaymentInfo(PageBean bean) {
		bean.setRows(iStuaymentLogDao.queryStuPaymentInfo(bean));
		return bean;
	}

	@Override
	public Map<String, Object> confirmAddStuPayment(
			StudentPaymentLog studentPaymentLog, Integer payType) {
		//准备收入支出账务表的数据
		AccountLog accountlog = new AccountLog();
		accountlog.setCash(studentPaymentLog.getRealCash());
		accountlog.setAccountType(1);
		accountlog.setPayType(payType);
		accountlog.setStatus(1);
		accountlog.setUserId(studentPaymentLog.getOpeartionUserId());
		//插入数据到收入支出账务表
		iAccountLogDao.insertAccountLog(accountlog);
		//准备学生缴费表的数据
		studentPaymentLog.setAccountLogId(accountlog.getId());
		//插入数据到学生缴费表
		iStuaymentLogDao.insertCoachPaymentLog(studentPaymentLog);
		return Toolkit.getMapStatus(1);
	}

}
