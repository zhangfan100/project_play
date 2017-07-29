package com.HuiShengTec.app.cohAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ILessonInfoService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;

@Controller
@Scope("prototype")
@RequestMapping("coh")
public class CohLessonInfoAction extends BaseAction {
	
	@Autowired
	private ILessonInfoService iLessonInfoService;
	
	@RequestMapping("historyCohLessonInfo")
	public String historyCohLessonInfo(){
		return "coach/cohLessonInfoAction/historyCohLessonInfo";
	}
	
	@RequestMapping("futureCohLessonInfo")
	public String futureCohLessonInfo(){
		return "coach/cohLessonInfoAction/futureCohLessonInfo";
	}
	
	@ResponseBody
	@RequestMapping("queryCohLessonInfo")
	public PageBean queryCohLessonInfo(PageInfo info,Integer mode){
//		//1-计划
//		//2-历史
//		info.addConditions("mode", mode);
//		info.addConditions("coachId", getCurrLoginCoach().getId());
//		return iLessonInfoService.queryCohLessonInfo(info);
		return null;
	}
}
