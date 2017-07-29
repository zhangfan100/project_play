package com.HuiShengTec.app.magAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.IMagInfoService;
import com.HuiShengTec.base.action.BaseAction;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.SysAdminInfo;
import com.HuiShengTec.utils.Toolkit;

/**
 * 管理员信息处理类
 * @author mihuajun
 *
 */

@Controller
@RequestMapping("mag")
public class MagInfoAction extends BaseAction {
	
	@Autowired
	private IMagInfoService iMagInfoService;

	/**
	 * 跳转至编辑管理员信息界面
	 * @return
	 */
	@RequestMapping("editMagInfo")
	public String editMagInfo(){
		return "manage/magInfoAction/editMagInfo";
	}
	
	/**
	 * 跳转至管理员密码修改
	 * @return
	 */
	@RequestMapping("editMagPassword")
	public String editMagPassword(){
		return "manage/magInfoAction/editMagLoginInfo";
	}
	
	/**
	 * 提交编辑信息(管理员信息的编辑)
	 * @param userInfo
	 * @return
	 */
	@RequestMapping("editMagInfoSubmit")
	@ResponseBody
	public Integer editMagInfoSubmit(SysAdminInfo userInfo){
		SysAdminInfo newInfo = iMagInfoService.editMagInfoSubmit(userInfo);
		if(newInfo == null){
			return 1;
		}
		request.getSession().setAttribute("userInfo", newInfo);
		return 0;
	}
	
	/**
	 * 修改密码
	 * @param formerPassword
	 * @param newPassword
	 * @return
	 */
	@RequestMapping("editMagPasswordSubmit")
	@ResponseBody
	public Integer updateMagPassword(String formerPassword,String newPassword,String verfi_code){
		Login userInfo = (Login) request.getSession().getAttribute("loginInfo");
		
		
		String sessionVcode = (String) session.getAttribute("vcode");
		
		// 验证码错误
		if ((Toolkit.isEmpty(verfi_code)) || (!verfi_code.equals(sessionVcode))) {
			return 3;
		}
		
		//填写的密码与原始密码不匹配
		if(!userInfo.getPassword().equals(Toolkit.Md5encode(formerPassword))){
			return 1;
		}
		
		Login newLogin = new Login();
		newLogin.setPassword(Toolkit.Md5encode(newPassword));
		newLogin.setId(userInfo.getId());
		
		Integer status = iMagInfoService.updateMagPassword(newLogin);
		
		//将修改后的密码植入session中
		if(status==0){
			userInfo.setPassword(Toolkit.Md5encode(newPassword));
		}
		return  status;
		
	}
	
}
