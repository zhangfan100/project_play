package com.HuiShengTec.app.magAction;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.IOperationLogService;
import com.HuiShengTec.base.action.BaseAction;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.base.messageConverter.JSONDateOutputMode;
import com.HuiShengTec.utils.Toolkit;

/**
 * 操作日志
 * @author mihuajun
 *
 */
@Controller
@RequestMapping("/mag")
@Scope("prototype")
public class OperationLogAction extends BaseAction {
	
	@Autowired
	private IOperationLogService logService;
	
	/**
	 * 跳转至操作日志页面
	 * @return
	 */
	@RequestMapping("/operationLogManage")
	public String view(){
		return "manage/operationLogAction/operationLog";
	}
	
	/**
	 * 分页显示操作日志
	 * @param info
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/queryOperationLogPage")
	@ResponseBody
	public PageBean queryOperationLogPage(PageInfo info,@DateTimeFormat(pattern="yyyy-MM-dd")Date beginDate,@DateTimeFormat(pattern="yyyy-MM-dd")Date endDate) throws IOException{
		session.setAttribute("JSONMode",JSONDateOutputMode.dateTimeMode);
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("beginDate", beginDate);
		pageBean.addConditions("endDate", endDate);
		return logService.queryOperationLogPage(pageBean);
	}
	
	/**
	 * 根据ID删除操作日志
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delOperationLog")
	@ResponseBody
	public Integer delOperationLog(String ids){
		String[] param = null;
		if(ids!=null)
			param = ids.split(",");
		return logService.delOperationLog(param);
	}
	
}
