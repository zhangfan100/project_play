package com.HuiShengTec.app.stuAction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ITestInfoService;
import com.HuiShengTec.base.cache.PropertiesCache;
import com.HuiShengTec.entity.TestInfo;

@Controller
@Scope("prototype")
@RequestMapping("stu")
public class StuTestInfoAction extends BaseAction {
	@Autowired
	private ITestInfoService iTestInfoService;

	/**
	 * 跳转至约考界面
	 * 
	 * @return
	 */
	@RequestMapping("addTestInfo")
	public String addTestInfo() {
		request.setAttribute("price", PropertiesCache.getValue("testPrice"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		calendar.add(calendar.DATE, 1);
		request.setAttribute("beginDate", sdf.format(calendar.getTime()));
		calendar.add(calendar.DATE, 7);
		request.setAttribute("endDate", sdf.format(calendar.getTime()));
		return "student/stuTestInfoAction/addTestInfo";
	}

	/**
	 * 
	 * @param info
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping("addTestInfoSubmit")
	public int addTestInfoSubmit(TestInfo info) throws ParseException {
		return iTestInfoService.addTestInfo(info, getCurrLoginStudent());
	}

	@RequestMapping("testInfoManage")
	public String testInfoManage() {
		pushRequestValue("testList",
				iTestInfoService.queryStuTestInfoList(getCurrLoginStudent()
						.getId()));
		return "student/stuTestInfoAction/testInfoManage";
	}
	
	/**
	 * 取消预约模考
	 * @author mihuajun
	 * @createTime 2014-11-19 上午11:16:50
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("cancelPExam")
	public int cancelPExam(int id){
		return iTestInfoService.deletePExam(id);
	}
}
