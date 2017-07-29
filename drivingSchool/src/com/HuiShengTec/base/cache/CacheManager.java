package com.HuiShengTec.base.cache;

import java.util.HashMap;

import com.HuiShengTec.utils.Toolkit;
//缓存管理器
public class CacheManager {
	//定义缓存
	private static HashMap<String, Object> cache=null;
	private CacheManager(){}
	//缓存初始化
	public static HashMap<String, Object> getInstance(){
		if(Toolkit.isEmpty(cache)){
			cache=new HashMap<>();
		}
		return cache;
	}
	/**
	 * 获取缓存中的内容
	 * @param key
	 * @return
	 */
	public static Object getCache(String key){
		return getInstance().get(key);
	}
	/**
	 * 编辑缓存内容
	 * @param key
	 * @param value
	 */
	public static void editCache(String key,Object value){
		getInstance().put(key,value);
	}
}
