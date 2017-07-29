package com.HuiShengTec.app.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ILoginDao;
import com.HuiShengTec.app.dao.IStuInfoDao;
import com.HuiShengTec.app.service.IStuInfoService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.StudentInfo;

/**
 * 学生管理
 * @author mihuajun
 *
 */

@Service
@Transactional
public class StuInfoServiceImpl implements IStuInfoService {
	
	@Autowired
	private IStuInfoDao iStuInfoDao;
	
	@Autowired
	private ILoginDao iLoginDao;
	
	/**
	 * 分页查询学生列表
	 */
	@Override
	public PageBean queryStudentsByPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setRows(iStuInfoDao.queryStudentsByPage(pageBean));
		return pageBean;
	}
	
	
	/**
	 * 显示学生详情
	 */
	@Override
	public Map<String, Object> queryStudentInfo(Integer id) {
		// TODO Auto-generated method stub
		return iStuInfoDao.queryStudentInfo(id);
	}

	/**
	 * 显示学生详情
	 */
	@Override
	public Map<String, Object> queryStudentInfoById(Integer id) {
		// TODO Auto-generated method stub
		return iStuInfoDao.queryStudentInfoById(id);
	}
	
	/**
	 * 查询学员头像
	 */
	@Override
	public String queryStudentHead(Integer id) {
		// TODO Auto-generated method stub
		return iStuInfoDao.queryStudentHead(id);
	}


	/**
	 * 学员注册
	 */
	@Override
	public Integer registerStudent(StudentInfo stuInf, Login login) {
		Integer count=this.validateCode(stuInf);
		count+=this.validateEmail(login);
		count+=this.validateUserName(login);
		if(count!=0){
			return 0;
		}
		iStuInfoDao.insertStudentInfo(stuInf);
		login.setUserId(stuInf.getId());
		login.setRoleType(1);
		iLoginDao.insertLoginInfo(login);
		return 1;
	}
	
	
	/**
	 * 修改
	 */
	@Override
	public Integer updateStudent(StudentInfo stuInfo, Login login) {
		// TODO Auto-generated method stub
		int len1= iStuInfoDao.updateStudentInfo(stuInfo);
		if(len1==0){
			throw new RuntimeException("更新失败");
		}
		int len2= iLoginDao.updateLoginInfo(login);
		if(len2==0){
			throw new RuntimeException("更新失败");
		}
		return 0;
	}


	/**
	 * 根据关键字筛选学生
	 */
	public PageBean queryStudentsByKeyWord(PageBean bean,String keyWord){
		bean.addConditions("keyWord", keyWord);
		bean.setRows(iStuInfoDao.queryStudentsByKeyWord(bean));
		return bean;
	}

	/**
	 * 修改学生密码
	 */
	@Override
	public Integer updateStuPassword(Login newLogin) {
			// TODO Auto-generated method stub
			Integer len = iLoginDao.updateLoginInfo(newLogin);
			//更新密码成功
			if(len == 0){
				return 2;
			}
			return 0;
		}

	/**
	 * 修改学生信息
	 * @param Info
	 * @return
	 * */

	@Override
	public void editStudentInfo(StudentInfo Info) {
		// TODO Auto-generated method stub
		iStuInfoDao.editStudentInfo(Info);
	}

	/**
	 * 查询学生信息
	 * @param ID
	 * @return
	 * */

	@Override
	public StudentInfo queryStuInfo(Integer id) {
		// TODO Auto-generated method stub
		return iStuInfoDao.queryStuInfo(id);
	}
	/**
	 * 验证用户名重复性
	 * @param username
	 * @return
	 * */

	@Override
	public int validateUserName(Login username) {
		// TODO Auto-generated method stub
		return iLoginDao.validateUserName(username);
	}

	/**
	 * 验证邮箱重复性
	 * @param email
	 * @return
	 * */
	@Override
	public int validateEmail(Login email) {
		// TODO Auto-generated method stub
		return iLoginDao.validateEmail(email);
	}

	/**
	 * 验证身份证重复性
	 * @param licenceCode
	 * @return
	 * */
	@Override
	public int validateCode(StudentInfo licenceCode) {
		// TODO Auto-generated method stub
		return iStuInfoDao.validateCode(licenceCode);
	}

	
	}
