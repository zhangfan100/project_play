package com.HuiShengTec.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IExceptionLogDao;
import com.HuiShengTec.app.service.IExceptionLogService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.ExceptionLog;

/**
 * @author mihuajun
 * 异常处理实现
 */

@Service
@Transactional
public class ExceptionLogServiceImpl implements IExceptionLogService {
	
	@Autowired
	private IExceptionLogDao handlerDao;
	
	/**
	 * 保存异常信息
	 */
	@Override
	public void saveException(ExceptionLog exceptionLog){
		handlerDao.saveException(exceptionLog);
	}
	
	/**
	 * 分页展示异常信息
	 */
	@Override
	public PageBean queryExceptionLogPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setRows(handlerDao.queryExceptionLogPage(pageBean));
		return pageBean;
	}
	
	
	/**
	 * 删除系统异常数据/根据异常ID 
	 */
	public Integer delExceptionLog(String[] ids){
		Integer len = handlerDao.delExceptionLog(ids);
		return len>0?0:1;
	}
	
	/**
	 * 根据ID，查询异常信息
	 */
	@Override
	public ExceptionLog queryExceptionLogById(Integer id) {
		// TODO Auto-generated method stub
		return handlerDao.queryExceptionLogById(id);
	}
}
