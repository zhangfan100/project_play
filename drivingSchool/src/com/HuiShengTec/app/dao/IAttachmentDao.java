package com.HuiShengTec.app.dao;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.entity.Picture;

public interface IAttachmentDao extends IBaseDao{
	public void updateById(Picture attachment);
	public void saveAttachment(Picture attachment);
	public Integer queryByPath(String attPath);
	public String queryById(Integer id);
	public Picture queryAttInfoById(int id);
}
