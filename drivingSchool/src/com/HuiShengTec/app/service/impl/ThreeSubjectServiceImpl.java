package com.HuiShengTec.app.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IThreeSubjectDao;
import com.HuiShengTec.app.service.IThreeSubjectService;

@Service
@Transactional
public class ThreeSubjectServiceImpl implements IThreeSubjectService{

	
	@Autowired
	private IThreeSubjectDao iThreeSubjectDao;
	
	@Override
	public Map<String, Object> querySceneMark(Map<String, Object> param) {
		Map<String, Object> mark = iThreeSubjectDao.querySceneMark(param);
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("data", mark);
		result.put("code", 0);
		return result;
	}

}
