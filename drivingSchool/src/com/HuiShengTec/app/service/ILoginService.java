package com.HuiShengTec.app.service;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.SignInLog;

public interface ILoginService {
	public Object queryUserInfo(Login data);
	/**
	 * @param log
	 */
	public void addSignInLog(SignInLog log);
	public Integer updateLoginInfo(Login info);
	
	public void updateLoginPassword(Login data);
	
	/**
	 * 重置密码
	 * @param login
	 * @return
	 */
	Integer resetPassword(Login login);
	
	/**
	 * 开户、禁用帐号
	 * @param login
	 * @return
	 */
	Integer enableAccount(Login login);
	
	/**
	 * 根据用户名和密码更新mobileFlag
	 * @param login
	 * @return
	 */
	public Integer updateLoginMobileFlag(Login login);
	
	public Login queryLoginInfoByMobileFlag(String mobileFlag);
	
	/**
	 * 删除登录日志
	 * @author mihuajun
	 * @createTime 2014-11-24 下午6:13:29
	 * @param param
	 * @return
	 */
	public Integer delSignInLog(String[] param);
	
	/**
	 * 分页显示登录日志
	 * @author mihuajun
	 * @createTime 2014-11-24 下午6:13:50
	 * @param pageBean
	 * @return
	 */
	public PageBean querySignLogPage(PageBean pageBean);
	
	public void editLoginRoleId(Login login);
	
}
