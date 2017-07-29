package com.HuiShengTec.app.dao;

import java.util.List;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.BasicProperty;

public interface IWebPropertiesDao extends IBaseDao{

	/**
	 * 查询所有网站信息数据 分页
	 * @param page
	 * @return
	 * 
	 * */
	public List<BasicProperty> queryWebProp(PageBean page);
	
	/**
	 * key值唯一性判断
	 * @param id
	 * @return
	 */
	public Integer validateKey(BasicProperty basicPropInfo);
	/**
	 * 修改网站信息
	 * @param info
	 * @return
	 * */
	public Integer updateWebPropInfo(BasicProperty info);
	
	/**
	 * 根据指定的KEY查询web属性
	 * @param keys
	 * @return
	 */
	public List<BasicProperty> queryWebPropertiesByKeys(String[] keys);

	
}
