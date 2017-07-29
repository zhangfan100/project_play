package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.CampusInfo;
import com.HuiShengTec.entity.Message;
import com.HuiShengTec.entity.MessageKind;

/**
 * 
 * @author mihuajun
 *
 */
public interface IMessageDao extends IBaseDao {
	
	public Message queryMessage(MessageKind kind);
	
	/**
	 * 分页显示系统消息
	 * @param pageBean
	 * @return
	 */
	public List<HashMap<String,Object>> queryMessagePage(PageBean pageBean);
	
	/**
	 * 保存消息
	 */
	public Integer addMessageSubmit(Message msg);
	
	/**
	 * 查询所有消息类别
	 * @param kindKey 
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
	public int editMessageSubmit(Message msg);
	
	/**
	 * 各消息类型的前几条记录
	 * @param kindNames
	 * @return
	 */
	public List<Map<String, Object>> queryTopCache(String[] kindNames);
	
	/**
	 *根据ID查询所在消息
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryMessageByID(Integer id);
	
	/**
	 * 修改该类别下所有消息为非置顶
	 * @param msg
	 */
	public void updateMessageNotTop(Message msg);
	
	/**
	 * 分页显示校区公告以及常见问题-只显示可见
	 * @param pageBean
	 * @return
	 */
	public List<Map<String,Object>> listMessage(PageBean pageBean);
	
	/**
	 * 查询消息类别所属的消息title
	 * @param kindId
	 * @return
	 */
	public List<Map<String, Object>> queryMessage(Integer kindId);
	
	/**
	 * 根据ID查询消息
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryProfileMessageByID(Integer id);
	
}
