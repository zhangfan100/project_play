package com.HuiShengTec.app.magAction;

import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ICoachInfoService;
import com.HuiShengTec.app.service.ICoachPaymentLogService;
import com.HuiShengTec.app.service.ISysAdminInfoService;
import com.HuiShengTec.base.annotation.Token;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.base.messageConverter.JSONDateOutputMode;
import com.HuiShengTec.entity.CoachInfo;
import com.HuiShengTec.entity.CoachPaymentLog;
import com.HuiShengTec.utils.Toolkit;

@Controller
@Scope("prototype")
@RequestMapping("mag")
public class CoachPaymentAction extends BaseAction {

	@Autowired
	private ICoachPaymentLogService iCoachPaymentLogService;
	@Autowired
	private ISysAdminInfoService iSysAdminInfoService;
	@Autowired
	private ICoachInfoService iCoachInfoService;

	/**
	 * 跳转到列表页面
	 * @return
	 */
	@RequestMapping("queryCoachPaymentInfoPage")
	public String queryCoachPaymentInfoPage(){
		return "manage/coachPaymentInfoAction/coachPaymentInfoPage";
	}
	
	/**
	 * 跳转到添加教练缴费页面
	 * @return
	 */
	@Token(addToken=true)
	@RequestMapping("addCoachPaymentInfoPage")
	public String addCoachPaymentInfoPage(){
		return "manage/coachPaymentInfoAction/addCoachPaymentInfoPage";
	}
	
	/**
	 * 查询教练缴费
	 * @return
	 */
	@RequestMapping("querycoachPaymentInfo")
	@ResponseBody
	public PageBean querycoachPaymentInfo(PageInfo info,@DateTimeFormat(pattern="yyyy-MM-dd")Date beginDate,@DateTimeFormat(pattern="yyyy-MM-dd")Date endDate){
		JSONDateOutputMode.setJSONDateToTimeMode();
		PageBean bean = Toolkit.fillPageInfo(info);
		bean.addConditions("beginDate", beginDate);
		bean.addConditions("endDate", endDate);
		return iCoachPaymentLogService.querycoachPaymentInfo(bean);
	}
	
	/**
	 * 确认添加教练缴费信息
	 * @return
	 */
	@RequestMapping("confirmAddCoachPayment")
	@ResponseBody
	@Token(delToken=true)
	public Map<String, Object> confirmAddCoachPayment(CoachPaymentLog coachPaymentLog,Integer payType){
		if(!validateData(coachPaymentLog, payType)){
			return Toolkit.getMapStatus(-1);
		}
		Map<Object, String> admin = iSysAdminInfoService.querySysAdminId(getCurrLoginAdmin().getId());
		coachPaymentLog.setUserId(getCurrLoginAdmin().getId());
		coachPaymentLog.setUserName(admin.get("username"));
		return iCoachPaymentLogService.confirmAddCoachPayment(coachPaymentLog,payType);
	}
	
	
	/**
	 * 验证前台添加教练缴费信息
	 * @param coachPaymentLog
	 * @param payType
	 * @return
	 */
	private boolean validateData(CoachPaymentLog coachPaymentLog,Integer payType){
		Integer coachId = coachPaymentLog.getCoachId();
		if(coachId==null){//说明自己瞎填了一个教练 数据库根本没有对应教练
			return false;
		}
		Float realCash = coachPaymentLog.getRealCash();
		
		if(realCash ==null || !isNumeric(String.valueOf(realCash))){
			return false;//不符合float或者int型
		}
		Float cash = coachPaymentLog.getCash();
		if(cash == null || !isNumeric(String.valueOf(cash))){
			return false;//不符合float或者int型
		}
		
		if(payType==null){
			return false;//没有传来缴费方式
		}
		String paymentItem = coachPaymentLog.getPaymentItem();
		if(paymentItem==null || "".equals(paymentItem)){
			return false;//paymentItem为空
		}else{
			//去掉前后特殊标点
			String regex = "^[,。，.]*|[,。，.]*$";
			paymentItem = paymentItem.replaceAll(regex, "");
			coachPaymentLog.setPaymentItem(paymentItem);
		}
		String coachName = coachPaymentLog.getCoachName();
		if(coachName==null || "".equals(coachName)){
			return false;//coachName为空
		}
		CoachInfo coachInfo = iCoachInfoService.queryCoachInfo(coachId);
		if(coachInfo==null || !coachInfo.getName().equals(coachName)){
			return false;//说明数据库里面的教练和传来的教练不匹配
		}
		return true;
	}
	
	/**
	 * 验证是否是float或者int
	 * @param str
	 * @return
	 */
	private static boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("{0,1}\\d+\\.\\d*|{0,1}\\d*\\.\\d+|[0-9]*"); 
	    return pattern.matcher(str).matches();    
	 }
	
}
