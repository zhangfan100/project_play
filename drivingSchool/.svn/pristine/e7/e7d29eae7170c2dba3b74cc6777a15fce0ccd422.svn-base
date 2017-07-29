package com.HuiShengTec.app.dao;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.BasicProperty;

public interface IBasicPropertiesDao extends IBaseDao {
	
//	/**
//	 * 根据多个key查询参数
//	 * @param keys
//	 * @return
//	 */
//	public BasicProperties queryProperties(String[] keys);
	
	/**
	 * 查询所有数据 分页
	 * @param page
	 * @return
	 * 
	 * */
	public List<BasicProperty> queryBasicProp(PageBean page);
	
	/**
	 * 添加基础信息
	 * @param basicPropInfo
	 * @return
	 * */
	public void addBasicProperties(BasicProperty basicPropInfo);
	
	/**
	 * 删除基础信息
	 * @param Id
	 * @return
	 * */
	public Integer delAllBasicPropInfo(Integer Id);
	
	/**
	 * 修改基础信息
	 * @param info
	 * @return
	 * */
	public void updateBasicPropInfo(BasicProperty info);
	
	/**
	 * 根据Id获取基础信息
	 * @param info
	 * @return
	 * */
	public BasicProperty getBasicPropInfo(Integer info);
	
	public List<BasicProperty> queryAllCache();
	/**
	 * 批量删除数据
	 * @param ids 要删除数据的ID
	 */
	public void deleteSelected(Map<String,List<Integer>> ids);
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
	 * 根据唯一key查询数据
	 * @param key
	 * @return
	 */
	public BasicProperty queryBasicPropertiesByKey(String key);
	
	/**
	 * 根据key获取基础信息 
	 * @param key
	 * @return
	 */
	public BasicProperty getBasicPropInfoKey(String key);
	
}
