package com.HuiShengTec.app.publicAction;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.ICarBrandService;
import com.HuiShengTec.app.service.IDrivingLicenceService;
import com.HuiShengTec.app.service.IMapMarkService;
import com.HuiShengTec.app.service.ISceneService;
import com.HuiShengTec.base.action.BaseAction;
import com.HuiShengTec.entity.CarBrand;
import com.HuiShengTec.entity.DrivingLicence;
import com.HuiShengTec.utils.Toolkit;
import com.HuiShengTec.utils.VerificationCodeUtil;
import com.alibaba.fastjson.JSONObject;

@Controller
@Scope("prototype")
public class PublicUtilAction extends BaseAction {
	@Autowired
	private ICarBrandService iCarBrandService;
	@Autowired
	private IDrivingLicenceService iDrivingLicenceService;
	
	@Autowired
	private ISceneService iSceneService;
	
	@Autowired
	private IMapMarkService iMapMarkService;
	
	
	
	/**
	 * 输出验证码
	 * @throws Exception
	 */
	@RequestMapping("getVerificationCode")
	public void getVerificationCode() throws Exception {
		VerificationCodeUtil util = VerificationCodeUtil.Instance();
		InputStream is = util.getImage();
		String vcode =util.getVerificationCodeValue();
		session.setAttribute("vcode", vcode);
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "no-cache");
		OutputStream out = response.getOutputStream();
		int c;
		while((c=is.read())!=-1)
        {
			out.write(c);
        }
	}
	
	/**
	 * 查询所有启用的驾照类型
	 * @author mihuajun
	 * @createTime 2014-11-6 上午12:44:52
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryCurrLicenceList")
	public List<DrivingLicence> queryCurrLicenceList(){
		return iDrivingLicenceService.queryCurrentDrivingLicence();
	}
	
	@ResponseBody
	@RequestMapping("queryCurrCarBrand")
	public List<CarBrand> queryCurrCarBrand(){
		return iCarBrandService.queryCarBrand();
	}
	
	/**
	 * 
	 * @Description: TODO(手机端查看所有电子围栏标记)
	 * @author [llj]
	 */
	@ResponseBody
	@RequestMapping("queryAllSceneInfo")
	public List<Map<String, Object>> queryAllSceneInfo(){
		return iSceneService.getAllScenes();
	}
	
	/**
	 * 
	 * @Description: TODO(手机端插入电子围栏标记)
	 * @author [llj]
	 */
	@ResponseBody
	@RequestMapping("addSceneInfo")
	public Map<String, Object> addSceneInfo(@RequestParam Map<String, Object> param){
		Map<String, Object> result=new HashMap<String, Object>();
		if(!Toolkit.isEmpty(param)){
			iMapMarkService.saveMapMarkInfo(param);
			result.put("status", 1);
		}else{
			result.put("status",0);
		}
		return result;
	}	
	
}
