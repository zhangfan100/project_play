package com.HuiShengTec.app.service;

import java.util.List;
import java.util.Map;

public interface ISceneService {

	//查询所有的
	public List<Map<String, Object>> getAllScenes();

	/**
	 * 通过title得到具体id
	 * @author zf
	 */
	public Integer queryIdByTitle(Map<String,Object> conditions);
}

