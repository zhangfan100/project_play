/**********************************************************************   
 * <p>文件名：PrizeInfoServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：drivingSchool
 * @author mihuajun  
 * @date 2014年12月25日 下午2:43:50 
 * @history
 * @department：慧莘软件部
 * Copyright ChengDu Huishen Technology Development CO.,LTD 2014
 * All Rights Reserved.
*/
package com.HuiShengTec.app.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IImageDao;
import com.HuiShengTec.app.dao.IPrizeInfoDao;
import com.HuiShengTec.app.service.IPrizeInfoService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.Picture;
import com.HuiShengTec.entity.PrizeInfo;

/******************************************************************************
 * @Package:      [com.HuiShengTec.app.service.impl.PrizeInfoServiceImpl.java]  
 * @ClassName:    [PrizeInfoServiceImpl]   
 * @Description:  [奖品]   
 * @Author:       [llj]   
 * @CreateDate:   [2014年12月25日 下午2:43:50] 
 * @Version:      [v1.0] 
 */
@Service
@Transactional
public class PrizeInfoServiceImpl implements IPrizeInfoService{

	@Autowired
	private IPrizeInfoDao iPrizeInfoDao;
	@Autowired
	private IImageDao iImageDao;

	@Override
	public PageBean queryPrizeInfo(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setRows(iPrizeInfoDao.queryPrizeInfo(pageBean));
		return pageBean;
	}
	
	@Override
	public Map<String, Object> queryPrizeInfoId(Integer id) {
		// TODO Auto-generated method stub
		return iPrizeInfoDao.queryPrizeInfoId(id);
	}

	@Override
	public Integer editPrizeInfoSubmit(PrizeInfo info) {
		// TODO Auto-generated method stub
		iPrizeInfoDao.editPrizeInfoSubmit(info);
		return 1;
		}

	@Override
	public Integer addPrizeInfoSubmit(PrizeInfo info) {
		// TODO Auto-generated method stub
		/*Integer picId=iImageDao.saveImages(attachment);
		info.setPicId(picId);*/
		iPrizeInfoDao.addPrizeInfoSubmit(info);
		return 1;
	}

		
	}
	

