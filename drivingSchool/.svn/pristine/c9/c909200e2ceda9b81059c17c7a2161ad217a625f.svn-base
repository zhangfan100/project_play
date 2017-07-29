package com.HuiShengTec.app.magAction;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.IThreeSubjectService;

@Controller
@Scope("prototype")
@RequestMapping("mag")
public class ThreeSubjectAction extends BaseAction{

	
	@Autowired
	private IThreeSubjectService iThreeSubjectService;
	
	/**
	 * 
	 * @Description: TODO(科目三电子围墙语音播报)
	 * @author [llj]
	 */
	@RequestMapping("querySceneMark")
	@ResponseBody
	public Map<String,Object> querySceneMark(@RequestParam Map<String,Object> param){
		return iThreeSubjectService.querySceneMark(param);
	}
	
}
