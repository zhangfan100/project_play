package com.HuiShengTec.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import opensource.jpinyin.PinyinHelper;
import Decoder.BASE64Decoder;

import com.HuiShengTec.base.cache.PropertiesCache;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.alibaba.fastjson.JSON;

/**
 * 工具类
 * 
 * @author 王泰然
 * 
 */
public class Toolkit {
	public static String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
	public static String datePattern = "yyyy-MM-dd";

	/**
	 * 判断是否为空的方法
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		return obj == null || "null".equals(obj)
				|| "undefined".equals(obj) || "".equals(obj.toString().trim());
	}

	/**
	 * 转化JSON
	 * 
	 * @param obj
	 * @param pattern
	 * @return
	 */
	public static String toJson(Object obj, String pattern) {
		if (Toolkit.isEmpty(pattern)) {
			pattern = Toolkit.datePattern;
		}
		return JSON.toJSONStringWithDateFormat(obj, pattern);
	}

	/**
	 * 解析JSON 转化成列表
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> jsonToList(String json, Class<T> clazz) {
		return JSON.parseArray(json, clazz);
	}

	/**
	 * 解析JSON转化成JAVABEAN
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T jsonToObject(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}
	/**
	 * MD5加密工具
	 * @param password
	 * @return
	 */
	public static String Md5encode(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 生成带页码信息的pageBean
	 * @param info
	 * @return
	 */
	public static PageBean fillPageInfo(PageInfo info){
		PageBean page = new PageBean();
		page.setPageSize(info.getRows()==null?10:info.getRows());
		page.setPageNumber(info.getPage()==null?1:info.getPage());
		if(!Toolkit.isEmpty(info.getConditions())){
			page.setConditions(info.getConditions());
		}
		return page;
	}
	
	
	/**
	 * 根据日期与随机数，生成随机字符串
	 * @return
	 */
	public static String RandomStr(){
		  DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
		  String formatDate = format.format(new Date());
		// 随机生成文件编号
		  int random = new Random().nextInt(10000);
		  return new StringBuffer().append(formatDate).append(
				  random).toString();
	 }
	
	/**
	 * 返回中文字符首字母拼音
	 * @param str
	 * @return
	 */
	public static String convertShortPinyin(String str){
		return PinyinHelper.getShortPinyin(str);
	}
	
	public static Date getDateWithoutTime(Date date) throws ParseException{
		DateFormat fmt = new SimpleDateFormat(datePattern);
		return fmt.parse(fmt.format(date));
	}
	
	public static Date getCurrDateWithoutTime()throws ParseException{
		return getDateWithoutTime(new Date());
	}
	
	public static String getIpAddr(HttpServletRequest request) {  
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getRemoteAddr();
		}
		return ip;  
    }
	
	/**
	 * 创建目录
	 * @param directory
	 */
	public static void buildDirectory(String directory){
		File dir = new File(directory);
		if(!dir.exists()){
			dir.mkdirs();
		}
	}
	
	/**
	 * 保存学生头像
	 * @param request
	 * @param imgCode
	 * @return
	 * @throws IOException
	 */
	public static String saveCodeImg(HttpServletRequest request, String imgCode) throws IOException {
		// TODO Auto-generated method stub
		String path = request.getSession().getServletContext().getRealPath("");
		String uri = "/"+PropertiesCache.getValue("stu-head-path")+"/";
		String fileName = Toolkit.RandomStr()+".jpg";
		Toolkit.buildDirectory(path+uri);
		FileOutputStream out = new FileOutputStream(new File(path+uri+fileName));
		BASE64Decoder bd = new BASE64Decoder();
		out.write(bd.decodeBuffer(imgCode));
		out.flush();
		out.close();
		return (uri+fileName).replaceAll("//", "/");
	}
	
	public static Date formatDate(String dateStr,String pattern)throws ParseException{
		if(Toolkit.isEmpty(pattern)){
			pattern=Toolkit.datePattern;
		}
		DateFormat fmt = new SimpleDateFormat(pattern);
		return fmt.parse(dateStr);
	}
	public static String parseDate(Date date,String pattern){
		if(Toolkit.isEmpty(pattern)){
			pattern=Toolkit.datePattern;
		}
		DateFormat fmt = new SimpleDateFormat(pattern);
		return fmt.format(date);
	}
	
	public static HashMap<String,Object> initMapCondition(String key,Object value){
		HashMap<String,Object> result = new HashMap<>();
		result.put(key, value);
		return result;
	}
	
	public static HashMap<String,Object> getMapStatus(Integer status){
		return Toolkit.initMapCondition("status", status);
	}
}
