package com.HuiShengTec.app.core;

import com.HuiShengTec.entity.CoachInfo;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.StudentInfo;
import com.HuiShengTec.entity.SysAdminInfo;

public class BaseAction extends com.HuiShengTec.base.action.BaseAction {
	protected static final String loginInfo="loginInfo";
	protected static final String userInfo="userInfo";
	/**
	 * 获取当前登陆学生
	 * @return
	 */
	protected StudentInfo getCurrLoginStudent(){
		return (StudentInfo) getSessionData(userInfo);
	}
	/**
	 * 获取当前登陆管理员
	 * @return
	 */
	protected SysAdminInfo getCurrLoginAdmin(){
		return (SysAdminInfo) getSessionData(userInfo);
	}
	/**
	 * 获取当前登陆的教练
	 * @return
	 */
	protected CoachInfo getCurrLoginCoach(){
		return (CoachInfo) getSessionData(userInfo);
	}
	/**
	 * 获取当前登陆信息
	 * @return
	 */
	protected Login getCurrLoginInfo(){
		return (Login) getSessionData(loginInfo);
	}
	
}
