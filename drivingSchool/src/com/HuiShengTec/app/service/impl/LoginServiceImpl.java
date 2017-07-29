package com.HuiShengTec.app.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ICoachInfoDao;
import com.HuiShengTec.app.dao.ILoginDao;
import com.HuiShengTec.app.dao.ISignInLogDao;
import com.HuiShengTec.app.dao.IStuInfoDao;
import com.HuiShengTec.app.dao.ISysAdminInfoDao;
import com.HuiShengTec.app.service.ILoginService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.SignInLog;
import com.HuiShengTec.utils.Toolkit;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService {
	@Autowired
	private ILoginDao iLoginDao;
	@Autowired
	private IStuInfoDao iStuInfoDao;
	@Autowired
	private ICoachInfoDao iCoachInfoDao;
	@Autowired
	private ISysAdminInfoDao iSysAdminInfoDao;
	@Autowired
	private ISignInLogDao iSignInLogDao;
	
	
	/**
	 * 重置密码
	 */
	@Override
	public Integer resetPassword(Login login) {
		// TODO Auto-generated method stub
		return iLoginDao.updateLoginInfo(login)>0?0:1;
	}
	

	/**
	 * 开户、禁用帐号
	 */
	@Override
	public Integer enableAccount(Login login) {
		// TODO Auto-generated method stub
		return iLoginDao.updateLoginInfo(login)>0?0:1;
	}
	
	/**
	 * 登陆
	 * @param data
	 * @return
	 */
	public Object queryUserInfo(Login data){
		int roleType=data.getRoleType();
		Login user=iLoginDao.queryUserInfo(data);
		if(!Toolkit.isEmpty(user)){
			data.setId(user.getId());
			data.setLoginCount(user.getLoginCount());
			data.setUserId(user.getUserId());
			data.setEmail(user.getEmail());
			data.setLastLoginIP(user.getLastLoginIP());
			data.setLastLoginTime(user.getLastLoginTime());
			data.setRoleId(user.getRoleId());
			data.setMobileFlag(user.getMobileFlag());
				switch (roleType) {
				case 1:
					return iStuInfoDao.queryStuInfo(data.getUserId());
				case 2:
					return iCoachInfoDao.queryCoachInfo(data.getUserId());
				case 3:
					return iSysAdminInfoDao.querySysAdminInfo(data.getUserId());
				default:
					return null;
				}
			}else{
				return null;
			}
		
	}
	
	
	/**
	 * @param log
	 */
	public void addSignInLog(SignInLog log){
		iSignInLogDao.addSignInLog(log);
	}
	/**
	 * 更新登陆信息
	 * @param info
	 */
	@Override
	public Integer updateLoginInfo(Login info) {
		 return iLoginDao.updateLoginInfo(info);
	}

	@Override
	public void updateLoginPassword(Login data) {
		// TODO Auto-generated method stub
		iLoginDao.updateLoginPassword(data);
	}

	
	/**
	 *  根据用户名和密码更新mobileFlag
	 */
	@Override
	public Integer updateLoginMobileFlag(Login login) {
		// TODO Auto-generated method stub
		Integer len = iLoginDao.updateLoginMobileFlag(login);
		if(len==0){
			return 0;
		}else{
			login = iLoginDao.queryLoginInfoByMobileFlag(login.getMobileFlag());
			return login.getUserId();
		}
	}


	@Override
	public Login queryLoginInfoByMobileFlag(String mobileFlag) {
		// TODO Auto-generated method stub
		return iLoginDao.queryLoginInfoByMobileFlag(mobileFlag);
	}

	/**
	 * 删除登录日志
	 */
	@Override
	public Integer delSignInLog(String[] param) {
		// TODO Auto-generated method stub
		return iLoginDao.delSignInLog(param)>0?0:1;
	}

	/**
	 * 分页显示登录日志
	 */
	@Override
	public PageBean querySignLogPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setRows(iLoginDao.querySignLogPage(pageBean));
		return pageBean;
	}
	/**
	 * 手机学生端登录服务
	 * @param login
	 * @param session
	 * @return
	 */
	public HashMap<String, Object> mobileStuLogin(Login login,HttpSession session){
		//设定角色为学生
		login.setRoleType(1);
		//MD5加密密码
		login.setPassword(Toolkit.Md5encode(login.getPassword()));
		//查询学生登录信息
		Login userData = iLoginDao.queryUserInfo(login);
		if(Toolkit.isEmpty(userData)){
			//用户名密码错误 登录失败
			return Toolkit.getMapStatus(0);
		}else if(userData.getStatus().equals(0)){
			//账户停用
			return Toolkit.getMapStatus(2);
		}
		
		return null;
	}


	@Override
	public void editLoginRoleId(Login login) {
		//修改对应学员的角色ID为对应的角色ID 比如从科目一改变为科目二时 
		//那么就是从已激活学员（科目二）到已激活学员（科目三）
		iLoginDao.editLoginRoleId(login);
	}
	
}
