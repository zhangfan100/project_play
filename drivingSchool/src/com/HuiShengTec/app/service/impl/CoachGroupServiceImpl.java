package com.HuiShengTec.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ICoachGroupDao;
import com.HuiShengTec.app.service.ICoachGroupService;
import com.HuiShengTec.base.entity.PageBean;

/**
 * 教员分组
 * @author mihuajun
 * @createTime 2014-11-12 下午4:46:27
 */

@Transactional
@Service
public class CoachGroupServiceImpl implements ICoachGroupService {
	
	@Autowired
	private ICoachGroupDao iCoachGroupDao;
	
	/**
	 * 分页显示空闲的教练
	 */
	@Override
	public void queryUnusedCoachPage(PageBean pageBean) {
		pageBean.setRows(iCoachGroupDao.queryUnusedCoachPage(pageBean));
	}
	
	/**
	 * 分页显示非空闲的教练
	 */
	@Override
	public void queryUsedCoachPage(PageBean pageBean) {
		pageBean.setRows(iCoachGroupDao.queryUsedCoachPage(pageBean));
	}
	
	/**
	 * 加入分组教练
	 */
	@Override
	public Integer joinCoachGroup(Integer weekDay, Integer subject,Integer timeSlot,
			String cohIds) {
//		Map<String,Object> param = new HashMap<String, Object>();
//		
//		param.put("weekDay", weekDay);
//		param.put("subject", subject);
//		param.put("timeSlot", timeSlot);
//		
//		for(String item:cohIds.split(",")){
//			param.put("coachId", Integer.valueOf(item));
//			iCoachWeekLessonConfigDao.changeTimeSlotType(param);
//		}
		return 0;
	}
	
//	@Override
//	public Integer joinCoachGroup(Integer weekDay, Integer subject,Integer timeSlot,
//			String cohIds) {
//		Map<String,Object> param = new HashMap<String, Object>();
//		param.put("weekDay", weekDay);
//		param.put("subject", subject);
//		param.put("timeSlot", timeSlot);
//		
//		Integer groupId = iCoachGroupDao.queryWeekGroupId(param);
//		
//		param.put("groupId", groupId); 
//		
//		for(String item:cohIds.split(",")){
//			param.put("coachId", Integer.valueOf(item));
//			iCoachGroupDao.insertCoachGroup(param);
//		}
//		return 0;
//	}
	
	/**
	 * 移除教练分组
	 */
	@Override
	public Integer removeCoachGroup(String groupIds) {
		return iCoachGroupDao.removeCoachGroup(groupIds.split(","))>0?0:1;
	}
	
	
	
}
