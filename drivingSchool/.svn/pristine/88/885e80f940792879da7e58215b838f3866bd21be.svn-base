package com.HuiShengTec.base.action;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.HuiShengTec.utils.Toolkit;

/**
 * 基础类
 * 
 * @author 王泰然
 * 
 */
public class BaseAction {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;

	/**
	 * 自动装填request response
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	/**
	 * 打印JSON
	 * 
	 * @param json
	 * @throws IOException
	 */
	public void printJson(String json) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		OutputStream out = response.getOutputStream();
		out.write(json.getBytes());
	}

	/**
	 * 打印JSON体
	 * 
	 * @param obj
	 * @param pattern
	 * @throws IOException
	 */
	public void printJsonObject(Object obj, String pattern) throws IOException {
		String json = Toolkit.toJson(obj, pattern);
		printJson(json);
	}
	
	/**
	 * JSON输出单词等单独数据
	 * 
	 * @param obj
	 * @throws IOException
	 */
	public void printSingleWordJson(Object obj) throws IOException {
		printJson(String.valueOf(obj));
	}
	/**
	 * 获取客户端IP地址
	 * @param request
	 * @return
	 */
	public String getIpAddr() {  
		return Toolkit.getIpAddr(request);  
    }
	/**
	 * 获取session中的信息
	 * @param key
	 * @return
	 */
	protected Object getSessionData(String key){
		return session.getAttribute(key);
	}
	/**
	 * 向request中推送值
	 * @param key
	 * @param value
	 */
	protected void pushRequestValue(String key,Object value){
		if(!Toolkit.isEmpty(value)){
			request.setAttribute(key, value);
		}
	}
	
	
	/**
	 * 通过反射推送实体内的参数(key为参数名，value为参数值，已转化成String)
	 * @param bean
	 */
	protected void pushValueStack(Object bean){
		try {
			Map<String,String> valueStack = BeanUtils.describe(bean);
			Set<Entry<String, String>> entrySet = valueStack.entrySet();
			for (Entry<String, String> entry : entrySet) {
				if(!entry.getKey().equals("class")){
					pushRequestValue(entry.getKey(), entry.getValue());
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
