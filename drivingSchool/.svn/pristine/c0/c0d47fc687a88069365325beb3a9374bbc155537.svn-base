/**********************************************************************   
 * <p>文件名：MobLotteryinfoAction.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：drivingSchool
 * @author mihuajun  
 * @date 2014年12月25日 下午5:06:08 
 * @history
 * @department：慧莘软件部
 * Copyright ChengDu Huishen Technology Development CO.,LTD 2014
 * All Rights Reserved.
*/
package com.HuiShengTec.app.mobileStuAction;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ILotteryInfoService;

/******************************************************************************
 * @Package:      [com.HuiShengTec.app.mobileStuAction.MobLotteryinfoAction.java]  
 * @ClassName:    [MobLotteryinfoAction]   
 * @Description:  [手机端抽奖信息]   
 * @Author:       [llj]   
 * @CreateDate:   [2014年12月25日 下午5:06:08] 
 * @Version:      [v1.0] 
 */
@RequestMapping("mobile")
@Controller
public class MobLotteryinfoAction extends BaseAction{
	
	@Autowired
	private ILotteryInfoService iLotteryInfoService;
	
	/**
	 * 
	 * @Title: queryLotteryinfo
	 * @Description: TODO(获取活动信息)
	 * @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("queryLotteryinfo")
	public Map<String, Object> queryLotteryinfo(){
		return iLotteryInfoService.queryStuLotteryInfo(getCurrLoginStudent());
	}
	
	

}
