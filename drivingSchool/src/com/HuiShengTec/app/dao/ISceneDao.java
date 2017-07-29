package com.HuiShengTec.app.dao;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.entity.Scene;

public interface ISceneDao extends IBaseDao{


	/**
	 * 得到所有的scene
	 * @author zf
	 */
	public List<Map<String,Object>> getAllScenes();

	public Scene queryIdByTitle(Map<String, Object> conditions);

	public Scene querySceneById(Integer scencId);
}

