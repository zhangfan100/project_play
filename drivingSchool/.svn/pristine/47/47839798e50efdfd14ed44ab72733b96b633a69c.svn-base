package com.HuiShengTec.app.dao;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.OperationLog;

/**
 * 操作日志
 * @author mihuajun
 *
 */
public interface IOperationLogDao extends IBaseDao{
	
	/**
	 * 分页显示操作日志信息
	 * @param pageBean
	 * @return
	 */
	List<Map<String,Object>> queryOperationLogPage(PageBean pageBean);
	
	/**
	 * 根据ID删除操作日志记录
	 * @param ids
	 * @return
	 */
	Integer delExceptionLog(String[] ids);
	
	/**
	 * 保存操作日志
	 * @param log
	 * @return
	 */
	void saveOperationLog(OperationLog log);
}
