package com.HuiShengTec.test.action.magAction;

import java.util.List;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.HuiShengTec.app.service.impl.AttachmentServiceImpl;
import com.HuiShengTec.app.service.impl.WebPropertiesServiceImpl;
import com.HuiShengTec.entity.BasicProperty;
import com.HuiShengTec.test.basejunit.BaseActionJunit;
import com.HuiShengTec.utils.Toolkit;
import com.alibaba.fastjson.JSONObject;

public class TestWebPropertiesInfoAction extends BaseActionJunit{

	@Test
	public void testWebPropeInfoManage() throws Exception {
		request.setRequestURI("/mag/webPropeInfoManage"); 
        // 执行URI对应的action    
        final ModelAndView mav = this.excuteAction(request, response);
        System.out.println(mav.getViewName());
	}
	
	@Test
	public void webPropInfo() throws Exception {
		request.setRequestURI("/mag/queryWebPropeInfoPage"); 
        String keys[] = {"jxlogo","jx_chineseName","jx_englishName","record_nums","record_cards","site_domain_name"};
		List<BasicProperty> list = new WebPropertiesServiceImpl().queryWebPropertiesByKeys(keys);
		
		JSONObject result = new JSONObject();
		for(int i=0;i<list.size();i++){
			result.put(list.get(i).getKey(), list.get(i).getValue());
		}
		
		String jxlogo = result.getString("jxlogo");
		if(!Toolkit.isEmpty(jxlogo)){
			String logo = new AttachmentServiceImpl().queryById(Integer.parseInt(jxlogo));
			result.put("logo", logo);
		}
		
		// 执行URI对应的action    
		final ModelAndView mav = this.excuteAction(request, response);
		System.out.println(mav);
		System.out.println(result.size());
	}
}
