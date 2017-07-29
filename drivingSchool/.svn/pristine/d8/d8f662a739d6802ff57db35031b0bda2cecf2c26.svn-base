package com.HuiShengTec.app.magAction;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.IMessageService;
import com.HuiShengTec.base.action.BaseAction;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.base.messageConverter.JSONDateOutputMode;
import com.HuiShengTec.entity.CampusInfo;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.Message;
import com.HuiShengTec.entity.MessageKind;
import com.HuiShengTec.utils.Toolkit;

/**
 * 
 * 消息管理：包括驾校介绍、合同、地图
 * @author mihuajun
 *
 */
@Controller
@RequestMapping("/mag")
@Scope("prototype")
public class MessageAction extends BaseAction {
	
	@Autowired
	private IMessageService iMessageService;
	
	/**
	 * 跳转到消息管理页
	 * @return
	 */
	@RequestMapping("/messageManage")
	public String messageManage(){
		return "manage/messageAction/messageManage";
	}
	
	/**
	 * 跳转到消息新增 页
	 * @return
	 */
	@RequestMapping("/addMessage")
	public String addMessage(){
		return "manage/messageAction/addMessage";
	}
	
	/**
	 * 跳转到消息修改 页
	 * @return
	 */
	@RequestMapping("/editMessage")
	public String editMessage(Integer id){
		
		request.setAttribute("record", iMessageService.queryMessageByID(id));
		
		return "manage/messageAction/editMessage";
	}
	
	/**
	 * 分页显示系统消息
	 * @return
	 */
	
	@RequestMapping("/queryMessagePage")
	@ResponseBody
	public PageBean queryMessagePage(PageInfo info,String kindKey,@DateTimeFormat(pattern="yyyy-MM-dd")Date beginDate,@DateTimeFormat(pattern="yyyy-MM-dd")Date endDate,String keyWord){
		session.setAttribute("JSONMode",JSONDateOutputMode.dateTimeMode);
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("kindKey", kindKey);
		
		pageBean.addConditions("beginDate", beginDate);
		pageBean.addConditions("endDate",  endDate);
		pageBean.addConditions("keyWord",  keyWord);
		
		return iMessageService.queryMessagePage(pageBean);
	}
	
	/**
	 * 保存消息
	 * @return
	 */
	
	@RequestMapping("/addMessageSubmit")
	@ResponseBody
	public Integer addMessageSubmit(Message msg,String schoolSeptFlag){
		
		msg.setIsDisplay(msg.getIsDisplay()==null?0:msg.getIsDisplay());
		msg.setIsTop(msg.getIsTop()==null?0:msg.getIsTop());
		msg.setIsHot(msg.getIsHot()==null?0:msg.getIsHot());
		
		msg.setUserId(((Login)getSessionData("loginInfo")).getUserId());
		
		//如果未选择分校，则分校ID为0
		if(!"1".equals(schoolSeptFlag)){
			msg.setSeperateSchoolId(0);
		}
		
		return iMessageService.addMessageSubmit(msg);
	}
	
	/**
	 * 修改消息
	 * @return
	 */
	@RequestMapping("/editMessageSubmit")
	@ResponseBody
	public Integer editMessageSubmit(Message msg,String schoolSeptFlag){
		
		msg.setIsDisplay(msg.getIsDisplay()==null?0:msg.getIsDisplay());
		msg.setIsTop(msg.getIsTop()==null?0:msg.getIsTop());
		msg.setIsHot(msg.getIsHot()==null?0:msg.getIsHot());
		
		//如果未选择分校，则分校ID为0
		if(!"1".equals(schoolSeptFlag)){
			msg.setSeperateSchoolId(0);
		}
		
		return iMessageService.editMessageSubmit(msg);
	}
	
	/**
	 * 查询所有消息类别
	 * @return
	 */
	@RequestMapping("/queryMessageKind")
	@ResponseBody
	public List<MessageKind> queryMessageKind(){
		return iMessageService.queryMessageKind(null);
	}
	
	/**
	 * 查询所有训练场地信息
	 */
	@RequestMapping("/queryschoolSept")
	@ResponseBody
	public List<CampusInfo> queryschoolSept(){
		return iMessageService.queryschoolSept();
	}
	
	
	/**
	 * 根据ID删除消息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteMessageByID")
	public Integer deleteMessageByID(String ids,Integer kindId){
		Map<String,Object> param = new HashMap<String, Object>();
		String [] idsArray = null;
		if(ids!=null)
			idsArray = ids.split(",");
		param.put("ids", idsArray);
		param.put("kindId", kindId);
		return iMessageService.deleteMessageByID(param);
	}
}
