package com.HuiShengTec.app.service;

import java.util.Map;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.StudentInfo;

/**
 * 学生管理
 * @author mihuajun
 *
 */
public interface IStuInfoService {
	
	/**
	 * 分页查询学生列表
	 * @param pageBean
	 * @return
	 */
	PageBean queryStudentsByPage(PageBean pageBean);
	
	/**
	 * 学员注册
	 * @param stuInf
	 * @param login
	 * @return
	 */
	Integer registerStudent(StudentInfo stuInf, Login login);
	
	/**
	 * 学员信息修改
	 * @param stuInfo
	 * @param login
	 * @return
	 */
	Integer updateStudent(StudentInfo stuInfo, Login login);
	
	public PageBean queryStudentsByKeyWord(PageBean bean, String keyWord);
	
	/**
	 * 显示学生详情
	 * @param id
	 * @return
	 */
	Map<String, Object> queryStudentInfo(Integer id);
	Map<String, Object> queryStudentInfoById(Integer id);
	
	
	/**
	 * 查询学员头像
	 * @author mihuajun
	 * @createTime 2014-11-14 上午9:59:51
	 * @param id
	 * @return
	 */
	String queryStudentHead(Integer id);
	
	
	
	Integer updateStuPassword(Login newLogin);

	/**
	 * 修改学员信息
	 * @param data
	 */
	public void editStudentInfo(StudentInfo Info);
	/**
	 * 获取学员信息
	 * @param id
	 * @return
	 */
	public StudentInfo queryStuInfo(Integer id);
	
	/**
	 * 验证用户名重复性
	 * @param info
	 * @return
	 * */
	public int validateUserName(Login userName);
	
	/**
	 * 验证邮箱重复性
	 * @param info
	 * @return
	 * */
	public int validateEmail(Login email);
	
	/**
	 * 验证身份证重复性
	 * @param info
	 * @return
	 * */
	public int validateCode(StudentInfo licenceCode);

}
