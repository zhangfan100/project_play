package com.HuiShengTec.app.service.impl;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IBasicPropertiesDao;
import com.HuiShengTec.app.service.IBasicPropertiesService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.BasicProperty;

/**
 * 查询基础信息
 * @author 刘霖晋
 * 
 */
@Service
@Transactional
public class BasicPropertiesServiceImpl implements IBasicPropertiesService{
	
	@Autowired
	private IBasicPropertiesDao iBasicPropertiesDao;
	
	/**
	 * 查询所有基础信息分页
	 * 
	 * @param info
	 */
	@Override
	public PageBean queryBasicProperties(PageBean page) {
		List<BasicProperty> listInfo=iBasicPropertiesDao.queryBasicProp(page);
		page.setRows(listInfo);
		return page;
	}


	/**
	 * 修改基础信息 
	 * @param info
	 * @return
	 */
	@Override
	public void updateBasicPropInfo(BasicProperty info) {
		iBasicPropertiesDao.updateBasicPropInfo(info);
		
	}


	
	/**
	 * 根据ID获取基础信息 
	 * @param info
	 * @return
	 */
	@Override
	public BasicProperty getBasicPropInfoId(Integer id) {
		return iBasicPropertiesDao.getBasicPropInfo(id);
	}
	
	/**
	 * 根据key获取基础信息 
	 * @param info
	 * @return
	 */
	@Override
	public BasicProperty getBasicPropInfoKey(String key) {
		return iBasicPropertiesDao.getBasicPropInfoKey(key);
	}
	
	/**
	 * 初始化缓存时用，
	 * @return
	 */
	public ConcurrentHashMap<String,BasicProperty> queryAllCache(){
		//把所有得基本信息查出来缓存起 key为关键字 整个对象为value
		List<BasicProperty> list = iBasicPropertiesDao.queryAllCache();
		ConcurrentHashMap<String,BasicProperty> result = new  ConcurrentHashMap<String,BasicProperty>();
		for (BasicProperty property : list) {
			result.put(property.getKey(), property);
		}
		return result;
	}


	@Override
	public List<BasicProperty> queryContactInfo() {
		return iBasicPropertiesDao.queryContactInfo();
	}

	@Override
	public List<BasicProperty> queryCopyRightInfo() {
		return iBasicPropertiesDao.queryCopyRightInfo();
	}
	}
	
