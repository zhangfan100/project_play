package com.HuiShengTec.app.magAction;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ILoginService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.base.messageConverter.JSONDateOutputMode;
import com.HuiShengTec.utils.Toolkit;

/**
 * 登录日志管理
 * @author mihuajun
 * @createTime 2014-11-24 下午5:57:09
 */
@RequestMapping("/mag")
@Controller
public class SignInLogAction extends BaseAction {
	
	@Autowired
	private ILoginService iLoginService;
	
	/**
	 * 显示登录日志信息
	 * @author mihuajun
	 * @createTime 2014-11-24 下午6:02:02
	 * @return
	 */
	@RequestMapping("signInLogManage")
	public String signInLogManage(){
		return "manage/signInLogAction/signinLog";
	}
	
	/**
	 * 分页显示登录日志
	 * @param info
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/querySignInLogPage")
	@ResponseBody
	public PageBean queryOperationLogPage(PageInfo info,@DateTimeFormat(pattern="yyyy-MM-dd")Date beginDate,@DateTimeFormat(pattern="yyyy-MM-dd")Date endDate) throws IOException{
		session.setAttribute("JSONMode",JSONDateOutputMode.dateTimeMode);
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("beginDate", beginDate);
		pageBean.addConditions("endDate", endDate);
		return iLoginService.querySignLogPage(pageBean);
	}
	
	/**
	 * 根据ID删除登录日志
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delSignInLog")
	@ResponseBody
	public Integer delOperationLog(String ids){
		String[] param = null;
		if(ids!=null)
			param = ids.split(",");
		return iLoginService.delSignInLog(param);
	}
	
}
