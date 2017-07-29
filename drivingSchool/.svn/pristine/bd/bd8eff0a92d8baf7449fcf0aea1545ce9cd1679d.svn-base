package com.HuiShengTec.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.SignInLog;
/**
 * 统一登陆数据源
 * @author 王泰然
 *
 */
public interface ILoginDao extends IBaseDao {
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	public Login queryUserInfo(Login data);
	/**
	 * 更新登陆信息
	 * @param info
	 */
	public Integer updateLoginInfo(Login info);
	
	public Login getCohLoginInfo(Integer id);
	
	public void updateLoginPassword(Login data);

	/**
	 * 插入登录信息
	 * @param login
	 */
	public void insertLoginInfo(Login login);
	public Integer deleteLoginById(Integer id);
	
	public void editStatus(Login info);
	
	/**
	 * 根据用户名和密码更新mobileFlag
	 * @param login
	 * @return
	 */
	public Integer updateLoginMobileFlag(Login login);
	
	/**
	 * 根据mobileFlag查询登记信息
	 */
	public Login queryLoginInfoByMobileFlag(String mobileFlag);
	
	/**
	 * 验证用户名
	 * @param userName
	 */
    public Integer validateUserName(Login username);
    /**
     * 验证邮箱
     * @param email
     */
    public Integer validateEmail(Login email);
    
    /**
     * 删除登录日志
     * @author mihuajun
     * @createTime 2014-11-24 下午6:15:51
     * @param param
     * @return
     */
	public int delSignInLog(String[] param);
	/**
	 * 分页显示登录日志
	 * @author mihuajun
	 * @createTime 2014-11-24 下午6:16:07
	 * @param pageBean
	 * @return
	 */
	public List<SignInLog> querySignLogPage(PageBean pageBean);
	
	public void editLoginRoleId(Login login);
    
}
