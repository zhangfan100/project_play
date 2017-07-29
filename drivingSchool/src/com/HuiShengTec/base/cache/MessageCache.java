package com.HuiShengTec.base.cache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.HuiShengTec.utils.Toolkit;

/**
 * 消息缓存
 * @author mihuajun
 *
 */
public class MessageCache {
	
	private static ConcurrentHashMap<String,List<Map<String,Object>>> messages = null;
	public static String[] kindKeys = new String[]{"6","7"};
	
	public static void refreshMessages(ConcurrentHashMap<String,List<Map<String,Object>>> data){
		messages=data;
	}
	public static List<Map<String,Object>> getListMessage(String kindKey){
		return messages.get(kindKey);
	}
	public static boolean isInstance(){
		return !Toolkit.isEmpty(messages);
	}
}
