package com.HuiShengTec.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ILoginDao;
import com.HuiShengTec.app.dao.IMagInfoDao;
import com.HuiShengTec.app.service.IMagInfoService;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.SysAdminInfo;

/**
 * 提供管理员信息管理服务实现
 * @author mihuajun
 *
 */

@Service
@Transactional
public class MagInfoServiceImpl implements IMagInfoService {
	
	@Autowired
	private IMagInfoDao iMagInfoDao;
	
	@Autowired
	private ILoginDao iLoginDao;
	
	/**
	 * 修改管理员信息
	 */
	@Override
	public SysAdminInfo editMagInfoSubmit(SysAdminInfo userInfo) {
		// TODO Auto-generated method stub
		Integer len = iMagInfoDao.editMagInfo(userInfo);
		
		//更新成功
		if(len>0){
			return iMagInfoDao.querySysUser(userInfo);
		}
		
		return null;
	}
	
	/**
	 * 修改管理员密码
	 */
	@Override
	public Integer updateMagPassword(Login newLogin) {
		// TODO Auto-generated method stub
		Integer len = iLoginDao.updateLoginInfo(newLogin);
		//更新密码成功
		if(len == 0){
			return 2;
		}
		return 0;
	}
}
