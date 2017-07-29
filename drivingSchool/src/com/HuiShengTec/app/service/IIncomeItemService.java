package com.HuiShengTec.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.entity.IncomeItem;
import com.HuiShengTec.base.entity.PageBean;

public interface IIncomeItemService {

	/**
	 * 查询所有
	 * @return
	 */
	public PageBean queryAllIncomeItem(PageBean pageBean);
	
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
	 * 根据传来的id字符串集合删除对应的数据 2,6,66
	 * @return
	 */
	public void delIncomeItems(String idStr);
	
	/**
	 * 更新
	 * @return
	 */
	public void updateIncomeItem(IncomeItem incomeItem);

	/**
	 * 根据关键字搜索项目
	 * @param q
	 * @return
	 */
	public List<HashMap<String, Object>> queryItemByKeyWord(String q);

}
