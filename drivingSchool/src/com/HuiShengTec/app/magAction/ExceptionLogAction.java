package com.HuiShengTec.app.magAction;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.IExceptionLogService;
import com.HuiShengTec.base.action.BaseAction;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.base.messageConverter.JSONDateOutputMode;
import com.HuiShengTec.entity.ExceptionLog;
import com.HuiShengTec.utils.Toolkit;

/**
 * 日志管理
 * @author mihuajun
 *
 */
@RequestMapping("/mag")
@Scope("prototype")
@Controller
public class ExceptionLogAction extends BaseAction {
	
	@Autowired
	private IExceptionLogService logService;
	
	/**
	 * 跳转至异常日志页面
	 * @return
	 */
	@RequestMapping("/exceptionLogManage")
	public String view(){
		return "manage/exceptionLogAction/exceptionLog";
	}
	
	/**
	 * 分页显示异常日志
	 * @param info
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/queryExceptionLogPage")
	@ResponseBody
	public PageBean queryExceptionLogPage(PageInfo info,@DateTimeFormat(pattern="yyyy-MM-dd")Date beginDate,@DateTimeFormat(pattern="yyyy-MM-dd")Date endDate) throws IOException{
		session.setAttribute("JSONMode",JSONDateOutputMode.dateTimeMode);
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("beginDate", beginDate);
		pageBean.addConditions("endDate", endDate);
		return logService.queryExceptionLogPage(pageBean);
	}
	
	/**
	 * 根据ID删除系统异常
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delExceptionLog")
	@ResponseBody
	public Integer delExceptionLog(String ids){
		String[] param = null;
		if(ids!=null)
			param = ids.split(",");
		return logService.delExceptionLog(param);
	}
	
	/**
	 * 根据ID，查询异常信息
	 */
	@RequestMapping("queryExceptionLogById")
	@ResponseBody
	public ExceptionLog queryExceptionLogById(Integer id) {
		// TODO Auto-generated method stub
		session.setAttribute("JSONMode",JSONDateOutputMode.dateTimeMode);
		return logService.queryExceptionLogById(id);
	}
}
