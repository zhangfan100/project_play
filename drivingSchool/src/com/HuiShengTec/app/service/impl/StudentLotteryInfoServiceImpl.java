/**********************************************************************   
 * <p>文件名：StudentLotteryInfoServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：drivingSchool
 * @author mihuajun  
 * @date 2014年12月24日 下午8:05:43 
 * @history
 * @department：慧莘软件部
 * Copyright ChengDu Huishen Technology Development CO.,LTD 2014
 * All Rights Reserved.
*/
package com.HuiShengTec.app.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ILotteryInfoDao;
import com.HuiShengTec.app.dao.IPrizeInfoDao;
import com.HuiShengTec.app.dao.IStudentLotteryInfoDao;
import com.HuiShengTec.app.service.IStudentLotteryInfoService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.LotteryInfo;
import com.HuiShengTec.entity.PrizeInfo;
import com.HuiShengTec.entity.StudentInfo;
import com.HuiShengTec.entity.StudentLotteryInfo;
import com.HuiShengTec.utils.Toolkit;

/******************************************************************************
 * @Package:      [com.HuiShengTec.app.service.impl.StudentLotteryInfoServiceImpl.java]  
 * @ClassName:    [StudentLotteryInfoServiceImpl]   
 * @Description:  [抽奖记录]   
 * @Author:       [llj]   
 * @CreateDate:   [2014年12月24日 下午8:05:43] 
 * @Version:      [v1.0] 
 */
@Service
@Transactional
public class StudentLotteryInfoServiceImpl implements IStudentLotteryInfoService{
	
	@Autowired
	private IStudentLotteryInfoDao iStudentLotteryInfoDao;
	@Autowired
	private ILotteryInfoDao iLotteryInfoDao;
	@Autowired
	private IPrizeInfoDao iPrizeInfoDao;

	@Override
	public PageBean querystudentLotteryInfoPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setRows(iStudentLotteryInfoDao.querystudentLotteryInfoPage(pageBean));
		return pageBean;
	}
	

	/**
	 * 获取奖品列表
	 */
	@Override
	public List<HashMap<String, Object>> queryPrizeInfoList(StudentInfo stuInfo) {
		// TODO Auto-generated method stub
		return iPrizeInfoDao.queryPrizeInfoList(stuInfo.getId());
	}

	
	/**
	 * 抽奖主方法
	 * @return
	 * status-2 抽奖信息非法
	 * status-3 抽奖未开始
	 * status-4 抽奖已结束
	 */
	public HashMap<String, Object> doLottery(StudentInfo stuInfo,Integer lotteryInfoId){
		//读取抽奖信息是否合法
		LotteryInfo lotteryInfo  = iLotteryInfoDao.queryLotteryInfoById(lotteryInfoId);
		Date currTime = null;
		if(Toolkit.isEmpty(lotteryInfo)){
			//不合法
			return Toolkit.getMapStatus(2);
		}else{
			currTime=new Date();
			//判断抽奖期限
			if(currTime.before(lotteryInfo.getBeginTime())){
				//未到期现
				return Toolkit.getMapStatus(3);
			}else if(currTime.after(lotteryInfo.getEndTime())){
				//已过期
				return Toolkit.getMapStatus(4);
			}
		}
		StudentLotteryInfo slInfo  = new StudentLotteryInfo();
		slInfo.setCreateTime(currTime);
		slInfo.setLotteryId(lotteryInfoId);
		slInfo.setStuId(stuInfo.getId());
		PrizeInfo prize = this.randomPrize(stuInfo, lotteryInfoId);
		prize.setPrizeCount(null);
		HashMap<String, Object> result = Toolkit.getMapStatus(1);
		result.put("prizeInfo", prize);
		return result;
	}
	/**
	 * 随机抽奖
	 * @return
	 */
	private PrizeInfo randomPrize(StudentInfo stuInfo,Integer lotteryInfoId){
		//查询奖品信息
		List<PrizeInfo> list = iPrizeInfoDao.queryPrizeListByLotteryId(lotteryInfoId);
		//计算奖品总数区间
		Integer total =0;
		for (PrizeInfo prizeInfo : list) {
			total+=prizeInfo.getPrizeCount();
		}
		//随机奖品占位
		Random r =new Random();
		Long l = Math.round(r.nextDouble()*total);
		Integer randomResult = l.intValue();
		if(randomResult.equals(0)){
			randomResult=1;
		}
		//判断奖品
		Integer flag =0;
		PrizeInfo result = null;
		for (PrizeInfo prizeInfo : list) {
			flag+=prizeInfo.getPrizeCount();
			if(randomResult<=flag){
				//区间中奖
				result=prizeInfo;
				if(prizeInfo.getType()==1){
					iPrizeInfoDao.prizeCountMinus(prizeInfo.getId());
				}
				StudentLotteryInfo studentLotteryInfo = new StudentLotteryInfo();
				studentLotteryInfo.setLotteryId(lotteryInfoId);
				studentLotteryInfo.setPrizeId(prizeInfo.getId());
				studentLotteryInfo.setStuId(stuInfo.getId());
				studentLotteryInfo.setStuLotteryCode(iLotteryInfoDao.queryStuLotteryCode());
				iStudentLotteryInfoDao.addStudentLotteryInfo(studentLotteryInfo);
				break;
			}
		}
		return result;
	}


	@Override
	public Integer editStudentLotteryStatus(StudentLotteryInfo info) {
		// TODO Auto-generated method stub
		return iStudentLotteryInfoDao.editStudentLotteryStatus(info)>0?0:1;
	}


}
