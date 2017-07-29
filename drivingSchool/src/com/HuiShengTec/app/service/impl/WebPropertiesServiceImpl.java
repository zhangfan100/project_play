package com.HuiShengTec.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IWebPropertiesDao;
import com.HuiShengTec.app.service.IWebPropertiesService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.BasicProperty;
@Service
@Transactional
public class WebPropertiesServiceImpl implements IWebPropertiesService{
	@Autowired
	private IWebPropertiesDao iWebPropertiesDao;
	@Override
	public PageBean queryWebProperties(PageBean page) {
		List<BasicProperty> webLists = iWebPropertiesDao.queryWebProp(page);
		page.setRows(webLists);
		return page;
	}

	@Override
	public Integer updateWebPropInfo(BasicProperty info) {
		/*Integer c = iWebPropertiesDao.validateKey(info);
		if(c!=0){
			return 0;
		}else{
			
		}*/
		return iWebPropertiesDao.updateWebPropInfo(info);
		
	}
	
	/**
	 * 根据指定的KEY查询web属性
	 */
	@Override
	public List<BasicProperty> queryWebPropertiesByKeys(String[] keys) {
		// TODO Auto-generated method stub
		return iWebPropertiesDao.queryWebPropertiesByKeys(keys);
	}

}
