package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.StudentInfo;


/**
 * @author llj
 *
 */
public interface IMyStudentDao extends IBaseDao {
	
	
	List<StudentInfo> queryMyStudentPage(PageBean pageBean);
	StudentInfo queryMyStudentByName(StudentInfo name);
	public HashMap<String, Object> queryMyStudent(Integer id);

}