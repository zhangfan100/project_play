package com.HuiShengTec.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IMapMarkDao;
import com.HuiShengTec.app.dao.ISceneDao;
import com.HuiShengTec.app.service.IMapMarkService;
import com.HuiShengTec.entity.Scene;

@Service
@Transactional
public class MapMarkServiceImpl implements IMapMarkService {

	@Autowired
	private IMapMarkDao iMapMarkDao;
	@Autowired
	private ISceneDao iSceneDao;
	
	
	/**
	 * 查询所有的标注坐标
	 */
	@Override
	public List<Map<String, Object>> queryMapMarkInfo() {
		List<Map<String, Object>> mapMarkInfos = iMapMarkDao.queryMapMarkInfo();
		for(Map<String, Object> map : mapMarkInfos){
			Integer scencId = Integer.parseInt(map.get("sceneId").toString());
			Scene scene = iSceneDao.querySceneById(scencId);
			map.put("title", scene.getTitle());
		}
		return mapMarkInfos;
	}


	/**
	 * 保存标注的点
	 */
	@Override
	public void saveMapMarkInfo(Map<String, Object> paramMap) {
		iMapMarkDao.saveMapMarkInfo(paramMap);
	}


	/**
	 * 移除坐标点
	 */
	@Override
	public void deleteMapMarkInfo(Map<String, Object> param) {
		iMapMarkDao.deleteMapMarkInfo(param);
	}


	/**
	 * 根据经纬度查询 没有结果返回false 有结果返回true
	 */
	@Override
	public boolean queryMapMarkInfoByConditions(
			Map<String, Object> conditions) {
		Map<String, Object> map = iMapMarkDao.queryMapMarkInfoByConditions(conditions);
		if(map!=null){
			if(map.size()>0){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}


	/**
	 * 根据经纬度更新
	 */
	@Override
	public void updateMapMarkInfo(Map<String, Object> paramMap) {
		iMapMarkDao.updateMapMarkInfo(paramMap);
	}

}

