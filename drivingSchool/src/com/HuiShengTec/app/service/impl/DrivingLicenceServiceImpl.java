package com.HuiShengTec.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IDrivingLicenceDao;
import com.HuiShengTec.app.service.IDrivingLicenceService;
import com.HuiShengTec.entity.DrivingLicence;

@Service
@Transactional
public class DrivingLicenceServiceImpl implements IDrivingLicenceService {
	@Autowired
	private IDrivingLicenceDao iDrivingLicenceDao;
	/**
	 * 获取启用的驾照类型
	 * @return
	 */
	public List<DrivingLicence> queryCurrentDrivingLicence(){
		return iDrivingLicenceDao.queryCurrentDrivingLicence();
	}
	/**
	 * 获取所有的
	 * @return
	 */
	public List<DrivingLicence> queryAllDrivingLicence(){
		return iDrivingLicenceDao.queryAllLicence();
	}
	
	@Override
	public Integer editDrivingLicenceSubmit(DrivingLicence drivingLicenceInfo) {
		// TODO Auto-generated method stub
		return iDrivingLicenceDao.editDrivingLicenceSubmit(drivingLicenceInfo);
	}
	@Override
	public Integer editDrivingLicenceStatus(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return iDrivingLicenceDao.editDrivingLicenceStatus(param)>0?0:1;
	}
}
