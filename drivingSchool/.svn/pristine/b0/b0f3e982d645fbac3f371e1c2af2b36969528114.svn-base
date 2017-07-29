package com.HuiShengTec.app.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.CoachInfo;
import com.HuiShengTec.entity.Login;

public interface ICoachInfoService {
	/**
	 * 获取教员信息
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryCohInfo(Integer id);
	public Map<String, Object> queryMobCohInfoCount(Integer id);
	
	public List<HashMap<String, Object>> queryCoachInfoById(Integer campusId);
	
	public CoachInfo queryCoachInfo(Integer id);
	
	/**
	 * 修改教员信息
	 * @param data
	 */
	public void editCoachInfo(CoachInfo cohInfo);
	
	
	/**
	 * 获取教员登陆信息
	 * @param id
	 * @return
	 */
	public Login queryCohLoginInfo(Integer id);
	
	/**
	 * 查询驾考教练列表
	 * @param pageBean
	 */
	public List<Map<String,Object>> queryDriveCoachPage(Map<String,Object> param);
	
	/**
	 * 分页显示教练信息
	 * @param pageBean
	 */
	public void queryCoachsByPage(PageBean pageBean);
	
	
	/**
	 * 修改教练信息
	 * @param coachInfo
	 * @param login
	 * @return
	 */
	public Integer updateCoach(CoachInfo coachInfo, Login login);
	
	
	public PageBean queryInfo(PageBean bean);
	public HashMap<String, Object> queryteacherAttr(PageBean bean);
	public List<HashMap<String, Object>> queryTeacherTypeTwoAttr(PageBean bean);
	public List<HashMap<String,Object>> queryCommentNum(Integer id);
	public List<HashMap<String, Object>> queryCommentInfo(Integer id);
	
	/**
	 * 添加教练
	 * @param coachInfo
	 * @param login
	 * @param imgCode
	 * @param path
	 * @param cash
	 * @return
	 */
	public Map<String, Object> addCoachSubmit(CoachInfo coachInfo, Login login,
			String imgCode, String path, Float cash);
	//根据关键字搜索教练
	public PageBean queryCoachByKeyWord(PageBean bean);
	
	/**
	 * 根据时间，和分校学校Id 查询各个分校的前4名教练排名
	 * 算法 按照每个教练所教的学生排名  
	 * 前台需要传一个map key=date value=具体的时间 key=campusId value=具体学校的id 初次都查出来 
	 * 返回来的是一个list 里面是map  map里面封装了对应学校的教练排名信息
	 * @author zf
	 */
	public List<List<Map<String, Object>>> rankCoachByMonth(Map<String, Object> param);
	
}
