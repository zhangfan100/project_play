package com.HuiShengTec.base.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import com.HuiShengTec.entity.BasicProperty;
import com.HuiShengTec.utils.Toolkit;

public class PropertiesCache {
	private static ConcurrentHashMap<String,BasicProperty> basicProperties = null;
	
	//页面必须的参数
	private static final String caches[] = new String[]
			{"jxlogo","jx_chineseName","jx_englishName","contact","phone1","phone2",
			"service_period","monitor_phone","service_mailbox","copyRight_info","filings",
			"license","filings_address","filings_code","copyRight_years","advice"
			};
	
	public static void refreshProperties(ConcurrentHashMap<String,BasicProperty> data){
		basicProperties=data;
	}
	public static String getValue(String key){
		return basicProperties.get(key).getValue();
	}
	public static void setValue(String key,String value){
		basicProperties.get(key).setValue(value);
	}
	public static boolean isInstance(){
		return !Toolkit.isEmpty(basicProperties);
	}
	
	public static BasicProperty getBasicProperty(String key){
		return basicProperties.get(key);
	}
	
	public static void fillRequestParam(HttpServletRequest request){
		for(String str:caches){ 
			request.setAttribute(str, PropertiesCache.getValue(str));
		}
	}
	public static List<BasicProperty> getBasicPropertiesByType(Integer type){
		List<BasicProperty> result = new ArrayList<>();
		for (Entry<String, BasicProperty> p : basicProperties.entrySet()) {
			if(p.getValue().getType().equals(type)){
				result.add(p.getValue());
			}
		}
		return result;
	}
	
}
