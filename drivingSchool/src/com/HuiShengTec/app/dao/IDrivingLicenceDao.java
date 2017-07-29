package com.HuiShengTec.app.dao;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.entity.DrivingLicence;

public interface IDrivingLicenceDao extends IBaseDao {
	public List<DrivingLicence> queryCurrentDrivingLicence();
	
	public List<DrivingLicence> queryAllLicence();
	
	public Integer editDrivingLicenceSubmit(DrivingLicence drivingLicenceInfo);
	public Integer editDrivingLicenceStatus(Map<String,Object> param);
}
