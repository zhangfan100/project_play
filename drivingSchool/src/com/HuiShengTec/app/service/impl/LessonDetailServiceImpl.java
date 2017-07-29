package com.HuiShengTec.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ILessonDetailDao;
import com.HuiShengTec.app.service.ILessonDetailService;
import com.HuiShengTec.base.entity.PageBean;
@Service
@Transactional
public class LessonDetailServiceImpl implements ILessonDetailService {
	@Resource
	private ILessonDetailDao iLessonDetailDao;
	
	/**
	 * 培训详细，查看详情
	 * @author mihuajun
	 * @createTime 2014-11-18 下午3:50:32
	 * @return
	 */
	@Override
	public Map<String,Object> queryDetail(Integer id){
		return iLessonDetailDao.queryDetail(id);
	}
	
	@Override
	public PageBean queryByTrainCode(PageBean page) {
		List<HashMap<String, Object>> data =  iLessonDetailDao.queryByTrainCode(page);
		page.setRows(data);
		
		String type[] = {"基础培训","倒车入库","坡道停车和起步","侧方位停车","直角转弯","曲线行驶","单边桥"};
		
		for(HashMap<String,Object> item:data){
			item.put("detailType", type[(Integer)item.get("detailType")]);
		}
		
		return page;
	}
	
	
	@Override
	public PageBean queryByCode(PageBean bean) {
		bean.setRows(iLessonDetailDao.queryByCode(bean));
		return bean;
	}

}
