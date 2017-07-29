package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.IncomeItem;

/**
 * 
 * @author zf
 * @Description: TODO(用一句话描述该文件做什么) 
 * @Date   2015年4月19日 下午2:57:13
 */

public interface IIncomeItemDao extends IBaseDao {
   
	/**
	 * 查询所有
	 * @return
	 */
	public List<Map<String, Object>> queryAllIncomeItem(PageBean pageBean);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryIncomeItemById(Integer id);
	
	/**
	 * 添加收入项目
	 */
	public void addIncomeItem(IncomeItem incomeItem);
	
	/**
	 * 根据传来的id集合删除对应的数据 2,6,66
	 * @return
	 */
	public void delIncomeItems(List<Integer> list);
	
	/**
	 * 更新
	 * @return
	 */
	public void updateIncomeItem(IncomeItem incomeItem);

	/**
	 * 根据关键字查找项目
	 * @param condition
	 * @return
	 */
	public List<HashMap<String, Object>> queryItemByKeyWord(
			HashMap<String, Object> condition);

}
