package com.HuiShengTec.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IMyStudentDao;
import com.HuiShengTec.app.service.IMyStudentService;
import com.HuiShengTec.base.entity.PageBean;

/**
 * 我的学员
 * @author llj
 *
 */

@Service
@Transactional
public class MyStudentServiceImpl implements IMyStudentService{
	@Autowired
	private IMyStudentDao studentDao;
	@Override
	public PageBean queryMyStudentPage(PageBean pageBean) {
		// TODO Auto-generated method stub
				pageBean.setRows(studentDao.queryMyStudentPage(pageBean));
				return pageBean;
	}
}
