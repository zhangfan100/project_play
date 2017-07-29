package com.HuiShengTec.app.magAction;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.IStuInfoService;
import com.HuiShengTec.app.service.ITestInfoService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.TestInfo;
import com.HuiShengTec.utils.Toolkit;

@Controller
@Scope("prototype")
@RequestMapping("/mag")
public class TestInfoAction extends BaseAction {
	@Autowired
	private ITestInfoService iTestInfoService;
	@Autowired
	private IStuInfoService iStuInfoService;

	@RequestMapping("/testInfoManage")
	public String testInfoManage() {
		return "manage/testInfoAction/testInfoManage";
	}

	@ResponseBody
	@RequestMapping("/queryTestInfoPage")
	public PageBean queryTestInfoPage(PageInfo info) {
		return iTestInfoService.queryTestInfoPage(info);
	}

	@RequestMapping("/addTestInfo")
	public String addTestInfo() {
		return "manage/testInfoAction/addTestInfo";
	}

	@ResponseBody
	@RequestMapping("/addTestInfoSubmit")
	public Integer addTestInfoSubmit(TestInfo info) {
		return iTestInfoService.addTestInfo(info);
	}

	@ResponseBody
	@RequestMapping("/queryStudentsByKeyWord")
	public PageBean queryStudentsByKeyWord(String q,PageInfo info) {
		PageBean bean = Toolkit.fillPageInfo(info);
		return iStuInfoService.queryStudentsByKeyWord(bean,q);
	}
	
	@ResponseBody
	@RequestMapping("/cancelTestInfo")
	public Integer cancelTestInfo(String ids){
		iTestInfoService.cancelTestInfo(ids);
		return 1;
	}
	
	
	@RequestMapping("/testDetailManage")
	public String testDetailManage() {
		return "manage/testInfoAction/testInfoManage";
	}
	
	@RequestMapping("/showTestDetail")
	public String showTestDetail(Integer testInfoId){
		HashMap<String, Object> data = iTestInfoService.queryTestDetail(testInfoId);
		if(!Toolkit.isEmpty(data.get("stuId"))){
			pushRequestValue("stuPic",iStuInfoService.queryStudentHead((Integer)data.get("stuId")));
		}
		pushRequestValue("testDetail", data);
		return "manage/testInfoAction/showTestDetail";
	}
}
