package com.HuiShengTec.app.cohAction;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ICoachWeekLessonConfigService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.CoachWeekLessonConfig;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.utils.Toolkit;
@Controller
@Scope("prototype")
@RequestMapping("coh")
public class CoachWeekLessonConfigAction extends BaseAction{

	@Autowired
	private ICoachWeekLessonConfigService coachWeekLessonConfigService;
	
	/**
	 * 插入数据
	 * @param coachWeekLessonConfig
	 */
	@RequestMapping("insertCoachWeekLessonConfig")
	public void insertCoachWeekLessonConfig(CoachWeekLessonConfig coachWeekLessonConfig) {
		for(int i =0 ;i<15;i++){
			CoachWeekLessonConfig cwlc = new CoachWeekLessonConfig();
			cwlc.setCoachId(24);
			cwlc.setSubject(2);
			cwlc.setTimeSlot(2);
			cwlc.setWeekDay(3);
			cwlc.setTimeSlotType(2);
			coachWeekLessonConfigService.insertCoachWeekLessonConfig(cwlc);
		}
	}
	
	/**
	 * 跳转到列表页面
	 * @return
	 */
	@RequestMapping("toQueryAllWeekSetting")
	public String toQueryAllWeekSetting(){
		return "coach/CoachWeekLessonConfigAction/showAllWeekConfig";
	}
	
	/**
	 * 根据课程设置Id得到详细的记录
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("editSettingInfo")
	public String editSettingInfo(Integer id){
		pushRequestValue("record",coachWeekLessonConfigService.queryCoachWeekLessonConfigById(id));
		return "coach/CoachWeekLessonConfigAction/editCoachWeekLessonConfig";
	}
	
	/**
	 * 查询所有的课程设置
	 * @param coachId
	 * @return
	 */
	//@ResponseBody：处理器功能处理方法的返回值作为响应体（通过HttpMessageConverter进行类型转换）；
	@ResponseBody
	@RequestMapping("queryAllWeekSetting")
	public List<Map<String, Object>> queryAllWeekSetting() {
		Login loginInfo = this.getCurrLoginInfo();
		return coachWeekLessonConfigService.queryAllWeekSetting(loginInfo.getUserId());
	}
	/**
	 * 后台发送ajax保存课程设置的修改
	 * @return
	 */
	@ResponseBody
	@RequestMapping("editSettingSubmit")
	public Integer editSettingSubmit(CoachWeekLessonConfig coachWeekLessonConfig) {
       return coachWeekLessonConfigService.editSettingSubmit(coachWeekLessonConfig);
	}
	
	/**
	 * 分页查询课程设置
	 * @param info
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryAllWeekSettingByPage")
	public PageBean queryAllWeekSettingByPage(PageInfo info) {
		Login loginInfo = this.getCurrLoginInfo();
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("coachId",loginInfo.getUserId());
		return coachWeekLessonConfigService.queryAllWeekSettingByPage(pageBean);
	}
}
