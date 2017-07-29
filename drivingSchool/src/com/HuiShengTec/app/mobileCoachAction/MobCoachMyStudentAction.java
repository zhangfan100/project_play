package com.HuiShengTec.app.mobileCoachAction;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.IMyStudentService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.utils.Toolkit;

/**
 * 
 * 教练个人中心 我的学员
 * @author llj
 *
 */
@RequestMapping("cohMobile")
@RestController
public class MobCoachMyStudentAction extends BaseAction{
	@Autowired
	private IMyStudentService studentService;
	
	/**
	 * 我的 学员 列表
	 * @return
	 */
	@RequestMapping("queryMyStudentPage")
	@ResponseBody
		public HashMap<String, Object> queryMyStudentPage(PageInfo info,String beginDate,String endDate,String keyWord){
			PageBean pageBean = Toolkit.fillPageInfo(info);
			pageBean.addConditions("beginDate", beginDate==null?null:beginDate.trim().isEmpty()?null:beginDate.trim());
			pageBean.addConditions("endDate",  endDate==null?null:endDate.trim().isEmpty()?null:endDate.trim());
			pageBean.addConditions("keyWord",  keyWord==null?null:keyWord.trim().isEmpty()?null:keyWord.trim());
			pageBean.addConditions("cohId", getCurrLoginCoach().getId());
			 PageBean data=studentService.queryMyStudentPage(pageBean);
			return Toolkit.initMapCondition("data", data);
		}
		
	
}
