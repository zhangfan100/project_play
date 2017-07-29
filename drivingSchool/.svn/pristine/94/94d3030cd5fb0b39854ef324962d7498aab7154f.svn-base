package com.HuiShengTec.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ISceneDao;
import com.HuiShengTec.app.service.ISceneService;

@Service
@Transactional
public class ISceneServiceImpl implements ISceneService {

	@Autowired
	private ISceneDao iSceneDao;
	
	@Override
	public List<Map<String, Object>> getAllScenes() {
		return iSceneDao.getAllScenes();
	}

	@Override
	public Integer queryIdByTitle(Map<String, Object> conditions) {
		return iSceneDao.queryIdByTitle(conditions).getId();
	}

}

