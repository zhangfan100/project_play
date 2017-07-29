package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.SysAdminInfo;

public interface ISysAdminInfoDao extends IBaseDao{
	public SysAdminInfo querySysAdminInfo(Integer data);

	public List<HashMap<String, Object>> querySysAdminInfoPage(PageBean page);
	
	public void updateSysAdminStatus(HashMap<String, Object> condition);
	
	public List<Map<String,Object>> querySysAdminByPage(PageBean pageBean);
	
	public  Map<Object,String> querySysAdminId(Integer id);

	public void addSysAdminSbmitInfo(SysAdminInfo data);
	public Integer updateSysAdminInfo(SysAdminInfo data);
	public Integer validatePhone(String phone);

	public List<Map<String,Object>> querySysByKeyWord(PageBean bean);
}
