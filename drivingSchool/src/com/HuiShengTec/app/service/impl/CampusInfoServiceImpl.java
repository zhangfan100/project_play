package com.HuiShengTec.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ICampusInfoDao;
import com.HuiShengTec.app.service.ICampusInfoService;
import com.HuiShengTec.entity.CampusInfo;
import com.HuiShengTec.entity.Picture;
/**
 * @author llj
 * 分校管理
 */

@Service
@Transactional
public class CampusInfoServiceImpl implements ICampusInfoService{

	@Autowired
	private ICampusInfoDao iCampusInfoDao;

	@Override
	public List<Map<String, Object>> queryCampusInfo() {
		return iCampusInfoDao.queryCampusInfo();
	}

	@Override
	public Map<String, Object> queryCampusName(Integer id) {
		return iCampusInfoDao.querySchoolName(id);
	}

	@Override
	public Picture campusInfoImg() {
		return iCampusInfoDao.separateSchoolImg();
	}

	@Override
	public void editCampusInfoSubmit(CampusInfo data) {
		// TODO Auto-generated method stub
	 iCampusInfoDao.editCampusInfoSubmit(data);
	}

	@Override
	public void delCampusInfo(Integer id) {
		// TODO Auto-generated method stub
		iCampusInfoDao.delCampusInfo(id);
	}

	@Override
	public Integer addCampusInfo(CampusInfo data) {
		// TODO Auto-generated method stub
		return iCampusInfoDao.addCampusInfo(data);
	}

	@Override
	public CampusInfo queryCampusInfoId(Integer id) {
		// TODO Auto-generated method stub
		return iCampusInfoDao.queryCampusInfoId(id);
	}

}
