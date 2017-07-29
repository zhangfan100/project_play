package com.HuiShengTec.base.taskJob;


import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.HuiShengTec.app.service.IMonthTotalPriceService;
import com.HuiShengTec.app.service.IPriceService;

/**
 * 定时任务
 */
public class TaskJobSyncImg {
	@Autowired
	private IPriceService iPriceService;
	
	@Autowired
	private IMonthTotalPriceService iMonthTotalPriceService;
	
	/**
	 * 每天晚上0时执行计划任务
	 */
	@Scheduled(cron = "0 0 0 * * ?")
	public void job(){
    }
	
	/**
	 * 价格计划生成
	 */
	@Scheduled(cron = "0 0 2 * * ?")
	public void job2(){
//		iPriceService.updatePrice();
	}
	
	/**
	 * 对价格数据进行补全 每天晚上2点补全数据
	 * @throws ParseException 
	 */
	@Scheduled(cron = "0 0 2 * * ?")
	public void job3() throws ParseException{
		iMonthTotalPriceService.fillData();
	}
}
