package com.HuiShengTec.app.dao;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.CoachPaymentLog;

public interface ICoachPaymentLogDao extends IBaseDao {

	public List<Map<String, Object>> querycoachPaymentInfo(PageBean bean);

	public void insertCoachPaymentLog(CoachPaymentLog coachPaymentLog);
}
