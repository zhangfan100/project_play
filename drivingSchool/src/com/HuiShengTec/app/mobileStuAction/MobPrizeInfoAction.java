/**********************************************************************   
 * <p>文件名：MobPrizeInfoAction.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：drivingSchool
 * @author mihuajun  
 * @date 2014年12月25日 下午8:15:31 
 * @history
 * @department：慧莘软件部
 * Copyright ChengDu Huishen Technology Development CO.,LTD 2014
 * All Rights Reserved.
*/
package com.HuiShengTec.app.mobileStuAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.IStudentLotteryInfoService;

/******************************************************************************
 * @Package:      [com.HuiShengTec.app.mobileStuAction.MobPrizeInfoAction.java]  
 * @ClassName:    [MobPrizeInfoAction]   
 * @Description:  [获取奖品]   
 * @Author:       [llj]   
 * @CreateDate:   [2014年12月25日 下午8:15:31] 
 * @Version:      [v1.0] 
 */
@RequestMapping("mobile")
@Controller
public class MobPrizeInfoAction extends BaseAction{
	
	@Autowired
	private IStudentLotteryInfoService iStudentLotteryInfoService;
	
	/**
	 * 
	 * @Title: queryPrizeInfo
	 * @Description: TODO(获取奖品抽奖)
	 * @param lotteryInfoId
	 * @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	@RequestMapping("queryPrizeInfo")
	@ResponseBody
	public Map<String, Object> queryPrizeInfo(Integer lotteryInfoId ){
		return iStudentLotteryInfoService.doLottery(getCurrLoginStudent(), lotteryInfoId);
	}
	
	/**
	 * 
	 * @Title: queryPrizeInfoList
	 * @Description: TODO(获取奖品列表)
	 * @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	@RequestMapping("queryPrizeInfoList")
	@ResponseBody
	public List<HashMap<String, Object>> queryPrizeInfoList(){
		return iStudentLotteryInfoService.queryPrizeInfoList(getCurrLoginStudent());
	}
	
	

}
