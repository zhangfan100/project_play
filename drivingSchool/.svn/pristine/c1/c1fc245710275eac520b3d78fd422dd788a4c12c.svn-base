/**********************************************************************   
 * <p>文件名：LotteryInfoServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：drivingSchool
 * @author mihuajun  
 * @date 2014年12月25日 上午11:42:24 
 * @history
 * @department：慧莘软件部
 * Copyright ChengDu Huishen Technology Development CO.,LTD 2014
 * All Rights Reserved.
*/
package com.HuiShengTec.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ILotteryInfoDao;
import com.HuiShengTec.app.dao.ILotteryRoleDao;
import com.HuiShengTec.app.dao.IStudentLotteryInfoDao;
import com.HuiShengTec.app.service.ILotteryInfoService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.LotteryInfo;
import com.HuiShengTec.entity.LotteryRole;
import com.HuiShengTec.entity.StudentInfo;
import com.HuiShengTec.utils.Toolkit;

/******************************************************************************
 * @Package:      [com.HuiShengTec.app.service.impl.LotteryInfoServiceImpl.java]  
 * @ClassName:    [LotteryInfoServiceImpl]   
 * @Description:  [抽奖管理]   
 * @Author:       [llj]   
 * @CreateDate:   [2014年12月25日 上午11:42:24] 
 * @Version:      [v1.0] 
 */
@Service
@Transactional
public class LotteryInfoServiceImpl implements ILotteryInfoService{

	@Autowired
	private ILotteryInfoDao iLotteryInfoDao;
	
	@Autowired
	private IStudentLotteryInfoDao iStudentLotteryInfoDao;
	
	@Autowired
	private ILotteryRoleDao iLotteryRoleDao;

	/**
	 * 分页查询抽奖信息
	 */
	@Override
	public PageBean queryLotteryInfoPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setRows(iLotteryInfoDao.queryLotteryInfoPage(pageBean));
		return pageBean;
	}

	@Override
	public Map<String, Object> queryLotteryInfoId(Integer id) {
		// TODO Auto-generated method stub
		return iLotteryInfoDao.queryLotteryInfoId(id);
	}

	/**
	 * 
	 * @Title: queryLotteryinfo
	 * @Description: TODO(获取活动信息)
	 * @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	public HashMap<String, Object> queryStuLotteryInfo(StudentInfo stuInfo){
		Integer id=iLotteryInfoDao.queryLotteryinfo();
		if(Toolkit.isEmpty(id)){
			return Toolkit.getMapStatus(0);
		}else{
			HashMap<String, Object> condition = Toolkit.initMapCondition("stuId", stuInfo.getId());
			condition.put("lotteryId", id);
			Integer count = iStudentLotteryInfoDao.queryStudentLotteryInfoCount(condition);
			if(!((Integer)0).equals(count)){
				return Toolkit.getMapStatus(2);
			}else{
				HashMap<String, Object> result = Toolkit.getMapStatus(1);
				result.put("lotteryInfoId", id);
				return result;
			}
		}
	}

	/**
	 * 查询活动
	 */
	@Override
	public List<LotteryInfo> queryLotteryInfo() {
		// TODO Auto-generated method stub
		return iLotteryInfoDao.queryLotteryInfo();
	}

	/**
	 * 添加抽奖信息
	 */
	@Override
	public Integer addLotteryInfoSubmit(LotteryInfo info,Integer roleId) {
		// TODO Auto-generated method stub
		if(info.getStatus()!=1){
			iLotteryInfoDao.addLotteryInfoSubmit(info);
			LotteryRole lr=new LotteryRole();
			lr.setLotteryId(info.getId());
			lr.setRoleId(roleId);
			iLotteryRoleDao.addLotteryRole(lr);
			return 1;
		}else{
			iLotteryInfoDao.editLotteryAllStatus();
			iLotteryInfoDao.addLotteryInfoSubmit(info);
			LotteryRole lr=new LotteryRole();
			lr.setLotteryId(info.getId());
			lr.setRoleId(roleId);
			iLotteryRoleDao.addLotteryRole(lr);
			return 1;
		}
	}

	@Override
	public Integer editLotteryStatus(LotteryInfo info) {
		// TODO Auto-generated method stub
		iLotteryInfoDao.editLotteryAllStatus();
		return iLotteryInfoDao.editLotteryStatus(info)>1?1:0;
	}

	@Override
	public Integer editLotterySubmit(LotteryInfo info) {
		// TODO Auto-generated method stub
		return iLotteryInfoDao.editLotterySubmit(info);
	}
	
}
