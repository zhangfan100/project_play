package com.HuiShengTec.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IFinancialDao;
import com.HuiShengTec.app.dao.ILoginDao;
import com.HuiShengTec.app.dao.ISysAdminInfoDao;
import com.HuiShengTec.app.service.ISysAdminInfoService;
import com.HuiShengTec.base.cache.PropertiesCache;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.SalaryInfo;
import com.HuiShengTec.entity.SysAdminInfo;
import com.HuiShengTec.utils.Toolkit;

@Service
@Transactional
public class SysAdminInfoServiceImpl implements ISysAdminInfoService {
	@Autowired
	private ISysAdminInfoDao iSysAdminInfoDao;
	@Autowired
	private ILoginDao iLoginDao;
	@Autowired
	private IFinancialDao iFinancialDao;

	public PageBean querySysAdminInfoPage(PageInfo info) {
		PageBean bean =Toolkit.fillPageInfo(info);
		List<HashMap<String, Object>> list = iSysAdminInfoDao
				.querySysAdminInfoPage(bean);
		bean.setRows(list);
		return bean;
	}
	
	
	public void setAdminStatus(String idStr,Integer status){
		String[] ids = idStr.split(",");
		for (int i = 0; i < ids.length; i++) {
			HashMap<String, Object> condition = new HashMap<>();
			condition.put("userId", Integer.valueOf(ids[i]));
			condition.put("status", status);
			iSysAdminInfoDao.updateSysAdminStatus(condition);
		}
	}
	
	/**
	 * 分页查询管理员列表
	 */
	@Override
	public PageBean querySysAdminByPage(PageBean pageBean) {
		pageBean.setRows(iSysAdminInfoDao.querySysAdminByPage(pageBean));
		return pageBean;
	}
	@Override
	public  Map<Object,String> querySysAdminId(Integer id) {
		return iSysAdminInfoDao.querySysAdminId(id);
	}


	@Override
	public Map<String, Object> addSysAdminSbmitInfo(SysAdminInfo info,Login logInfo,Float cash) {
		if((!Toolkit.isEmpty(info))||(!Toolkit.isEmpty(logInfo))){
			iSysAdminInfoDao.addSysAdminSbmitInfo(info);
			logInfo.setUserId(info.getId());
			logInfo.setPassword(Toolkit.Md5encode(PropertiesCache.getValue("default_password")));
			iLoginDao.insertLoginInfo(logInfo);
			//初始化 人员薪资信息表
			SalaryInfo salaryInfo = new SalaryInfo();
			salaryInfo.setAdminId(info.getId());
			if(cash==null){//说明前台没有填写薪资 那么需要从数据库里面填写
				salaryInfo.setCash(Float.valueOf(PropertiesCache.getValue("basicFinancial")));
			}else{
				salaryInfo.setCash(cash);
			}
			salaryInfo.setSalaryType(2);
			salaryInfo.setStatus(1);
			iFinancialDao.insertSalaryInfo(salaryInfo);
			return Toolkit.getMapStatus(1);
		}else{
			return Toolkit.getMapStatus(0);
		}
	}


	@Override
	public Integer updateSysAdminInfo(SysAdminInfo data) {
		return iSysAdminInfoDao.updateSysAdminInfo(data);
	}
	
	/**
	 * 验证用户名
	 */
	@Override
	public Integer validateUserName(Login username) {
		return iLoginDao.validateUserName(username);
	}

	@Override
	public Integer validateEmail(Login email) {
		return iLoginDao.validateEmail(email);
	}
	@Override
	public Integer validatePhone(String phone) {
		return iSysAdminInfoDao.validatePhone(phone);
	}


	@Override
	public void editStatus(Login info) {
		iLoginDao.editStatus(info);
	}


	@Override
	public PageBean querySysByKeyWord(PageBean bean) {
		bean.setRows(iSysAdminInfoDao.querySysByKeyWord(bean));
		return bean;
	}


	
}
