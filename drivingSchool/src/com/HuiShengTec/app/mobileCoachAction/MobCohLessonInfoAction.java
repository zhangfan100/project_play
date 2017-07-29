package com.HuiShengTec.app.mobileCoachAction;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ILessonInfoService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.utils.Toolkit;

@RestController
@Scope("prototype")
@RequestMapping("cohMobile")
public class MobCohLessonInfoAction extends BaseAction{
	
//	@Autowired
//	private ILessonInfoService iLessonInfoService;
//	
//	@RequestMapping("queryCohLessonInfo")
//	public HashMap<String, Object> queryCohLessonInfo(PageInfo info,Integer mode){
////		//2-历史记录
////		//1-预约培训
////		info.addConditions("mode", mode);
////		info.addConditions("coachId", getCurrLoginCoach().getId());
////		PageBean data=iLessonInfoService.queryCohLessonInfo(info);
////	    return Toolkit.initMapCondition("data", data);
////	}
}
