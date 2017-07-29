package com.HuiShengTec.app.magAction;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.IIncomeItemService;
import com.HuiShengTec.app.service.ILessonInfoService;
import com.HuiShengTec.app.service.IStuInfoService;
import com.HuiShengTec.app.service.IStuPaymentLogService;
import com.HuiShengTec.app.service.ISysAdminInfoService;
import com.HuiShengTec.base.annotation.Token;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.base.messageConverter.JSONDateOutputMode;
import com.HuiShengTec.entity.StudentInfo;
import com.HuiShengTec.entity.StudentPaymentLog;
import com.HuiShengTec.utils.Toolkit;

@Controller
@Scope("prototype")
@RequestMapping("mag")
public class StuPaymentAction extends BaseAction {

	@Autowired
	private IStuPaymentLogService iStuPaymentLogService;
	@Autowired
	private IStuInfoService iStuInfoService;
	@Autowired
	private ILessonInfoService iLessonInfoService;
	@Autowired
	private IIncomeItemService iIncomeItemService;
	@Autowired
	private ISysAdminInfoService iSysAdminInfoService;
	
	/**
	 * 跳转到显示学生缴费列表详情页面
	 * @return
	 */
	@RequestMapping("queryStuPaymentInfoPage")
	public String queryStuPaymentInfoPage(){
		return "manage/stuPaymentInfoAction/stuPaymentInfoPage";
	}
	
	
	/**
	 * 转到添加学生缴费详情
	 * @return
	 */
	@RequestMapping("addStuPaymentInfoPage")
	@Token(addToken=true)
	public String addStuPaymentInfoPage(){
		return "manage/stuPaymentInfoAction/addStuPaymentInfoPage";
	}
	
	/**
	 * 分页查询学生缴费列表
	 * @param info
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@RequestMapping("queryStuPaymentInfo")
	@ResponseBody
	public PageBean queryStuPaymentInfo(PageInfo info,@DateTimeFormat(pattern="yyyy-MM-dd")Date beginDate,@DateTimeFormat(pattern="yyyy-MM-dd")Date endDate){
		JSONDateOutputMode.setJSONDateToTimeMode();
		PageBean bean = Toolkit.fillPageInfo(info);
		bean.addConditions("beginDate", beginDate);
		bean.addConditions("endDate", endDate);
		return iStuPaymentLogService.queryStuPaymentInfo(bean);
	}
	
	/**
	 * 查询出学生预约课程中未缴费的
	 * @param stuId
	 * @return
	 */
	@RequestMapping("queryLessonInfoByStuId")
	@ResponseBody
	public List<Map<String, Object>> queryLessonInfoByStuId(Integer stuId){
		return iLessonInfoService.queryLessonInfoByStuId(stuId);
	}
	
	/**
	 * 表单提交 添加学生缴费信息
	 * @param studentPaymentLog
	 * @param payType
	 * @return
	 */
	@RequestMapping("confirmAddStuPayment")
	@ResponseBody
	@Token(delToken=true)
	public Map<String, Object> confirmAddStuPayment(StudentPaymentLog studentPaymentLog,Integer payType){
		if(!this.validateData(studentPaymentLog, payType)){
			return Toolkit.getMapStatus(-1);
		}
		Map<Object, String> admin = iSysAdminInfoService.querySysAdminId(getCurrLoginAdmin().getId());
		studentPaymentLog.setOpeartionUserId(getCurrLoginAdmin().getId());
		studentPaymentLog.setUserName(admin.get("username"));
		return iStuPaymentLogService.confirmAddStuPayment(studentPaymentLog,payType);
	}
	
	/**
	 * 验证前台添加学生缴费信息
	 * @param coachPaymentLog
	 * @param payType
	 * @return
	 */
	private boolean validateData(StudentPaymentLog studentPaymentLog,Integer payType){
		Integer stuId = studentPaymentLog.getStuId();
		if(stuId==null){//说明自己瞎填了一个学生
			return false;
		}
		Float realCash = studentPaymentLog.getRealCash();
		
		if(realCash ==null || !isNumeric(String.valueOf(realCash))){
			return false;//不符合float或者int型
		}
		Float cash = studentPaymentLog.getCash();
		if(cash == null || !isNumeric(String.valueOf(cash))){
			return false;//不符合float或者int型
		}
		
		if(payType==null){
			return false;//没有传来缴费方式 ,,,.，。梵蒂冈,.，。吩咐道，。,.!
		}
		String paymentItem = studentPaymentLog.getPaymentItem();
		if(paymentItem==null || "".equals(paymentItem)){
			return false;//paymentItem为空
		}else{
			//去掉前后特殊标点
			String regex = "^[,。，.]*|[,。，.]*$";
			paymentItem = paymentItem.replaceAll(regex, "");
			studentPaymentLog.setPaymentItem(paymentItem);
		}
		String stuName = studentPaymentLog.getStuName();
		if(stuName==null || "".equals(stuName)){
			return false;//stuName为空
		}
		StudentInfo studentInfo = iStuInfoService.queryStuInfo(stuId);
		if(studentInfo==null || !studentInfo.getName().equals(stuName)){
			return false;//说明数据库里面的学生和传来的学生不匹配
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
