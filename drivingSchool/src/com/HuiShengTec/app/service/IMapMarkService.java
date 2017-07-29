package com.HuiShengTec.app.service;

import java.util.List;
import java.util.Map;

public interface IMapMarkService {

	public List<Map<String, Object>> queryMapMarkInfo();

	public void saveMapMarkInfo(Map<String, Object> paramMap);

	public void deleteMapMarkInfo(Map<String, Object> param);

	public boolean queryMapMarkInfoByConditions(
			Map<String, Object> condition);

	public void updateMapMarkInfo(Map<String, Object> paramMap);

}

