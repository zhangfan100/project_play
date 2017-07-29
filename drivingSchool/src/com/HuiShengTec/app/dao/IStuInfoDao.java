package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.StudentInfo;

public interface IStuInfoDao  extends IBaseDao{
	public StudentInfo queryStuInfo(Integer data);
	public List<HashMap<String,Object>> queryNewStudents();
	public HashMap<String,Object> getStuTotalInfo(int id);
	/**
	 * 查询分校对应的学生
	 * @param coachId
	 * @return
	 */
	public List<HashMap<String, Object>> querySchoolTopStu(Integer campusId);
	/**
	 * 更新学员
	 * @param info
	 * @return
	 */
	
	public Integer updateStudentInfo(StudentInfo info);
	
	
	/**
	 * 分页查询学生列表
	 * @param pageBean
	 * @return
	 */
	public List<Map<String,Object>> queryStudentsByPage(PageBean pageBean);
	
	/**
	 * 显示学生详情
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryStudentInfo(Integer id);
	
	public Map<String, Object> queryStudentInfoById(Integer id);
	
	/**
	 * 插入学员信息
	 * @param stuInf
	 */
	public void insertStudentInfo(StudentInfo stuInf);
	
	/**
	 * 根据关键字筛选学生
	 * @author wtr
	 * @param condition
	 * @return
	 */
	public List<HashMap<String,Object>> queryStudentsByKeyWord(PageBean bean);
	
	public void editStudentInfo(StudentInfo Info);
	/**
	 * 验证身份证
	 * @param info
	 */
	public Integer validateCode(StudentInfo info);
	
	/**
	 * 查询学员头像
	 * @author mihuajun
	 * @createTime 2014-11-14 上午10:00:36
	 * @param id
	 * @return
	 */
	public String queryStudentHead(Integer id);
}
