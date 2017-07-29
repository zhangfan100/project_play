package com.HuiShengTec.app.dao;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;

/**
 *  学员统计
 * @author llj
 *
 */
public interface ILessonStatisticsDao extends IBaseDao {
	
	/**
	 * 培训统计
	 * @param stuId
	 * @return
	 */
	List<Map<String, Object>> queryTrainStatistics(Integer stuId);
	
	/**
	 * 培训学时统计
	 * @param integer
	 * @return
	 */
	List<Map<String, Object>> queryPeriodStatistics(Integer stuId);
	
	/**
	 * 统计学员各项目通过率，制成表格
	 * @param integer
	 * @return
	 */
	List<Map<String, Object>> queryTrainStatisticsTable(Integer stuId);

}
