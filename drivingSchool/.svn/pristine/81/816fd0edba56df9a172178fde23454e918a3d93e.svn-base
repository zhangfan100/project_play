package com.HuiShengTec.app.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ILessonStatisticsDao;
import com.HuiShengTec.app.service.ILessonStatisticsService;

/**
 *  学员统计
 * @author llj
 *
 */
@Service
@Transactional
public class LessonStatisticsServiceImpl implements ILessonStatisticsService {
	
	@Autowired
	private ILessonStatisticsDao iLessonStatisticsDao;
	
	/**
	 *培训统计
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> queryTrainStatistics(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Map<String, Object>> list = iLessonStatisticsDao.queryTrainStatistics((Integer) param.get("stuId"));
		ArrayList<Object>  times = new ArrayList<Object>();
		HashSet<Object> title = new HashSet<Object>();
		ArrayList<Map<String, Object>> series = new ArrayList<Map<String,Object>>();
		//eg:[{name: 'Tokyo', data: [1,2,6,8]}，{name: 'Tokyo', data: [0,0,0,8]}
		
		//初始化
		for(int i=0;i<7;i++){
			Map<String,Object> currReItem = new HashMap<String, Object>();
			currReItem = new HashMap<String, Object>();
			currReItem.put("data", new ArrayList<Double>());
			currReItem.put("name", i);
			currReItem.put("pointer", 0l);	//添加一个指针，用于描述当前列表位置
			series.add(currReItem);
		}
		
		
		for(Map<String, Object> item:list){
			
			//获取最近七天对应的日期
			if(!title.contains(item.get("rownum"))){
				times.add(item.get("time"));
			}
			title.add(item.get("rownum"));
			
			
			if(item.get("traiItem")==null)continue;
			
			
			Map<String, Object> currReItem = null;
			for(Map<String, Object> item2:series){
				if(item2.get("name").equals(item.get("traiItem"))){
					currReItem = item2;
					break;
				}
			}
			
			ArrayList<Double> datas = (ArrayList<Double>) currReItem.get("data");
			//如果当前第n次课程减1大于上一次记录的pointer，则表示第n次课程前存在空缺，需要data前补0
			if(((long)item.get("rownum")-1)>(long)currReItem.get("pointer")){
				long len = (long)item.get("rownum")-(long)currReItem.get("pointer");
				for(int i=1;i<len;i++){
					datas.add(0.0);
				}
			}

			datas.add(((BigDecimal)item.get("passRate")).doubleValue());
			currReItem.put("pointer", item.get("rownum"));
		}
		
		//data后补0
		for(Map<String, Object> item :series){
			ArrayList<Double> datas = (ArrayList<Double>) item.get("data");
			int len = title.size()-datas.size();
			if(len>0)
				for(int i=0;i<len;i++){datas.add(0.0);}
		}
		
		result.put("times", times);
		result.put("series", series);
		
		return result;
	}
	
	/**
	 * 培训学时统计
	 */
	@Override
	public List<Map<String, Object>> queryPeriodStatistics(Map<String, Object> param) {
		// 
		List<Map<String, Object>>  list = iLessonStatisticsDao.queryPeriodStatistics((Integer) param.get("stuId"));
		for(int i=0;i<4;i++){
			Map<String,Object> currItem = null;
			for(Map<String,Object> item:list){
				if(item.get("subject").equals(i)){
					currItem = item;
					break;
				}
			}
			if(currItem==null){
				currItem = new HashMap<String, Object>();
				currItem.put("subject", i);
				currItem.put("total", 0);
				list.add(currItem);
			}
		}
		return list;
	}
	
	/**
	 * 统计学员各项目通过率，制成表格
	 */
	@Override
	public List<Map<String, Object>> queryTrainStatisticsTable(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		return iLessonStatisticsDao.queryTrainStatisticsTable((Integer) param.get("stuId"));
	}
	
	
	
	
}
