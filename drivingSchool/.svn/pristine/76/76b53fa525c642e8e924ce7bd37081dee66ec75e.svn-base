package com.HuiShengTec.app.magAction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.utils.PushletUtil;
/**
 * GPS地址推送
 * @author wtr
 *
 */

@Controller
@RequestMapping("/mag")
@Scope("prototype")
public class GpsAddrAction extends BaseAction {

	
	/***
	 * 测试推送数据
	 * @param data
	 */
	@RequestMapping("/pushGpsData")
	public void pushGpsData(String data){
		PushletUtil.addPushData("message",data);
	}
}
