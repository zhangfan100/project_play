package com.HuiShengTec.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IAccountStatisticsDao;
import com.HuiShengTec.app.service.IAccountstatisticsService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.Accountstatistics;

@Service
@Transactional
public class AccountstatisticsServiceImpl implements IAccountstatisticsService{

	@Autowired
	private IAccountStatisticsDao iAccountStatisticsDao;

	/**
	 * 得到从选择日以前的七天（包括选择日）的统计的柱状图
	 */
	@Override
	public Map<String, Object> getStatisticalData(Accountstatistics accountstatistics) {
		return fillChartsDate(iAccountStatisticsDao.getDayStatisticalData(accountstatistics),accountstatistics);
	}

	/**
	 * 得到周统计的数据
	 */
	@Override
	public Map<String, Object> getWeekStatisticalData(Accountstatistics data) {
		data.setEndTime(new Date(data.getEndTime().getTime()+24*3600*1000));//把时间设置延后一天 方便数据库比较 2015-02-01  --》2015-02-02
		return fillChartsDate(iAccountStatisticsDao.getWeekStatisticalData(data),data);
	}

	/**
	 * 得到月统计的数据
	 */
	@Override
	public Map<String, Object> getMonthStatisticalData(Accountstatistics data) {
		data.setEndTime(new Date(data.getEndTime().getTime()+24*3600*1000));//把时间设置延后一天 方便数据库比较 2015-02-01  --》2015-02-02
		return fillChartsDate(iAccountStatisticsDao.getMonthStatisticalData(data),data);
	}

	/**
	 * 得到季度统计的数据
	 */
	@Override
	public Map<String, Object> getQuarterStatisticalData(Accountstatistics data) {
		return fillChartsDate(iAccountStatisticsDao.getQuarterStatisticalData(data), data);
	}

	/**
	 * 得到年统计的数据
	 */
	@Override
	public Map<String, Object> getYearStatisticalData(Accountstatistics data) {
		return fillChartsDate(iAccountStatisticsDao.getYearStatisticalData(data), data);
	}

	
	private Map<String, Object> fillChartsDate(List<Map<String, Object>> data,Accountstatistics accountstatistics) {
		/**
		 *  categories: [
                    '2014.4.17',
                    '2014.4.18',
                    '2014.4.19',
                    '2014.4.20',
                    '2014.4.21',
                    '2014.4.22',
                    '2014.4.23'
                ]
                 title: {
                  text: '收入支出统计'
	            },
	            subtitle: {
	                text: '2014年的收入支出统计'
	            },
                
                max:100,
            	min:0,
            	
            	series: [{name: '支出',
            	          data: [48.94, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0]},
            	         {name: '收入', 
            	          data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4] }]
		 */
		Integer accountType = accountstatistics.getType();
		Map<String, Object> result = new TreeMap<>();
		Map<String, Object> series_income = new HashMap<>();
		Map<String, Object> series_outcome = new HashMap<>();
		List<Object> series_income_data = new ArrayList<>();
		List<Object> categories = new ArrayList<>();
		List<Object> series_outcome_data = new ArrayList<>();
		List<Map<String, Object>> series_data = new ArrayList<Map<String, Object>>();
		if (data.size()>0) {
			for(Map<String, Object> maps:data){
				if (maps!=null) {
					for (Map.Entry<String, Object> map : maps.entrySet()) {
						if (accountType==null) {
							if ("income".equals(map.getKey())) {
								series_income.put("name", "收入");
								series_income_data.add(map.getValue());
							}
							if ("outcome".equals(map.getKey())) {
								series_outcome.put("name", "支出");
								series_outcome_data.add(map.getValue());
							}
							if ("date".equals(map.getKey())) {
								categories.add(map.getValue());//x周的数据
							}
						}else{//说明只是单纯的显示收入或者支出
							if (accountType==1) {//收入
								if ("income".equals(map.getKey())) {
									series_income.put("name", "收入");
									series_income_data.add(map.getValue());
								}
							}else{
								if ("outcome".equals(map.getKey())) {
									series_outcome.put("name", "支出");
									series_outcome_data.add(map.getValue());
								}
							}
							if ("date".equals(map.getKey())) {
								categories.add(map.getValue());//x轴的数据
							}
						}
					}
				}
			}
		}
		if(series_income_data.size()>0){
			series_income.put("data", series_income_data);
		}
		if(series_outcome_data.size()>0){
			series_outcome.put("data", series_outcome_data);
		}
		if(series_income.size()>0){
			series_data.add(series_income);
		}
		if(series_outcome.size()>0){
			series_data.add(series_outcome);
		}
		result.put("categories", categories);
		result.put("series", series_data);
		return result;
	}
    
	/**
	 * 封装表格需要的数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageBean fillStatisticalData(Accountstatistics accountstatistics)  {
		Map<String, Object> data = new HashMap<>();
		switch (accountstatistics.getStatisticType()) {
		case 1:
			data = this.getStatisticalData(accountstatistics);
			break;
		case 2:
			data = this.getWeekStatisticalData(accountstatistics);
			break;
		case 3:
			data = this.getMonthStatisticalData(accountstatistics);
			break;
		case 4:
			data = this.getQuarterStatisticalData(accountstatistics);
			break;
		case 5:
			data = this.getYearStatisticalData(accountstatistics);
			break;
		default:
			break;
		}
		/**
		 * {series=[{name=收入, data=[2488.86, 10011.90, 34.00, 6.00, 5000.00, 9999.99]}, 
		 *          {name=支出, data=[56.59, 135.14, 78.20, 78.60, 78.45, 5000.00]}], 
		 * categories=[2015-04-22, 2015-04-23, 2015-04-24, 2015-04-25, 2015-04-26, 2015-04-27]}
		 */
		List<Map<String, Object>> lists = new ArrayList<>();
		for(Map.Entry<String, Object> m : data.entrySet()){
			String key = m.getKey();
			if("categories".equals(key)){
				Map<String, Object> first = new HashMap<>();
				first.put("name", "");
				List<Object> value = (List<Object>) m.getValue();
				for(int i = 0;i<value.size();i++){
					first.put("data"+i, value.get(i));
				}
				lists.add(first);
			}else{
				List<Map<String, Object>> value = (List<Map<String, Object>>) m.getValue();
				for(Map<String, Object> map : value){
					Map<String, Object> first = new HashMap<>();
					for(Map.Entry<String, Object> m1 : map.entrySet()){
						String key1 = m1.getKey();
						if("name".equals(key1)){
							first.put("name", m1.getValue());
						}else{
							List<Object> value1 = (List<Object>) m1.getValue();
							for(int i = 0;i<value1.size();i++){
								first.put("data"+i, value1.get(i));
							}
						}
					}
					lists.add(first);
				}
			}
		}
		PageBean bean = new PageBean();
		bean.setRows(lists);
		bean.setTotal(lists.size());
		return bean;
	}

	/**
	 * 封装excel所需的数据格式
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, List<Object>> filDownLoadData(Accountstatistics accountstatistics) {
		Map<String, Object> data = new HashMap<>();
		switch (accountstatistics.getStatisticType()) {
		case 1:
			data = this.getStatisticalData(accountstatistics);
			break;
		case 2:
			data = this.getWeekStatisticalData(accountstatistics);
			break;
		case 3:
			data = this.getMonthStatisticalData(accountstatistics);
			break;
		case 4:
			data = this.getQuarterStatisticalData(accountstatistics);
			break;
		case 5:
			data = this.getYearStatisticalData(accountstatistics);
			break;
		default:
			break;
		}
		
		/**
		 * {series=[{name=收入, data=[2488.86, 10011.90, 34.00, 6.00, 5000.00, 9999.99]}, 
		 *          {name=支出, data=[56.59, 135.14, 78.20, 78.60, 78.45, 5000.00]}], 
		 * categories=[2015-04-22, 2015-04-23, 2015-04-24, 2015-04-25, 2015-04-26, 2015-04-27]}
		 */
		List<Object> date = new ArrayList<>();//装时间
		List<Object> income = new ArrayList<>();//装收入
		List<Object> outcome = new ArrayList<>();//装支出
		for(Map.Entry<String, Object> m : data.entrySet()){
			String key = m.getKey();
			if("categories".equals(key)){
				List<Object> value = (List<Object>) m.getValue();
				for(int i = 0;i<value.size();i++){
					date.add(value.get(i));
				}
			}else{
				List<Map<String, Object>> value = (List<Map<String, Object>>) m.getValue();
				for(Map<String, Object> map : value){
					Object object = map.get("name");
					if("收入".equals(object.toString())){
						List<Object> object2 = (List<Object>) map.get("data");
						for(Object o : object2){
							income.add(o);
						}
					}
					if("支出".equals(object.toString())){
						List<Object> object2 = (List<Object>) map.get("data");
						for(Object o : object2){
							outcome.add(o);
						}
					}
				}
			}
		}
		Map<String, List<Object>> result = new TreeMap<>();
		if(date.size()>0){
			result.put("date", date);
		}
		if(income.size()>0){
			result.put("income", income);
		}
		if(outcome.size()>0){
			result.put("outcome", outcome);
		}
		return result;
	}

}
