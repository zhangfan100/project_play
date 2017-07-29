package com.HuiShengTec.app.service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.BasicProperty;

/**
 * 操作基础信息
 * 
 * @author 刘霖晋
 * 
 */
public interface IBasicPropertiesService {

	/**
	 * 查询基础信息 分页
	 * 
	 * @param page
	 * @return
	 */
	public PageBean queryBasicProperties(PageBean page);

	
	/**
	 * 修改基础信息
	 * 
	 * @param info
	 * @return
	 */
	public void updateBasicPropInfo(BasicProperty info);

	
	
	public BasicProperty getBasicPropInfoId(Integer Info);
	
	public ConcurrentHashMap<String,BasicProperty> queryAllCache();

	
	/**
	 * 查询联系我们
	 * @return
	 */
	public List<BasicProperty> queryContactInfo();
	/**
	 * 查询版权信息
	 * @return
	 */
	public List<BasicProperty> queryCopyRightInfo();
	
	/**
	 * 根据key查询
	 * @param key
	 * @return
	 */
	BasicProperty getBasicPropInfoKey(String key);
	
}
