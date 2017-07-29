package com.HuiShengTec.app.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IAccountLogDao;
import com.HuiShengTec.app.dao.ICoachPaymentLogDao;
import com.HuiShengTec.app.service.ICoachPaymentLogService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.AccountLog;
import com.HuiShengTec.entity.CoachPaymentLog;
import com.HuiShengTec.utils.Toolkit;

@Service
@Transactional
public class CoachPaymentLogServiceImpl implements ICoachPaymentLogService {

	@Autowired
	private ICoachPaymentLogDao iCoachPaymentLogDao;
	@Autowired
	private IAccountLogDao iAccountLogDao;
	
	@Override
	public PageBean querycoachPaymentInfo(PageBean bean) {
		bean.setRows(iCoachPaymentLogDao.querycoachPaymentInfo(bean));
		return bean;
	}

	@Override
	public Map<String, Object> confirmAddCoachPayment(
			CoachPaymentLog coachPaymentLog, Integer payType) {
		//准备收入支出账务表的数据
		AccountLog accountlog = new AccountLog();
		accountlog.setAccountType(1);
		accountlog.setCash(coachPaymentLog.getRealCash());
		accountlog.setPayType(payType);
		accountlog.setStatus(1);
		accountlog.setUserId(coachPaymentLog.getUserId());
		//插入数据到收入支出账务表
		iAccountLogDao.insertAccountLog(accountlog);
		//准备教练上缴费用表的数据
		coachPaymentLog.setAccountLogId(accountlog.getId());
		//插入数据到教练上缴费用表
		iCoachPaymentLogDao.insertCoachPaymentLog(coachPaymentLog);
		return Toolkit.getMapStatus(1);
	}

}
