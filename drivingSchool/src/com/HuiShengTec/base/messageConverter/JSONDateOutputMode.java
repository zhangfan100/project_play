package com.HuiShengTec.base.messageConverter;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 控制JSON日期输出模式
 * @author 王泰然
 *
 */
public class JSONDateOutputMode {
	public static final int simpleDateMode = 1;
	public static final int dateTimeMode = 2;


	public static void setJSONDateOutputMode(int mode) {
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession();
		session.setAttribute("JSONMode", mode);

	}
	public static void setJSONDateToDateMode() {
		JSONDateOutputMode
				.setJSONDateOutputMode(JSONDateOutputMode.simpleDateMode);
	}
	public static void setJSONDateToTimeMode() {
		JSONDateOutputMode
				.setJSONDateOutputMode(JSONDateOutputMode.dateTimeMode);
	}
}
