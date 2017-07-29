package com.HuiShengTec.app.mobileStuAction;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ILoginService;
import com.HuiShengTec.app.service.IStuInfoService;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.StudentInfo;
import com.HuiShengTec.utils.Toolkit;

/**
 * 手机移动端接口-学员信息llj
 * 
 * @author
 * 
 */

@RequestMapping("/mobile")
@Controller
@Scope("prototype")
public class MobStuInfoAction extends BaseAction {

	@Autowired
	private ILoginService iLoginService;

	@Autowired
	private IStuInfoService infoService;
	
	@Autowired
	private IStuInfoService iStuInfoService;
	

	/**
	 * 查询学员信息
	 * 
	 * @param data
	 * @param vcode
	 */
	@RequestMapping("queryStuInfo")
	@ResponseBody
	public Map<String, Object> queryStudentInfo(Login login) {
		// 必须参数mobileflag
		if (Toolkit.isEmpty(login.getMobileFlag())) {
			return null;
		}else{
			session.setAttribute("mobileFlag", login.getMobileFlag());
		}
		if (!Toolkit.isEmpty(login.getPassword())) {
			login.setPassword(Toolkit.Md5encode(login.getPassword()));
		}
		// 根据用户名和密码更新mobileFlag
		Integer loginId = iLoginService.updateLoginMobileFlag(login);
		if(loginId==0){
			Map<String, Object> result = new HashMap<String , Object>();
			result.put("status", loginId) ;
			result.put("info", "用户名或者密码错误") ;
			return result;
		}else{
			Map<String, Object> result = new HashMap<String , Object>();
			Map<String, Object> info = infoService.queryStudentInfo(loginId);
			result.put("status", 1) ;
			result.put("info",info);
			return result;
		}
	}

	/**
	 * 修改学员信息
	 * 
	 * @param data
	 * @param vcode
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("editStuInfoSubmit")
	@ResponseBody
	public Map<String, Object> editStuInfoSubmit(StudentInfo info) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		if (!Toolkit.isEmpty(info.getAddress())) {
			infoService.editStudentInfo(info);
			Map<String, Object> data = infoService.queryStudentInfo(getCurrLoginStudent().getId());
			if (!Toolkit.isEmpty(data)) {
				String path = (String) data.get("path");
				data.put("path",Toolkit.isEmpty(path) ? null : request.getContextPath() + path);
				result.put("data",data);
				// 修改成功
				result.put("state", 1);
				return result;
			}else{
				result.put("error", 3);
				return result;
			}
		} else {
			infoService.editStudentInfo(info);
			Map<String, Object> data = infoService.queryStudentInfo(getCurrLoginStudent().getId());
			if (!Toolkit.isEmpty(data)) {
				String path = (String) data.get("path");
				data.put("path",Toolkit.isEmpty(path) ? null : request.getContextPath() + path);
				result.put("data",data);
				// 修改成功
				result.put("state", 1);
				return result;
			}else{
				result.put("error", 3);
				return result;
			}
			
		}
	}
	

	/**
	 * 验证用户名重复性
	 * @return
	 * @throws IOException 
	 * */
	@RequestMapping("validateUserName")
	@ResponseBody
	public HashMap<String, Object> validateUserName(Login username) throws IOException{
		Integer validateName=iStuInfoService.validateUserName(username);
		return Toolkit.initMapCondition("validate", validateName==0?0:1);
		
	}
	
	/**
	 * 验证身份证
	 * @return
	 * @throws IOException 
	 * */
	@RequestMapping("validateCode")
	@ResponseBody
	public HashMap<String, Object> validateCode(StudentInfo licenceCode) throws IOException{
		Integer licencecode=iStuInfoService.validateCode(licenceCode);
		return Toolkit.initMapCondition("validate", licencecode==0?0:1);
	}
	
	/**
	 * 验证邮箱重复性
	 * @return
	 * */
	@RequestMapping("validateEmail")
	@ResponseBody
	public HashMap<String, Object> validateEmail(Login email){
		Integer Email=iStuInfoService.validateEmail(email);
		return Toolkit.initMapCondition("validate", Email==0?0:1);
		
	}
			
	/**
	 * 注册学生信息提交
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("registerStuSbmitInfo")
	@ResponseBody
	public HashMap<String, Object> registerStuSbmit(StudentInfo info,Login loginfo) {
		if((!Toolkit.isEmpty(info)||!Toolkit.isEmpty(loginfo))){
			loginfo.setLoginCount(0);
			loginfo.setRoleId(1);
			loginfo.setStatus(1);
			loginfo.setPassword(Toolkit.Md5encode(loginfo.getPassword()));
			Integer count=iStuInfoService.registerStudent(info, loginfo);
			return Toolkit.initMapCondition("count",count);
		}else{
			return Toolkit.initMapCondition("count",0);
		}
	}
}
