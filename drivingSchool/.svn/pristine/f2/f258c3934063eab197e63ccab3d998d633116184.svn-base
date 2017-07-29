package com.HuiShengTec.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ICampusInfoDao;
import com.HuiShengTec.app.dao.ICoachInfoDao;
import com.HuiShengTec.app.dao.ICoachWeekLessonConfigDao;
import com.HuiShengTec.app.dao.IFinancialDao;
import com.HuiShengTec.app.dao.IImageDao;
import com.HuiShengTec.app.dao.ILoginDao;
import com.HuiShengTec.app.service.ICoachInfoService;
import com.HuiShengTec.app.service.ICoachWeekLessonConfigService;
import com.HuiShengTec.base.cache.PropertiesCache;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.CoachInfo;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.Picture;
import com.HuiShengTec.entity.SalaryInfo;
import com.HuiShengTec.utils.Toolkit;
/**
 * llj
 */
@Service
@Transactional
public class CoachInfoServiceImpl implements ICoachInfoService{
	@Autowired
	private ICoachInfoDao iCoachInfoDao;
	@Autowired
	private ICampusInfoDao iCampusInfoDao;
	@Autowired
	private IImageDao iImageDao;
	@Autowired
	private ILoginDao iLoginDao;
	@Autowired
	private ICoachWeekLessonConfigDao iCoachWeekLessonConfigDao;
	@Autowired
	private IFinancialDao iFinancialDao;
	
	@Autowired
	private ICoachWeekLessonConfigService iCoachWeekLessonConfigService;

	/**
	 * 获取教员信息
	 * @param id
	 * @return
	 */
	@Override
	public Map<String,Object> queryCohInfo(Integer id) {
		return iCoachInfoDao.queryCohInfo(id);
	}
	/**
	 * 手机端获取教员信息
	 * @param id
	 * @return
	 */
	@Override
	public Map<String,Object> queryMobCohInfoCount(Integer id) {
		return iCoachInfoDao.queryMobCohInfoCount(id);
	}
	@Override
	public CoachInfo queryCoachInfo(Integer id){
		return iCoachInfoDao.queryCoachInfo(id);
	}
	
	/**
	 * 修改教员信息
	 * @param coachInfo
	 */
	@Override
	public void editCoachInfo(CoachInfo cohInfo) {
		iCoachInfoDao.editCoachInfo(cohInfo);
	}
	
	/**
	 * 获取教员登陆信息
	 * @param id
	 */
	@Override
	public Login queryCohLoginInfo(Integer id) {
		return iLoginDao.getCohLoginInfo(id);
	}
	
	/**
	 * 查询驾考教练列表
	 */
	@Override
	public List<Map<String,Object>> queryDriveCoachPage(Map<String,Object> param) {
		return iCoachInfoDao.queryDriveCoachPage(param);
	}
	
	/**
	 * 分页显示教练信息
	 */
	@Override
	public void queryCoachsByPage(PageBean pageBean) {
		pageBean.setRows(iCoachInfoDao.queryCoachsByPage(pageBean));
	}
	

	
	/**
	 * 修改教练
	 */
	@Override
	public Integer updateCoach(CoachInfo coachInfo, Login login) {
		int len1= iCoachInfoDao.editCoachInfo(coachInfo);
		if(len1==0){
			throw new RuntimeException("更新失败");
		}
		int len2= iLoginDao.updateLoginInfo(login);
		if(len2==0){
			throw new RuntimeException("更新失败");
		}
		return 0;
	}
	@Override
	public PageBean queryInfo(PageBean bean) {
		bean.setRows(iCoachInfoDao.queryCoachShowInfo(bean));
		return bean;
	}
	@Override
	public HashMap<String, Object> queryteacherAttr(PageBean bean) {
		return iCoachInfoDao.queryteacherAttr(bean);
	}
	@Override
	public List<HashMap<String, Object>> queryTeacherTypeTwoAttr(PageBean bean) {
		return iCoachInfoDao.queryTeacherTypeTwoAttr(bean);
	}
	@Override
	public List<HashMap<String, Object>> queryCommentNum(Integer id) {
		List<HashMap<String, Object>> list = iCoachInfoDao.queryCommentNum(id);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for(int i=5;i>=1;i--){
			HashMap<String, Object> item = null;
			for(HashMap<String, Object> em:list){
				if((Integer)(em.get("score"))==i){
					item = em;
					break;
				}
			}
			if(item==null){
				item = new HashMap<String, Object>();
				item.put("score",i);
				item.put("total",0);
			}
			result.add(item);
		}
		return result;
	}
	@Override
	public List<HashMap<String, Object>> queryCommentInfo(Integer id) {
		return iCoachInfoDao.queryCommentInfo(id);
	}
	@Override
	public List<HashMap<String, Object>> queryCoachInfoById(Integer campusId) {
		return iCoachInfoDao.queryCoachInfoById(campusId);
	}
	
	/**
	 * 添加教练
	 */
	@Override
	public Map<String, Object> addCoachSubmit(CoachInfo coachInfo, Login login,
			String imgCode, String path, Float cash) {
		//存储图片
		Picture pic = new Picture();
		pic.setPath(path);
		iImageDao.saveImages(pic);
		Integer picId = pic.getId();
		//设置图片 密码 简称
		coachInfo.setPicId(picId);
		login.setPassword(Toolkit.Md5encode(PropertiesCache.getValue("default_password")));
		coachInfo.setForShort(Toolkit.convertShortPinyin(coachInfo.getName()));
		//数据库插入条目
		iCoachInfoDao.insertStudentInfo(coachInfo);
		login.setUserId(coachInfo.getId());
		//角色类型设置为教练
		login.setRoleType(2);
		iLoginDao.insertLoginInfo(login);
		//初始化工资信息
		SalaryInfo salaryInfo = new SalaryInfo();
		salaryInfo.setCoachId(coachInfo.getId());
		if(cash==null){
			salaryInfo.setCash(Float.valueOf(PropertiesCache.getValue("basicFinancial")));
		}else{
			salaryInfo.setCash(cash);
		}
		salaryInfo.setSalaryType(1);
		salaryInfo.setStatus(1);
		iFinancialDao.insertSalaryInfo(salaryInfo);
		return Toolkit.getMapStatus(0);
	}
	@Override
	public PageBean queryCoachByKeyWord(PageBean bean) {
		bean.setRows(iCoachInfoDao.queryCoachByKeyWord(bean));
		return bean;
	}
	
	/**
	 * 根据时间，和分校学校Id 查询各个分校的前4名教练排名
	 * 算法 按照每个教练所教的学生排名  
	 * 前台需要传一个map key=date value=具体的时间 key=campusId value=具体学校的id 初次都查出来 
	 * 返回来的是一个list 里面是map  map里面封装了对应学校的教练排名信息
	 * @author zf
	 */
	@Override
	public List<List<Map<String, Object>>> rankCoachByMonth(Map<String, Object> param) {
		List<List<Map<String, Object>>> result = new ArrayList<List<Map<String, Object>>>();
		Object object = param.get("date");
		if(null == object || "".equals(object.toString())){//说明前台没有传 那么是初始化
			param.put("date", new Date());
		}
		Object campusIdObj = param.get("campusId");
		if(null == campusIdObj || "".equals(campusIdObj.toString())){//说明前台没有传 那么是初始化
			List<Map<String, Object>> campusInfoLists = iCampusInfoDao.queryCampusInfo();//得到所有的分校
			for(Map<String, Object> map1 : campusInfoLists){
				String campusId = map1.get("id").toString();
				param.put("campusId",campusId);
				result.add(iCoachInfoDao.rankCoachByMonth(param));
			}
		}else{//前台传的有 
			result.add(iCoachInfoDao.rankCoachByMonth(param));
		}
		
		
		return result;
	}
}
