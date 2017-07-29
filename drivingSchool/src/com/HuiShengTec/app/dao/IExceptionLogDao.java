package com.HuiShengTec.app.dao;

import java.util.List;


import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.ExceptionLog;

/**
 * @author mihuajun
 *
 */
public interface IExceptionLogDao extends IBaseDao{
	
	/**
	 * 保存异常信息
	 * @param exceptionLog
	 */
	public void saveException(ExceptionLog exceptionLog);
	
	/**
	 * 分页显示系统异常信息
	 * @param pageBean
	 * @return
	 */
	public List<ExceptionLog> queryExceptionLogPage(PageBean pageBean);
	
	/**
	 * 删除系统异常数据/根据异常ID 
	 */
	public Integer delExceptionLog(String[] ids);
	
	/**
	 * 根据ID，查询异常信息
	 * @param id
	 * @return
	 */
	public ExceptionLog queryExceptionLogById(Integer id);
}
