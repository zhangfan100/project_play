package com.HuiShengTec.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IBasicPropertiesDao;
import com.HuiShengTec.app.dao.ICodeTempDao;
import com.HuiShengTec.app.dao.IStuInfoDao;
import com.HuiShengTec.app.dao.ITestInfoDao;
import com.HuiShengTec.app.service.ITestInfoService;
import com.HuiShengTec.base.cache.PropertiesCache;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.StudentInfo;
import com.HuiShengTec.entity.TestInfo;
import com.HuiShengTec.utils.Toolkit;

@Service
@Transactional
public class TestInfoServiceImpl implements ITestInfoService {
	@Autowired
	public ITestInfoDao iTestInfoDao;
	@Autowired
	public IStuInfoDao iStuInfoDao;
	@Autowired
	public IBasicPropertiesDao iBasicPropertiesDao;
	@Autowired
	public ICodeTempDao iCodeTempDao;

	public PageBean queryTestInfoPage(PageInfo info) {
		PageBean bean = Toolkit.fillPageInfo(info);
		bean.setRows(iTestInfoDao.queryTestInfoPage(bean));
		return bean;
	}

	public Integer addTestInfo(TestInfo info) {
		// 装填学生信息
		StudentInfo stuInfo = iStuInfoDao.queryStuInfo(info.getStuId());
		return this.addTestInfo(info, stuInfo);
	}

	public void cancelTestInfo(String ids) {
		List<Integer> intIds = new ArrayList<>();
		String[] idStrs = ids.split(",");
		for (int i = 0; i < idStrs.length; i++) {
			intIds.add(Integer.valueOf(idStrs[i]));
		}
		iTestInfoDao.delTestInfo(intIds);
	}

	public Integer addTestInfo(TestInfo info, StudentInfo stuInfo) {
		// 判断约考的时期(必须提交一天预约)
		if (info.getStudyDate().before(new Date())) {
			return 1;
		}
		// 判断考试人数是否已满
		Integer testLimit = Integer.valueOf(PropertiesCache
				.getValue("testPersonLimit"));
		Integer currCount = iTestInfoDao.queryAllDayTestCount(info
				.getStudyDate());
		if (currCount >= testLimit) {
			return 3;
		}
		// 单人考试限制
		Integer singleTestPersonCount = Integer.valueOf(PropertiesCache
				.getValue("testSingleLimit"));
		currCount = iTestInfoDao.queryStuTestCount(info.getStuId());
		if (currCount >= singleTestPersonCount) {
			return 2;
		}
		info.setStuId(stuInfo.getId());
		info.setStuName(stuInfo.getName());
		info.setStuForShort(stuInfo.getForShort());
		info.setStuCode(stuInfo.getLicenceCode());
		info.setStatus(0);
		info.setCash(Float.valueOf(PropertiesCache.getValue("testPrice")));
		info.setCampusId(stuInfo.getCampusId());
		HashMap<String, Object> condition =Toolkit.initMapCondition("codeType",2);
		condition.put("planDate",info.getStudyDate());
		info.setTestCode(iCodeTempDao.queryCodeByType(condition));
		info.setLicenceId(stuInfo.getLicenceId());
		info.setStuType(stuInfo.getStuType());
		if (Toolkit.isEmpty(info.getStuPhone())) {
			info.setStuPhone(stuInfo.getPhone());
		}
		iTestInfoDao.addTestInfo(info);
		return 0;
	}
	
	public List<HashMap<String, Object>> queryStuTestInfoList(Integer stuId){
		return iTestInfoDao.queryStuTestInfoList(stuId);
	}
	
	public HashMap<String, Object> queryTestDetail(Integer testInfoId){
		return iTestInfoDao.queryTestDetail(testInfoId);
	}
	
	/**
	 * 取消预约模考
	 * @author mihuajun
	 * @createTime 2014-11-19 上午11:17:42
	 * @param id
	 * @return
	 */
	@Override
	public Integer deletePExam(Integer id){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(id);
		HashMap<String, Object> info = iTestInfoDao.queryTestinfoById(id);
		if ((Integer)info.get("status")==0) {
			iTestInfoDao.delTestInfo(ids);
			return 1;
		}else {
			return 0;
		}
	}
}
