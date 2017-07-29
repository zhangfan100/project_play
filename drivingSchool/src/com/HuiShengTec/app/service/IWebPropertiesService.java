package com.HuiShengTec.app.service;

import java.util.List;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.BasicProperty;

public interface IWebPropertiesService {
	/**
	 * 查询网站信息 分页
	 * 
	 * @param page
	 * @return
	 */
	public PageBean queryWebProperties(PageBean page);
	

	/**
	 * 修改网站信息
	 * 
	 * @param info
	 * @return
	 */
	public Integer updateWebPropInfo(BasicProperty info);

	/**
	 * 根据指定的KEY查询web属性
	 * @param keys
	 * @return
	 */
	public List<BasicProperty> queryWebPropertiesByKeys(String[] keys);
	
}
