/**********************************************************************   
 * <p>文件名：PrizeInfoAction.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：drivingSchool
 * @author mihuajun  
 * @date 2014年12月25日 下午2:41:55 
 * @history
 * @department：慧莘软件部
 * Copyright ChengDu Huishen Technology Development CO.,LTD 2014
 * All Rights Reserved.
*/
package com.HuiShengTec.app.magAction;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.IPrizeInfoService;
import com.HuiShengTec.base.annotation.Token;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.base.messageConverter.JSONDateOutputMode;
import com.HuiShengTec.entity.PrizeInfo;
import com.HuiShengTec.utils.Toolkit;

/******************************************************************************
 * @Package:      [com.HuiShengTec.app.magAction.PrizeInfoAction.java]  
 * @ClassName:    [PrizeInfoAction]   
 * @Description:  [奖品]   
 * @Author:       [llj]   
 * @CreateDate:   [2014年12月25日 下午2:41:55] 
 * @Version:      [v1.0] 
 */
@Controller
@Scope("prototype")
@RequestMapping("mag")
public class PrizeInfoAction extends BaseAction{
	
	@Autowired
	private IPrizeInfoService iPrizeInfoService;
	
	@RequestMapping("addPrizeInfo")
	@Token(addToken=true)
	public String addPrizeInfo(){
		return "manage/lotteryInfoAction/addPrizeInfo";
	}
	
	@RequestMapping("queryPrizeInfo")
	@ResponseBody
	public PageBean queryPrizeInfo(PageInfo info,@DateTimeFormat(pattern="yyyy-MM-dd")Date beginDate,@DateTimeFormat(pattern="yyyy-MM-dd")Date endDate,String keyWord){
		session.setAttribute("JSONMode",JSONDateOutputMode.dateTimeMode);
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("beginDate",beginDate );
		pageBean.addConditions("endDate",endDate );
		pageBean.addConditions("keyWord", keyWord);
		return iPrizeInfoService.queryPrizeInfo(pageBean);
	}
	
	/**
	 * 修改抽奖详情
	 * @return
	 */
	@RequestMapping("editPrizeInfo")
	@Token(addToken=true)
	public String editPrizeInfo(Integer id,Model model){
		model.addAttribute("record",iPrizeInfoService.queryPrizeInfoId(id));
		return "manage/lotteryInfoAction/editPrizeInfo";
	}
	
	/**
	 * 
	 * @Title: editPrizeInfoSubmit
	 * @Description: TODO(修改提交)
	 * @param info
	 * @return    设定文件
	 * @return Integer    返回类型
	 * @throws
	 */
	@RequestMapping("editPrizeInfoSubmit")
	@ResponseBody
	@Token(delToken=true)
	public Integer editPrizeInfoSubmit(PrizeInfo info){
		return iPrizeInfoService.editPrizeInfoSubmit(info);
	}
	
	/**
	 * 
	 * @Title: addPrizeInfoSubmit
	 * @Description: TODO(添加提交)
	 * @return    设定文件
	 * @return Integer    返回类型
	 * @throws
	 */
	@RequestMapping("addPrizeInfoSubmit")
	@ResponseBody
	@Token(delToken=true)
	public Integer addPrizeInfoSubmit(PrizeInfo info){
		return iPrizeInfoService.addPrizeInfoSubmit(info);
	}
	
	
	

}
