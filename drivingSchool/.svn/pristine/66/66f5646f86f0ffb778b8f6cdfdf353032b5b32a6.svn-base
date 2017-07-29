package com.HuiShengTec.app.service;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.ExceptionLog;

/**
 * 系统异常处理接口
 * @author mihuajun
 *
 */
public interface IExceptionLogService {
	
	/**
	 * 保存系统拦截的异常信息
	 * @param exceptionLog
	 */
	void saveException(ExceptionLog exceptionLog);
	
	/**
	 * 分页展示异常信息
	 * @param pageBean
	 * @return
	 */
	PageBean queryExceptionLogPage(PageBean pageBean);
	
	/**
	 * 根据ID删除系统异常
	 * @param ids
	 * @return
	 */
	Integer delExceptionLog(String[] ids);
	
	/**
	 * 根据ID，查询异常信息
	 * @param id
	 * @return
	 */
	public ExceptionLog queryExceptionLogById(Integer id);

}
