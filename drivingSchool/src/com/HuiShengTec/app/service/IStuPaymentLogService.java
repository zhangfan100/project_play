package com.HuiShengTec.app.service;

import java.util.Map;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.StudentPaymentLog;

public interface IStuPaymentLogService {

	//分页查询
    public PageBean queryStuPaymentInfo(PageBean bean);

	public Map<String, Object> confirmAddStuPayment(
			StudentPaymentLog studentPaymentLog, Integer payType);
}
