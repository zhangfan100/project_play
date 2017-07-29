package com.HuiShengTec.app.dao;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.entity.Accountstatistics;

public interface IAccountStatisticsDao extends IBaseDao {
	
	public Integer addAccountStatistics(Accountstatistics data);
	/*
	 * 每天定时的统计
	 */
	public Map<String, Object> dayStatistics(Accountstatistics accountstatistics);
	
	/*
	 * 每周定时的统计
	 */
	public Map<String, Object> weekStatistics(Accountstatistics accountstatistics);
	
	/*
	 * 每月定时的统计
	 */
	public Map<String, Object> monthStatistics(Accountstatistics accountstatistics);
	
	/*
	 * 每季度定时的统计
	 */
	public Map<String, Object> quarterStatistics(Accountstatistics accountstatistics);
	
	/*
	 * 每年定时的统计
	 */
	public Map<String, Object> yearStatistics(Accountstatistics accountstatistics);
	
	/*
	 * 对应选择的日期段的统计
	 * @return
	 */
	public List<Map<String, Object>> getDayStatisticalData(Accountstatistics accountstatistics);
	/*
	 * 对应周的统计
	 * @return
	 */
	public List<Map<String, Object>> getWeekStatisticalData(Accountstatistics accountstatistics);
	/*
	 * 对于月的统计
	 */
	public List<Map<String, Object>> getMonthStatisticalData(Accountstatistics data);
	/*
	 * 对于季度的统计
	 */
	public List<Map<String, Object>> getQuarterStatisticalData(Accountstatistics data);
	/*
	 * 对于年的统计
	 */
	public List<Map<String, Object>> getYearStatisticalData(Accountstatistics data);
}
