/**********************************************************************   
 * <p>文件名：StudentLotteryInfoAction.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：drivingSchool
 * @author mihuajun  
 * @date 2014年12月24日 下午7:48:27 
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.IStudentLotteryInfoService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.base.messageConverter.JSONDateOutputMode;
import com.HuiShengTec.entity.StudentLotteryInfo;
import com.HuiShengTec.utils.Toolkit;

/******************************************************************************
 * @Package:      [com.HuiShengTec.app.magAction.StudentLotteryInfoAction.java]  
 * @ClassName:    [StudentLotteryInfoAction]   
 * @Description:  [抽奖记录]   
 * @Author:       [llj]   
 * @CreateDate:   [2014年12月24日 下午7:48:27] 
 * @Version:      [v1.0] 
 */
@Controller
@Scope("prototype")
@RequestMapping("mag")
public class StudentLotteryInfoAction extends BaseAction{

	@Autowired
	private IStudentLotteryInfoService iStudentLotteryInfoService;

	/*活动信息记录-》奖品管理
	活动参与记录管理*/

	/**
	 * 
	 * @Title: studentLotteryInfoManage
	 * @Description: TODO(抽奖跳转)
	 * @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping("studentLotteryInfoManage")
	public String studentLotteryInfoManage(){
		return "manage/studentLotteryInfoAction/studentLotteryInfoManage";
	}

	/**
	 * 
	 * @Title: querystudentLotteryInfoPage
	 * @Description: TODO(分页查询抽奖记录)
	 * @param info
	 * @param keyWords
	 * @return    设定文件
	 * @return PageBean    返回类型
	 * @throws
	 */
	@RequestMapping("querystudentLotteryInfoPage")
	@ResponseBody
	public PageBean querystudentLotteryInfoPage(PageInfo info,@DateTimeFormat(pattern="yyyy-MM-dd")Date beginDate,@DateTimeFormat(pattern="yyyy-MM-dd")Date endDate,String keyWord){
		session.setAttribute("JSONMode",JSONDateOutputMode.dateTimeMode);
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("beginDate",beginDate );
		pageBean.addConditions("endDate",endDate );
		pageBean.addConditions("keyWord", keyWord);
		return iStudentLotteryInfoService.querystudentLotteryInfoPage(pageBean);
	}
	
	@RequestMapping("editStudentLotteryStatus")
	@ResponseBody
	public Integer editStudentLotteryStatus(StudentLotteryInfo info){
		info.setStatus(info.getStatus()==0?1:0);
		return iStudentLotteryInfoService.editStudentLotteryStatus(info);
	}
	
	
	
	
}
