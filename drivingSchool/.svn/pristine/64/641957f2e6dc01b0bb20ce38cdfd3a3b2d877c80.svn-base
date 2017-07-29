package com.HuiShengTec.app.magAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ICoachGroupService;
import com.HuiShengTec.app.service.ICoachWeekLessonConfigService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.utils.Toolkit;

@Controller
@RequestMapping("mag")
@Scope("prototype")
public class CoachGroupAction extends BaseAction {
	
	@Autowired
	private ICoachGroupService iCoachGroupSerce;
	@Autowired
    private ICoachWeekLessonConfigService iCoachWeekLessonConfigService;
	
	@RequestMapping("coachGroupManage")
	public String coachGroupManage(){
		return "manage/coachGroupAction/coachGroupManage";
	}
	
	/**
	 * 分页显示空闲的教练  对于空闲教练来说就是由管理员来分配是到科目二还是科目三，所有科目不应该是选出空闲教练的条件
	 * @author mihuajun
	 * @createTime 2014-11-12 下午5:35:53
	 * @param info
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryUnusedCoachPage")
	public PageBean queryUnusedCoachPage(PageInfo info,Integer weekDay,Integer timeSlot){
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("weekDay",weekDay);
		pageBean.addConditions("timeSlot",timeSlot);
		iCoachGroupSerce.queryUnusedCoachPage(pageBean);
		return pageBean;
	}
	
	/**
	 * 分页显示非空闲的教练
	 * @author mihuajun
	 * @createTime 2014-11-12 下午5:35:53
	 * @param info
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryUsedCoachPage")
	public PageBean queryUsedCoachPage(PageInfo info,Integer weekDay,Integer subject,Integer timeSlot){
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("weekDay",weekDay);
		pageBean.addConditions("subject",subject);
		pageBean.addConditions("timeSlot",timeSlot);
		iCoachGroupSerce.queryUsedCoachPage(pageBean);
		return pageBean;
	}
	
	/**
	 * 加入分组教练
	 * @author mihuajun
	 * @createTime 2014-11-13 上午10:19:12
	 * @return
	 */
	@RequestMapping("joinCoachGroup")
	@ResponseBody
	public Integer joinCoachGroup(Integer weekDay,Integer subject,Integer timeSlot,String cohIds){
		return iCoachWeekLessonConfigService.joinCoachGroup(weekDay,subject,timeSlot,cohIds);
	}
	
	/**
	 * 移除教练分组
	 * @author mihuajun
	 * @createTime 2014-11-13 上午10:22:46
	 * @param groupIds
	 * @return
	 */
	@RequestMapping("removeCoachGroup")
	@ResponseBody
	public Integer removeCoachGroup(Integer weekDay,Integer subject,Integer timeSlot,String groupIds){
		return iCoachWeekLessonConfigService.removeCoachGroup(weekDay,subject,timeSlot,groupIds);
	}

}
