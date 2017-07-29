package com.HuiShengTec.app.froAction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mihuajun
 * @createTime 2014-11-24 上午11:52:59
 */
@Controller
public class ErrorPage {
	
	@RequestMapping("/404")
	public String e404(){
		return "/error/404";
	}
	
	@RequestMapping("/403")
	public String e403(){
		return "/error/403";
	}
}
