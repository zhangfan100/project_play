package com.HuiShengTec.app.service;

import java.util.Map;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.SysAdminInfo;

public interface ISysAdminInfoService {
	public PageBean querySysAdminInfoPage(PageInfo info);
	public void setAdminStatus(String idStr,Integer status);
	public PageBean querySysAdminByPage(PageBean pageBean);
	public Map<Object,String> querySysAdminId(Integer id);
	public Map<String, Object> addSysAdminSbmitInfo(SysAdminInfo info,Login logInfo,Float cash);
	public Integer updateSysAdminInfo(SysAdminInfo data);
	public Integer validateUserName(Login username);
	public Integer validateEmail(Login email);
	public Integer validatePhone(String phone);
	public void editStatus(Login info);
	//关键字查询管理员
	public PageBean querySysByKeyWord(PageBean bean);
}
