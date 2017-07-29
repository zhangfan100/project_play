package com.HuiShengTec.app.stuAction;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.IStuInfoService;
import com.HuiShengTec.base.annotation.Token;
import com.HuiShengTec.base.cache.PropertiesCache;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.StudentInfo;
import com.HuiShengTec.utils.Toolkit;

/**
 * 学生账号  信息注册
 * @author llj
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("stu")
public class StuLoginInfoAction extends BaseAction{
	@Autowired
	private IStuInfoService iStuInfoService;
	
	
	@RequestMapping("registerStu")
	@Token(addToken=true)
	public String registerStu(){
		PropertiesCache.fillRequestParam(request);
		return "student/studentRegisterAction/registerStudentInfo";
	}
	
	/**
	 * 验证用户名重复性
	 * @return
	 * @throws IOException 
	 * */
	@RequestMapping("validateUserName")
	@ResponseBody
	public int validateUserName(Login username) throws IOException{
		int validateName=iStuInfoService.validateUserName(username);
		if(validateName==0){
			return 0;
		}else{
			return 1;
		}
	}
	
	/**
	 * 验证身份证
	 * @return
	 * @throws IOException 
	 * */
	@RequestMapping("validateCode")
	@ResponseBody
	public int validateCode(StudentInfo licenceCode) throws IOException{
		return iStuInfoService.validateCode(licenceCode);
	}
	
	/**
	 * 验证邮箱重复性
	 * @return
	 * */
	@RequestMapping("validateEmail")
	@ResponseBody
	public int validateEmail(Login email){
		return iStuInfoService.validateEmail(email);
		
	}
			
	/**
	 * 注册学生信息提交
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("registerStuSbmitInfo")
	@ResponseBody
	@Token(delToken=true)
	public Integer registerStuSbmit(StudentInfo info,Login loginfo) {
		if((!Toolkit.isEmpty(info)||!Toolkit.isEmpty(loginfo))){
			loginfo.setLoginCount(0);
			loginfo.setRoleId(1);
			loginfo.setStatus(0);
			loginfo.setPassword(Toolkit.Md5encode(loginfo.getPassword()));
			iStuInfoService.registerStudent(info, loginfo);
			return 1;
		}else{
			return 0;
		}
	}
}
