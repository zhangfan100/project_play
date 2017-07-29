package com.HuiShengTec.app.stuAction;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.ILessonDetailService;
import com.HuiShengTec.base.action.BaseAction;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.utils.Toolkit;
@Controller
@Scope("prototype")
@RequestMapping("stu")
public class LessonDetailAction  extends BaseAction {
	@Resource
	private ILessonDetailService iLessonDetailService;
	
	/**
	 * 查看培训完成 异常的详情
	 * @return
	 */
	@RequestMapping("toTrainDetail")
	public String toTrainDetail(int trainCode){
		PageInfo info = new PageInfo();
		info.setPage(1);
		info.setRows(8);
		HashMap<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("trainCode", trainCode);
		info.setConditions(conditions);
		pushRequestValue("info", iLessonDetailService.queryDetail(Integer.valueOf(trainCode)));
		pushRequestValue("data", iLessonDetailService.queryByTrainCode(Toolkit.fillPageInfo(info)));
		return "student/trainAction/trainDetail";
	}
	@ResponseBody
	@RequestMapping("queryByTrainCode")
	public PageBean queryByTrainCode(PageInfo info){
		String trainCode = request.getParameter("trainCode");
		HashMap<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("trainCode", trainCode);
		info.setConditions(conditions);
		return iLessonDetailService.queryByTrainCode(Toolkit.fillPageInfo(info));
	}
	
	@ResponseBody
	@RequestMapping("toDeductionInfo")
	public PageBean toDeductionInfo(){
		PageInfo info = new PageInfo();
		info.setPage(1);
		info.setRows(10);
		String deducted_code = request.getParameter("deducted_code");
		HashMap<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("deducted_code", deducted_code);
		info.setConditions(conditions);
		return iLessonDetailService.queryByCode(Toolkit.fillPageInfo(info));
	}
	
	@RequestMapping("queryByCode")
	@ResponseBody
	public PageBean queryByCode(PageInfo info){
		String deducted_code = request.getParameter("deducted_code");
		HashMap<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("deducted_code", deducted_code);
		info.setConditions(conditions);
		return iLessonDetailService.queryByCode(Toolkit.fillPageInfo(info));
	}
	
	
	

}
