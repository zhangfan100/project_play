package com.HuiShengTec.app.service;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.OperationLog;

/**
 * 操作日志
 * @author mihuajun
 *
 */
public interface IOperationLogService {
	
	/**
	 * 分页显示操作日志记录
	 * @param pageBean
	 * @return
	 */
	PageBean queryOperationLogPage(PageBean pageBean);
	
	/**
	 * 根据ID删除操作日志记录
	 * @param ids
	 * @return
	 */
	Integer delOperationLog(String[] ids);
	
	/**
	 * 保存操作日志
	 * @param log
	 */
	void saveOperationLog(OperationLog log);

}
