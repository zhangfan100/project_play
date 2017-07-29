package com.HuiShengTec.app.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ISalaryInfoDao;
import com.HuiShengTec.app.service.ISalaryInfoService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.SalaryInfo;
import com.HuiShengTec.utils.Toolkit;
/**
 * 
 * @author wtr
 *
 */
@Service
@Transactional
public class SalaryInfoServiceImpl implements ISalaryInfoService {
	@Autowired
	private ISalaryInfoDao iSalaryInfoDao;
	
	public PageBean querySalaryInfoPage(PageInfo info){
		PageBean bean =Toolkit.fillPageInfo(info);
		bean.setRows(iSalaryInfoDao.querySalaryInfoPage(bean));
		return bean;
	}

	//修改的人员工资
	@Override
	public HashMap<String, Object> editSalaryInfoSubmit(SalaryInfo info,
			Float newCash) {
		//先要验证数据的合法性
		if(!validateData(info,newCash)){
			return Toolkit.getMapStatus(-1);
		}
		//先把现在的记录状态设置为失效
		Map<String, Object> condition  = new HashMap<>();
		condition.put("id", info.getId());
		condition.put("status", "0");
		iSalaryInfoDao.changeStatus(condition);
		info.setCash(newCash);
		info.setStatus(1);
		//插入新的记录
		iSalaryInfoDao.insertSalaryInfo(info);
		return Toolkit.getMapStatus(1);
	}

	//验证数据的合法性
	private boolean validateData(SalaryInfo info, Float newCash) {
		if(info.getId()==null){//前台没有没有传来id
			return false;
		}
		if(newCash==null){
			return false;
		}
		Pattern pattern = Pattern.compile("{0,1}\\d+\\.\\d*|{0,1}\\d*\\.\\d+|[0-9]*"); 
		boolean flag = pattern.matcher(newCash+"").matches();
		if(!flag){//不符合Float类型
			return false;
		}
		Integer salaryType = info.getSalaryType();
		if(salaryType==null){
			return false;
		}else{//如果类型为教练 那么教练id就有 如果为管理员 那么管理员id就应该有
			if(salaryType != 1 && salaryType != 2){
				return false;
			}
			if(salaryType==1){//说明教练 那么教练id就应该有
				if(info.getCoachId()==null){
					return false;
				}
			}else{
				if(info.getAdminId()==null){
					return false;
				}
			}
		}
		return true;
	}
}
