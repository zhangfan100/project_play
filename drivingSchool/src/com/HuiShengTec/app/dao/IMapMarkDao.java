package com.HuiShengTec.app.dao;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;

public interface IMapMarkDao extends IBaseDao{

	/**
	 * 查询所有的标注坐标
	 * @author zf
	 */
	public List<Map<String, Object>> queryMapMarkInfo();


	/**
	 * 保存标注的点
	 */
	public void saveMapMarkInfo(Map<String, Object> paramMap);


	/**
	 * 移除标点
	 * @author zf
	 */
	public void deleteMapMarkInfo(Map<String, Object> param);


	/**
	 * 根据经纬度查询
	 * @author zf
	 */
	public Map<String, Object> queryMapMarkInfoByConditions(Map<String, Object> conditions);

	
    /**
     * 更新信息
     * @author zf
     */
	public void updateMapMarkInfo(Map<String, Object> conditions);

}

