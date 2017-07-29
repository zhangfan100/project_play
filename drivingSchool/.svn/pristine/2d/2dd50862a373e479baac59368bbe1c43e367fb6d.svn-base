package com.HuiShengTec.app.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.CampusInfo;
import com.HuiShengTec.entity.Message;
import com.HuiShengTec.entity.MessageKind;

/**
 * 
 * 消息管理接口
 * @author mihuajun
 *
 */
public interface IMessageService {

	/**
	 * 分页显示系统消息
	 * @param pageBean
	 * @return
	 */
	public PageBean queryMessagePage(PageBean pageBean);
	
	/**
	 * 保存消息
	 * @param msg
	 * @return
	 */
	public Integer addMessageSubmit(Message msg);
	
	/**
	 * 查询所有消息类别
	 * @return
	 */
	public List<MessageKind> queryMessageKind(Integer kindKey);
	
	/**
	 * 根据ID删除消息
	 * @param id
	 * @return
	 */
	public Integer deleteMessageByID(Map<String, Object> param);
	
	/**
	 * 查询所有训练场地信息
	 * @return
	 */
	public List<CampusInfo> queryschoolSept();
	
	/**
	 * 修改消息
	 * @param msg
	 * @return
	 */
	public Integer editMessageSubmit(Message msg);
	
	/**
	 * 消息缓存
	 * @param kindNames 
	 * @return
	 */
	public ConcurrentHashMap<String, List<Map<String,Object>>> queryTopCache(String[] kindNames);
		
	/**
	 * 根据ID查询所在消息
	 * @param id
	 * @return
	 */
	public Map<String,Object> queryMessageByID(Integer id);
	
	/**
	 * 分页显示校区公告以及常见问题,只显示可见
	 * @param pageBean
	 */
	void listMessage(PageBean pageBean);
	
	/**
	 * 查询消息类别所属的消息title
	 * @param param
	 * @return
	 */
	Map<String, Object> viewMsg(Integer kindId);
	
	/**
	 * 根据ID查询消息
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryProfileMessageByID(Integer id);

}
