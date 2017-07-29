package com.HuiShengTec.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IOperationLogDao;
import com.HuiShengTec.app.service.IOperationLogService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.OperationLog;

/**
 * 
 * 操作日志
 * @author mihuajun
 *
 */

@Service
@Transactional
public class OperationLogServiceImpl implements IOperationLogService {
	
	@Autowired
	private IOperationLogDao logDao;
	
	
	/**
	 * 保存操作日志
	 */
	@Override
	public void saveOperationLog(OperationLog log) {
		// TODO Auto-generated method stub
		logDao.saveOperationLog(log);
	}
	
	/**
	 * 分页显示操作日志信息
	 */
	@Override
	public PageBean queryOperationLogPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setRows(logDao.queryOperationLogPage(pageBean));
		return pageBean;
	}
	
	/**
	 * 根据ID删除操作日志记录
	 * @param id
	 * @return
	 */
	@Override
	public Integer delOperationLog(String[] ids) {
		Integer len = logDao.delExceptionLog(ids);
		return len>0?0:1;
	}
	
}
