package com.HuiShengTec.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IMessageDao;
import com.HuiShengTec.app.service.IMessageService;
import com.HuiShengTec.base.cache.MessageCache;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.CampusInfo;
import com.HuiShengTec.entity.Message;
import com.HuiShengTec.entity.MessageKind;

/**
 * 
 * 消息管理实现类
 * @author mihuajun
 *
 */
@Service
@Transactional
public class MessageServiceImpl implements IMessageService {
	
	@Autowired
	private IMessageDao iMessageDao;
	
	/**
	 * 分页显示系统消息
	 */
	@Override
	public PageBean queryMessagePage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setRows(iMessageDao.queryMessagePage(pageBean));
		return pageBean;
	}
	
	/**
	 * 保存消息
	 */
	@Override
	public Integer addMessageSubmit(Message msg) {
		// TODO Auto-generated method stub
		
		//如果该条记录为置，设为其他为非置顶
		if(msg.getIsTop()==1){
			iMessageDao.updateMessageNotTop(msg);
		}
		
		int len = iMessageDao.addMessageSubmit(msg);
		MessageCache.refreshMessages(queryTopCache(MessageCache.kindKeys));
		return len>0?0:1;
	}
	
	/**
	 * 查询所有消息类别
	 */
	@Override
	public List<MessageKind> queryMessageKind(Integer kindKey) {
		// TODO Auto-generated method stub
		return iMessageDao.queryMessageKind(kindKey);
	}
	
	/**
	 * 根据ID删除消息
	 */
	@Override
	public Integer deleteMessageByID(Map<String,Object> param) {
		// TODO Auto-generated method stub
		int len = iMessageDao.deleteMessageByID(param);
		MessageCache.refreshMessages(queryTopCache(MessageCache.kindKeys));
		return len>0?0:1;
	}
	
	/**
	 * 查询所有训练场地信息
	 */
	@Override
	public List<CampusInfo> queryschoolSept() {
		// TODO Auto-generated method stub
		return iMessageDao.queryschoolSept();
	}
	
	/**
	 * 修改消息
	 */
	@Override
	public Integer editMessageSubmit(Message msg) {
		// TODO Auto-generated method stub
		
		//如果该条记录为置，设为其他为非置顶
		if(msg.getIsTop()==1){
			iMessageDao.updateMessageNotTop(msg);
		}
		int len = iMessageDao.editMessageSubmit(msg);
		MessageCache.refreshMessages(queryTopCache(MessageCache.kindKeys));
		return len>0?0:1;
	}
	
	/**
	 * 各消息类型的前几条记录
	 */
	@Override
	public ConcurrentHashMap<String, List<Map<String,Object>>> queryTopCache(String[] kindKeys) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = iMessageDao.queryTopCache(kindKeys);
		ConcurrentHashMap<String,List<Map<String,Object>>> result = new  ConcurrentHashMap<String,List<Map<String,Object>>>();
		
		for(String kindKey:kindKeys){//把驾校公告 常见问题的消息查出来
			List<Map<String,Object>> kindList = new ArrayList<Map<String,Object>>();
			for(Map<String,Object> item:list){
				if(kindKey.equals(item.get("kindKey"))){
					kindList.add(item);
				}
			}
			result.put(kindKey, kindList);
		}
		
		
		return result;
	}
	
	/**
	 * 根据ID查询所在消息
	 */
	@Override
	public Map<String, Object> queryMessageByID(Integer id) {
		// TODO Auto-generated method stub
		return iMessageDao.queryMessageByID(id);
	}
	
	/**
	 * 分页显示校区公告以及常见问题
	 */
	@Override
	public void listMessage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setRows(iMessageDao.listMessage(pageBean));
		
	}
	
	/**
	 * 查询消息类别所属的消息title
	 * @param param
	 * @return
	 */
	@Override
	public Map<String, Object> viewMsg(Integer kindId) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> list = iMessageDao.queryMessage(kindId);
		
		String kindName = null;
		for(Map<String, Object> item:list){
			if(kindName==null)
				kindName = (String) item.get("kindName");
		}
		
		
		result.put("kindName", kindName);
		result.put("leftMenu", merger(list));
		
		return result;
	}
	
	@SuppressWarnings({"unchecked" })
	private List<Map<String, Object>> merger(List<Map<String, Object>> list) {
		// TODO Auto-generated method stub
		
		List<Map<String, Object>> rlist = new ArrayList<Map<String,Object>>();
		
		for(Map<String,Object> item:list){
			String traiName = (String) item.get("traiName");
			if(traiName==null){
				Map<String,Object> ritem = new HashMap<String, Object>();
				ritem.put("item", item);
				ritem.put("children", null);
				rlist.add(ritem);
				continue;
			}
			
			
			Map<String,Object> ritem  = null;
			for(Map<String,Object> item2:rlist){
				if(item2.get("children")!=null && item2.get("item").equals(traiName)){
					ritem = item2;
					break;
				}
			}
			
			if(ritem==null){
				ritem = new HashMap<String, Object>();
				ritem.put("item", traiName);
				ritem.put("children", new ArrayList<Map<String,Object>>());
				rlist.add(ritem);
			}
			
			List<Map<String, Object>> children = (List<Map<String, Object>>) ritem.get("children");
			children.add(item);
			
		}
		
		return rlist;
	}
	
	/**
	 * 根据ID查询消息
	 */
	@Override
	public Map<String, Object> queryProfileMessageByID(Integer id) {
		// TODO Auto-generated method stub
		return iMessageDao.queryProfileMessageByID(id);
	}
	
	
}
