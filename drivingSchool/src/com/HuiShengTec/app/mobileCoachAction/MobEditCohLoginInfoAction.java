package com.HuiShengTec.app.mobileCoachAction;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ILoginService;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.utils.Toolkit;

/**
 * 手机端教员信息管理
 * @author llj
 */
@RestController
@Scope("prototype")
public class MobEditCohLoginInfoAction extends BaseAction{

	@Autowired
	private ILoginService iLoginService;
	
	/**
	 * 修改密码
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("cohMobile/editLogInfoSubmit")
	public HashMap<String, Object> editLogInfoSubmit(String formerPassword, String newPassword) throws IOException {
		Login logininfo = getCurrLoginInfo();
		if(!Toolkit.isEmpty(logininfo)){
			// 对比原密码
			if (!logininfo.getPassword().equals(Toolkit.Md5encode(formerPassword))) {
				//密码不匹配
				return Toolkit.initMapCondition("data", 0);
			}
			// 获取当前登陆信息并保存
			logininfo.setPassword(Toolkit.Md5encode(newPassword));
			logininfo.setRoleType(logininfo.getRoleType());
			iLoginService.updateLoginPassword(logininfo);
			session.setAttribute("logininfo", logininfo);
			//修改成功
			return Toolkit.initMapCondition("data", 2);
		}else{
			//用户没登陆
			return Toolkit.initMapCondition("data", 1);
		}
		
	}

}
