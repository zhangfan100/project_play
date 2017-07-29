package com.HuiShengTec.app.dao;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;

/**
 * 首页应用
 * @author mihuajun
 *
 */
public interface IFroIndexDao extends IBaseDao {
	
	/**
	 * 查询所有动态菜单
	 * @return
	 */
	List<Map<String, Object>> queryMenu();

}
