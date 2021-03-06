package com.HuiShengTec.app.cohAction;

import java.io.IOException;
import com.HuiShengTec.app.core.BaseAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.ILoginService;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.utils.Toolkit;

/**
 * 教员信息管理
 * 
 * @author llj
 * 
 */
@Controller
@Scope("prototype")
public class EditCoachLoginInfoAction extends BaseAction {

	@Autowired
	private ILoginService iLoginService;

	/**
	 * 登陆信息跳转
	 * */
	@RequestMapping("coh/coachLoginInfo")
	public String coachLoginInfo() {
		return "coach/loginAction/editCoachLoginInfo";
	}

	/**
	 * 修改密码
	 * 
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("coh/editLogInfoSubmit")
	public void editLogInfoSubmit(String formerPassword, String newPassword,
			String vCode) throws IOException {
		Login logininfo = getCurrLoginInfo();
		if(!Toolkit.isEmpty(logininfo)){
			// 验证码判断
			if (!session.getAttribute("vcode").equals(vCode)
					|| (Toolkit.isEmpty(vCode))) {
				printSingleWordJson(2);
				return;
			}
			// 看原密码是否正确
			if (!logininfo.getPassword().equals(Toolkit.Md5encode(formerPassword))) {
				printSingleWordJson(0);
				return;
			}
			// 看新密码和旧密码是否一致 一致的话同样给出相应提示
			if (Toolkit.Md5encode(formerPassword).equals(Toolkit.Md5encode(newPassword))) {
				printSingleWordJson(3);
				return;
			}
			// 获取当前登陆信息并保存
			logininfo.setPassword(Toolkit.Md5encode(newPassword));
			logininfo.setRoleType(logininfo.getRoleType());
			iLoginService.updateLoginPassword(logininfo);
			session.setAttribute("logininfo", logininfo);
			printSingleWordJson(1);
		}else{
			printSingleWordJson(0);
			return;
		}
		
	}
}
