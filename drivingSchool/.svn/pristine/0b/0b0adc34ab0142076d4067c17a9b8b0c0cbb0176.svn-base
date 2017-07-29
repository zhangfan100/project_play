package com.HuiShengTec.app.service;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.Accountstatistics;

public interface IAccountstatisticsService {

	/**
	 * 得到日统计的数据
	 * @author [zf]
	 */
	Map<String, Object> getStatisticalData(Accountstatistics data);

	/**
	 * 得到周统计的数据
	 * * @author [zf]
	 */
	Map<String, Object> getWeekStatisticalData(Accountstatistics data);

	/**
	 * 得到月统计的数据
	 * * @author [zf]
	 */
	Map<String, Object> getMonthStatisticalData(Accountstatistics data);

	/**
	 * 季度统计的数据
	 * * @author [zf]
	 */
	Map<String, Object> getQuarterStatisticalData(Accountstatistics data);

	/*
	 * 年统计的数据
	 */
	Map<String, Object> getYearStatisticalData(Accountstatistics data);

	/**
	 * 封装表格显示的数据
	 * * @author [zf]
	 */
	PageBean fillStatisticalData(Accountstatistics data);

	/**
	 * 封装excel表格所需数据
	 * * @author [zf]
	 */
	Map<String, List<Object>> filDownLoadData(Accountstatistics accountstatistics);

}
