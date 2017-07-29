/**********************************************************************   
 * <p>文件名：LotteryInfoAction.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：drivingSchool
 * @author mihuajun  
 * @date 2014年12月25日 上午11:35:47 
 * @history
 * @department：慧莘软件部
 * Copyright ChengDu Huishen Technology Development CO.,LTD 2014
 * All Rights Reserved.
*/
package com.HuiShengTec.app.magAction;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ILotteryInfoService;
import com.HuiShengTec.base.annotation.Token;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.base.messageConverter.JSONDateOutputMode;
import com.HuiShengTec.entity.LotteryInfo;
import com.HuiShengTec.utils.Toolkit;

/******************************************************************************
 * @Package:      [com.HuiShengTec.app.magAction.LotteryInfoAction.java]  
 * @ClassName:    [LotteryInfoAction]   
 * @Description:  [抽奖管理]   
 * @Author:       [llj]   
 * @CreateDate:   [2014年12月25日 上午11:35:47] 
 * @Version:      [v1.0] 
 */
@Controller
@Scope("prototype")
@RequestMapping("mag")
public class LotteryInfoAction extends BaseAction{
	
	@Autowired
	private ILotteryInfoService iLotteryInfoService;
	
	/**
	 * 
	 * @Title: lotteryInfoManage
	 * @Description: TODO(抽奖跳转)
	 * @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping("lotteryInfoManage")
	public String lotteryInfoManage(){
		return "manage/lotteryInfoAction/lotteryInfoManage";
	}
	
	@RequestMapping("addLottery")
	@Token(addToken=true)
	public String addLottery(){
		return "manage/lotteryInfoAction/addLottery";
	}
	
	/**
	 * 分页查询抽奖信息
	 */
	@RequestMapping("queryLotteryInfoPage")
	@ResponseBody
	public PageBean queryLotteryInfoPage(PageInfo info,@DateTimeFormat(pattern="yyyy-MM-dd")Date beginDate,@DateTimeFormat(pattern="yyyy-MM-dd")Date endDate,String keyWord){
		session.setAttribute("JSONMode",JSONDateOutputMode.dateTimeMode);
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("beginDate",beginDate );
		pageBean.addConditions("endDate",endDate );
		pageBean.addConditions("keyWord", keyWord);
		return iLotteryInfoService.queryLotteryInfoPage(pageBean);
	}
	/**
	 * 修改抽奖详情
	 * @return
	 */
	@RequestMapping("editLottery")
	@Token(addToken=true)
	public String editLottery(Integer id,Model model){
		model.addAttribute("record",iLotteryInfoService.queryLotteryInfoId(id));
		return "manage/lotteryInfoAction/editLottery";
	}
	
	/**
	 * 修改抽奖详情
	 * @return
	 */
	@RequestMapping("editLotterySubmit")
	@ResponseBody
	@Token(delToken=true)
	public Integer editLotterySubmit(LotteryInfo info){
		return iLotteryInfoService.editLotterySubmit(info);
	}
	
	
	
	/**
	 * 查询活动
	 */
	@RequestMapping("queryLotteryInfo")
	@ResponseBody
	public List<LotteryInfo> queryLotteryInfo(){
		return iLotteryInfoService.queryLotteryInfo();
	}
	
	/**
	 * 
	 * @Title: addLotteryInfoSubmit
	 * @Description: TODO(添加抽奖信息)
	 * @return    设定文件
	 * @return Integer    返回类型
	 * @throws
	 */
	@RequestMapping("addLotteryInfoSubmit")
	@ResponseBody
	@Token(delToken=true)
	public Integer addLotteryInfoSubmit(LotteryInfo info,Integer roleId){
		if(Toolkit.isEmpty(info.getStatus())){
			info.setStatus(0);
		}
		return iLotteryInfoService.addLotteryInfoSubmit(info,roleId);
	}
	
	/**
	 * 启用禁用状态
	 */
	@RequestMapping("editLotteryStatus")
	@ResponseBody
	public Integer editLotteryStatus(LotteryInfo info){
		info.setStatus(info.getStatus()==1?0:1);
		return iLotteryInfoService.editLotteryStatus(info);
	}
}
