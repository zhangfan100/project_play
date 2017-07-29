package com.HuiShengTec.app.mobileStuAction;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ILessonDetailService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.utils.Toolkit;

/**
 * llj
 * @author 
 * 查看培训明细
 */
@RequestMapping("/mobile")
@Controller
public class MobLessonDetailAction extends BaseAction{
	@Autowired
	private ILessonDetailService iLessonDetailService;
	
	/**
	 * 根据ID查看培训明细
	 * @param trainCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping("toTrainDetail")
	public HashMap<String, Object> toTrainDetail(Integer trainCode){
		PageInfo info = new PageInfo();
		info.setPage(1);
		info.setRows(8);
		HashMap<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("trainCode", trainCode);
		info.setConditions(conditions);
		HashMap<String, Object> data = new HashMap<String, Object>();
		//培训明细
		HashMap<String, Object> detail=(HashMap<String, Object>) iLessonDetailService.queryDetail(Integer.valueOf(trainCode));
		PageBean trainCodeinfo=(PageBean) iLessonDetailService.queryByTrainCode(Toolkit.fillPageInfo(info));
		data.put("info", detail);
		data.put("dataPageBean", trainCodeinfo);
		return data;
	}
	/**
	 * 查看扣分项
	 * @return
	 */
	@ResponseBody
	@RequestMapping("toDeductionInfo")
	public PageBean toDeductionInfo(Integer deducted_code){
		PageInfo info = new PageInfo();
		info.setPage(1);
		info.setRows(10);
		HashMap<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("deducted_code", deducted_code);
		info.setConditions(conditions);
		return iLessonDetailService.queryByCode(Toolkit.fillPageInfo(info));
	}

}
