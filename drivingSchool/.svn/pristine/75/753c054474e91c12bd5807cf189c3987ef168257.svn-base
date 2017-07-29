package com.HuiShengTec.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ITimePriceDao;
import com.HuiShengTec.app.service.ITimePriceService;
import com.HuiShengTec.entity.TimePrice;

@Service
@Transactional
public class TimePriceServiceImpl implements ITimePriceService {

	@Autowired
	private ITimePriceDao iTimePriceDao;
	
	public List<TimePrice> queryUsedTimePrice(){
		return iTimePriceDao.queryCurrTimePriceList();
	}
}
