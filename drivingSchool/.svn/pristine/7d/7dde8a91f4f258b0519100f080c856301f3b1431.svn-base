package com.HuiShengTec.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IAttachmentDao;
import com.HuiShengTec.app.service.IAttachmentService;
import com.HuiShengTec.entity.Picture;
@Service
@Transactional
public class AttachmentServiceImpl implements IAttachmentService {
	@Autowired
	private IAttachmentDao iAttachmentDao;
	@Override
	public void updateById(Picture attachment) {
		iAttachmentDao.updateById(attachment);
		
	}

	@Override
	public void saveAttachment(Picture attachment) {
		iAttachmentDao.saveAttachment(attachment);
		
	}

	@Override
	public Integer queryByPath(String attPath) {
		return iAttachmentDao.queryByPath(attPath);
	}

	@Override
	public String queryById(Integer id) {
		return iAttachmentDao.queryById(id);
	}
	
	public Picture queryAttInfoById(int id){
		return iAttachmentDao.queryAttInfoById(id);
	}


}
