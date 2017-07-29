package com.HuiShengTec.app.magAction;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.IFinancialService;
import com.HuiShengTec.app.service.ISysAdminInfoService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.base.messageConverter.JSONDateOutputMode;
import com.HuiShengTec.entity.SalaryLog;
import com.HuiShengTec.utils.Toolkit;

@Controller
@Scope("prototype")
@RequestMapping("mag")
public class FinancialAction extends BaseAction {

	
	@Autowired
	private IFinancialService iFinancialService;
	@Autowired
	private ISysAdminInfoService iSysAdminInfoService;
	
	/**
	 * 根据关键字管理员
	 * @param q
	 * @return
	 */
	@ResponseBody
	@RequestMapping("querySysByKeyWord")
	public PageBean querySysByKeyWord(PageInfo info,String q) {
		PageBean bean = Toolkit.fillPageInfo(info);
		bean.addConditions("keyWord", q);
		return iSysAdminInfoService.querySysByKeyWord(bean);
	}
	
	/**
	 * 填充发放工资具体详情
	 * * @author [zf]
	 */
	@ResponseBody
	@RequestMapping("fillFinancialDetail")
	public PageBean fillFinancialDetail(PageInfo info ,SalaryLog salaryLog) {
		PageBean bean = Toolkit.fillPageInfo(info);
		Integer type = salaryLog.getType();
		bean.addConditions("type", type);
		if(type==1){
			bean.addConditions("coachId", salaryLog.getCoachId());
		}else{
			bean.addConditions("adminId", salaryLog.getAdminId());
		}
		return iFinancialService.fillFinancialDetail(bean);
	}
	
	/**
	 * 跳转到工资发放日志页面
	 * @return
	 */
	@RequestMapping("paymentAccountLog")
	public String paymentAccountLog(){
		return "manage/financialAction/financialLog";
	}
	
	/**
	 * 转到工资发放页面
	 * @return
	 */
	@RequestMapping("paymentAccount")
	public String paymentAccount(){
		return "manage/financialAction/paymentAccountPage";
	}
	
	/**
	 * 得到具体的工资发放日志
	 * @return
	 */
	@ResponseBody   
	@RequestMapping("paymentAccountLogPage")
	public PageBean paymentAccountLogPage(PageInfo info,@DateTimeFormat(pattern="yyyy-MM-dd")Date beginDate,@DateTimeFormat(pattern="yyyy-MM-dd")Date endDate){
		JSONDateOutputMode.setJSONDateToTimeMode();
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("beginDate", beginDate);
		pageBean.addConditions("endDate", endDate);
		return iFinancialService.getPaymentAccountLog(pageBean);
	}
	
	/**
	 * 查询需要结薪人员的情况 带分页
	 * @param info
	 * @param name
	 * @param userType
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryPaymentAccountByCondition")
	public PageBean queryPaymentAccountByCondition(PageInfo info,String keyWord,Integer userType){
		info.addConditions("salaryType", userType);
		info.addConditions("keyWord", keyWord);
		PageBean pageBean = Toolkit.fillPageInfo(info);
		return iFinancialService.queryPaymentAccountByCondition(pageBean);
	}

	/**
	 * 保存发放工资数据
	 * @param salaryLog
	 * @return
	 */
	@ResponseBody
	@RequestMapping("paySalarySubmit")
	public Map<String, Object> paySalarySubmit(SalaryLog salaryLog,Integer userId){
		//设置是教练ID还是管理员id
		if(salaryLog.getType()==1){
			salaryLog.setCoachId(userId);
		}else{
			salaryLog.setAdminId(userId);
		}
		salaryLog.setOperatorId(getCurrLoginAdmin().getId());
		return iFinancialService.paySalarySubmit(salaryLog);
	}
	
	@RequestMapping("queryFinancialInfo")
	public String queryFinincialInfo(){
		return "manage/financialAction/financialInfo";
	}
	
}
