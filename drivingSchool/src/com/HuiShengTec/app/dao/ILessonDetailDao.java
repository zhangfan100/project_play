package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;

public interface ILessonDetailDao  extends IBaseDao{
	public List<HashMap<String, Object>> queryByTrainCode(PageBean page);
	
	/**
	 * 培训详细，查看详情
	 * @author mihuajun
	 * @createTime 2014-11-18 下午3:51:26
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryDetail(Integer id);
	
	public List<Map<String, Object>> queryByCode(PageBean bean);
}
