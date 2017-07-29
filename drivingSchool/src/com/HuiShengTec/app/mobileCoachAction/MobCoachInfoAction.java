package com.HuiShengTec.app.mobileCoachAction;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ICoachInfoService;
import com.HuiShengTec.app.service.ILoginService;
import com.HuiShengTec.entity.CoachInfo;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.utils.Toolkit;

/**
 * 手机移动端接口-教员信息
 * llj
 * @author
 */

@RequestMapping("/cohMobile")
@RestController
@Scope("prototype")
public class MobCoachInfoAction extends BaseAction{
	
	@Autowired
	private ILoginService iLoginService;
	@Autowired
	private ICoachInfoService iCoachInfoService;
	
	/**
	 * 教员登陆查询个人信息
	 * 
	 * @param data
	 * @param vcode
	 */
	@RequestMapping("queryCoachInfo")
	public Map<String, Object> queryCoachInfo(Login coachInfo){
		// 必须参数mobileflag
		if (Toolkit.isEmpty(coachInfo.getMobileFlag())) {
				return null;
			}
		if (!Toolkit.isEmpty(coachInfo.getPassword())) {
				coachInfo.setPassword(Toolkit.Md5encode(coachInfo.getPassword()));
			}
		// 根据用户名和密码更新mobileFlag
		Integer cohId = iLoginService.updateLoginMobileFlag(coachInfo);		
		if (cohId == 0) {
			Map<String, Object> result = new HashMap<String , Object>();
			result.put("status", cohId) ;
			result.put("info", "用户名或者密码错误") ;
			return result;
		}else{
			Map<String, Object> result = iCoachInfoService.queryMobCohInfoCount(cohId);
			String path = (String) result.get("path");
			result.put("path",Toolkit.isEmpty(path) ? null : request.getContextPath() + path);
			return Toolkit.initMapCondition("result", result);
		}
	}
	/**
	 * 修改教练员信息
	 * @param info
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("editCoachInfoSubmit")
	public Map<String, Object> editCoachInfoSubmit(CoachInfo info) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		if (!Toolkit.isEmpty(info.getAddress())) {
			iCoachInfoService.editCoachInfo(info);
			Map<String, Object> data = iCoachInfoService.queryCohInfo(getCurrLoginCoach().getId());
			if (!Toolkit.isEmpty(data)) {
				String path = (String) data.get("path");
				data.put("path",Toolkit.isEmpty(path) ? null : request.getContextPath() + path);
				result.put("data",data);
				// 地址修改成功
				result.put("state", 1);
				return Toolkit.initMapCondition("result", result);
			}else{
				result.put("error", 3);
				return Toolkit.initMapCondition("result", result);
			}
		} else {
			iCoachInfoService.editCoachInfo(info);
			Map<String, Object> data = iCoachInfoService.queryCohInfo(getCurrLoginCoach().getId());
			if (!Toolkit.isEmpty(data)) {
				String path = (String) data.get("path");
				data.put("path",Toolkit.isEmpty(path) ? null : request.getContextPath() + path);
				result.put("data",data);
				// 电话修改成功
				result.put("state", 1);
				return Toolkit.initMapCondition("result", result);
			}else{
				result.put("error", 3);
				return Toolkit.initMapCondition("result", result);
			}
			
		}
	}
}
