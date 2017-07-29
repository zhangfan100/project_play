package com.HuiShengTec.app.service;

import java.util.Map;

import com.HuiShengTec.base.entity.PageBean;

public interface ILessonDetailService {
	public PageBean queryByTrainCode(PageBean page);

	Map<String, Object> queryDetail(Integer id);

	PageBean queryByCode(PageBean bean);
}
