package com.HuiShengTec.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ICampusInfoDao;
import com.HuiShengTec.app.dao.ICoachInfoDao;
import com.HuiShengTec.app.dao.IFroIndexDao;
import com.HuiShengTec.app.dao.IImageDao;
import com.HuiShengTec.app.dao.IStuInfoDao;
import com.HuiShengTec.app.dao.ITestInfoDao;
import com.HuiShengTec.app.service.IFroIndexService;
import com.HuiShengTec.entity.CampusInfo;

@Service
@Transactional
public class FroIndexServiceImpl implements IFroIndexService {
	
	@Autowired
	private IFroIndexDao iFroIndexDao;
	@Autowired
	private ICoachInfoDao iCoachInfoDao;
	@Autowired
	private ICampusInfoDao iCampusInfoDao;
	@Autowired
	private IStuInfoDao iStuInfoDao;
	@Autowired
	private ITestInfoDao iTestInfoDao;
	@Autowired
	private IImageDao iImageDao;
	
	@Override
	public HashMap<String,Object> queryFroIndexData(){
		HashMap<String,Object> result = new HashMap<>();
		List<CampusInfo> campusInfo = iCampusInfoDao.querySeparateSchoolInfo();
		result.put("campusInfo", campusInfo);
		result.put("newStudents", iStuInfoDao.queryNewStudents());
		
		//查询首页大图1，场地图片2、荣誉展示3，图片信息
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("types", new Integer[]{1,2,3});
		result.put("picList", iImageDao.queryImages(param));
		
		return result;
	}
	
	/**
	 * 查询分校对应的教师
	 * @param coachId
	 * @return
	 */
	@Override
	public List<HashMap<String,Object>> queryCoachInfo(Integer campusId){
		return iCoachInfoDao.queryTopScoreCoach(campusId);
	}
	
	/**
	 *  查询分校所在学生
	 * @param campusId
	 * @return
	 */
	@Override
	public List<HashMap<String,Object>> querySchoolTopStu(Integer campusId){
		return iStuInfoDao.querySchoolTopStu(campusId);
	}
	
	/**
	 *  查询所有动态菜单
	 */
	@Override
	public List<Map<String,Object>> queryMenu() {
		List<Map<String,Object>> list = iFroIndexDao.queryMenu();
		String type[] = {"kindName","traiName","title"};
		return recursion(type,0,list);
		
	}
	
	
	//根据类型递归分组
	private List<Map<String,Object>> recursion(String[]type,int n,List<Map<String,Object>> list){
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		LinkedHashMap <String,List<Map<String,Object>>> group = new LinkedHashMap <String, List<Map<String,Object>>>();
		for(int i=0;i<list.size();i++){
			Map<String,Object> item = list.get(i);
			List<Map<String, Object>> l = new ArrayList<Map<String, Object>>();
			l.add(item);
			
			//当在叶子节点上级时，发现叶子节点为非分校，就将该叶子节点提级
			if(n==type.length-2 && ((Integer)item.get("seperateSchoolId"))<=0){
				group.put((String) item.get(type[n+1]), l);
			}else if(group.get(item.get(type[n]))==null){
				group.put((String) item.get(type[n]), l);
			}else{
				group.get(item.get(type[n])).addAll(l);
			}
		}
		
		for(String key:group.keySet()){
			Map<String, Object> result = new HashMap<String, Object>();
			result.put(type[n], key);
			
			//不区分分校情况
			if(n==type.length-2 && (Integer)group.get(key).get(0).get("seperateSchoolId")<=0){
				resultList.add(group.get(key).get(0));
				continue;
			}else if(n<type.length-2){
				result.put("children",recursion(type,n+1,group.get(key)));
			} else if(n==type.length-2){
				result.put("children",group.get(key));
			}
			resultList.add(result);
		}

		return resultList;
	}
}
