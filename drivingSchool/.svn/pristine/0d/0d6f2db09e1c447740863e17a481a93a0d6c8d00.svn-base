package com.HuiShengTec.app.magAction;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ISalaryInfoService;
import com.HuiShengTec.base.annotation.Token;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.SalaryInfo;

/**
 * 工资管理
 * @author wtr
 *
 */
@Controller
@RequestMapping("mag")
@Scope("prototype")
public class SalaryInfoAction extends BaseAction{
	@Autowired
	private ISalaryInfoService iSalaryInfoService;

	/**
	 * 人员工资管理
	 * @return
	 */
	@RequestMapping("salaryInfoManage")
	public String salaryInfoManage(){
		return "manage/salaryInfoAction/salaryInfoManage";
	}
	
	/**
	 * 分页查询人员工资  模糊查询姓名
	 * @param info
	 * @return
	 */
	@ResponseBody
	@RequestMapping("querySalaryInfoPage")
	public PageBean querySalaryInfoPage(PageInfo info,String q,Integer infoType,Integer userId){
		info.addConditions("keyWord", q);
		info.addConditions("infoType", infoType);
		info.addConditions("userId", userId);
		return iSalaryInfoService.querySalaryInfoPage(info);
	}
	
	/**
	 * 人员工资修改跳转
	 * @return
	 */
	@RequestMapping("editSalaryInfo")
	@Token(addToken=true)
	public String editSalaryInfo(Integer infoType,Integer id){
		pushRequestValue("infoType", infoType);
		pushRequestValue("id", id);
		return "manage/salaryInfoAction/editSalaryInfo";
	}
	
	/**
	 * 人员工资修改提交
	 * @return
	 */
	@Token(delToken=true)
	@ResponseBody
	@RequestMapping("editSalaryInfoSubmit")
	public HashMap<String, Object> editSalaryInfoSubmit(SalaryInfo info,Float newCash){
		return iSalaryInfoService.editSalaryInfoSubmit(info,newCash);
	}
	
}
