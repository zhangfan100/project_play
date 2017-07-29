package com.HuiShengTec.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IIncomeItemDao;
import com.HuiShengTec.app.service.IIncomeItemService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.IncomeItem;

@Service
@Transactional
public class IncomeItemServiceImpl implements IIncomeItemService {

	@Autowired
	private IIncomeItemDao iIncomeItemDao;
	
	@Override
	public PageBean queryAllIncomeItem(PageBean pageBean) {
		pageBean.setRows(iIncomeItemDao.queryAllIncomeItem(pageBean));
		return pageBean;
	}
	
	@Override
	public Map<String, Object> queryIncomeItemById(Integer id) {
		return iIncomeItemDao.queryIncomeItemById(id);
	}
	

	@Override
	public void addIncomeItem(IncomeItem incomeItem) {
		iIncomeItemDao.addIncomeItem(incomeItem);
	}

	@Override
	public void delIncomeItems(String idStr) {
		String[] ids = idStr.split(",");
		List<Integer> list = new ArrayList<>();
		for(String id:ids){
			list.add(Integer.parseInt(id));
		}
		iIncomeItemDao.delIncomeItems(list);
	}

	@Override
	public void updateIncomeItem(IncomeItem incomeItem) {
        iIncomeItemDao.updateIncomeItem(incomeItem);
	}

	/**
	 * 根据关键字查找项目
	 */
	@Override
	public List<HashMap<String, Object>> queryItemByKeyWord(String keyWord) {
		HashMap<String, Object> condition = new HashMap<String,Object>();
		condition.put("keyWord", keyWord);
		return iIncomeItemDao.queryItemByKeyWord(condition);
	}

}
