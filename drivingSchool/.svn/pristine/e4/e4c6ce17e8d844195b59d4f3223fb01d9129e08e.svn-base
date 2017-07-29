package com.HuiShengTec.app.service;

import com.HuiShengTec.base.entity.PageBean;

/**
 * 教员分组
 * @author mihuajun
 * @createTime 2014-11-12 下午4:44:14
 */
public interface ICoachGroupService {
	
	/**
	 * 分页显示空闲的教练
	 * @author mihuajun
	 * @createTime 2014-11-12 下午4:47:03
	 * @param pageBean
	 * @return
	 */
	void queryUnusedCoachPage(PageBean pageBean);
	
	/**
	 *  分页显示非空闲的教练
	 * @author mihuajun
	 * @createTime 2014-11-12 下午5:38:10
	 * @param pageBean
	 */
	void queryUsedCoachPage(PageBean pageBean);
	
	/**
	 * 加入分组教练
	 * @author mihuajun
	 * @createTime 2014-11-13 上午10:23:17
	 * @param weekDay
	 * @param subject
	 * @param cohIds
	 * @return
	 */
	Integer joinCoachGroup(Integer weekDay, Integer subject,Integer timeSlot, String cohIds);

	
	/**
	 * 移除教练分组
	 * @author mihuajun
	 * @createTime 2014-11-13 上午10:23:41
	 * @param groupIds
	 * @return
	 */
	Integer removeCoachGroup(String groupIds);

}
