package com.HuiShengTec.app.magAction;

import java.io.IOException;
import java.util.Map;

import com.HuiShengTec.app.core.BaseAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.IFinancialService;
import com.HuiShengTec.app.service.ILoginService;
import com.HuiShengTec.app.service.ISysAdminInfoService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.SysAdminInfo;
import com.HuiShengTec.utils.Toolkit;


/**
 * 管理员管理
 * @author llj
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("mag")
public class SysAdminManageAction extends BaseAction{

	@Autowired
	private ISysAdminInfoService iSysAdminInfoService;
	@Autowired
	private ILoginService iLoginService;
	@Autowired
	private IFinancialService iFinancialService;
	/**
	 * 跳转到管理员管理首页
	 * @return
	 */
	@RequestMapping("sysAdminManage")
	public String SysAdminManage(){
		return "manage/sysAdminManageAction/sysAdminManage";
	}
	
	/**
	 * 分页显示管理员信息
	 * @param info
	 * @param keyWords
	 * @return
	 */
	@RequestMapping("querySysAdminByPage")
	@ResponseBody
	public PageBean querySysAdminByPage(PageInfo info,String keyWords){
		PageBean  pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("keyWords",Toolkit.isEmpty(keyWords)?null:keyWords.trim());
		return iSysAdminInfoService.querySysAdminByPage(pageBean);
	}
	
	@RequestMapping("querySysAdminInfoId")
	public String querySysAdminInfoId(Integer sysAdminId){
		request.setAttribute("sysAdminInfo", iSysAdminInfoService.querySysAdminId(sysAdminId));
		return "manage/sysAdminManageAction/editSysAdminManage";
	}
	/**
	 * 添加账号信息
	 * @return
	 */
	@RequestMapping("addSysAdminInfo")
	@ResponseBody
	public Map<String, Object> addSysAdminInfo(SysAdminInfo info,Login logInfo,Float cash) {
		return iSysAdminInfoService.addSysAdminSbmitInfo(info, logInfo, cash);
	}
	
	
	/**
	 * 修改账号信息
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("editSysAdminSubmit")
	@ResponseBody
	public void editSysAdminSubmit(SysAdminInfo sysAdmininfo,Login login,Integer lId,Integer sysId) throws IOException {
			sysAdmininfo.setId(sysId);
			login.setId(lId);
			Integer row=iLoginService.updateLoginInfo(login);
			if(row>0){
				iSysAdminInfoService.updateSysAdminInfo(sysAdmininfo);
				printSingleWordJson(1);
			}
			printSingleWordJson(0);
		}
	
	/**
	 * 验证账号是否存在
	 * @return
	 */
	@RequestMapping("validateUserName")
	@ResponseBody
	public Integer validateUserName(Login info){
		Integer usernames=iSysAdminInfoService.validateUserName(info);
		if(usernames>0){
			return 1;
		}
		return 0;
	}
	
	/**
	 * 验证邮箱是否存在
	 * @return
	 */
	@RequestMapping("validateEmail")
	@ResponseBody
	public Integer validateEmail(Login info){
		Integer emails=iSysAdminInfoService.validateEmail(info);
		if(emails>0){
			return 1;
		}
		return 0;
	}
	/**
	 * 验证电话是否存在
	 * @return
	 */
	@RequestMapping("validatePhone")
	@ResponseBody
	public Integer validatePhone(String info){
		Integer phones=iSysAdminInfoService.validatePhone(info);
		if(phones>0){
			return 1;
		}
		return 0;
	}
	/**
	 * 激活 禁用
	 * @return
	 */
	@RequestMapping("editStatus")
	@ResponseBody
	public void editStatus(Login data){
		data.setUserId(data.getId());
		data.setStatus(1);
		iSysAdminInfoService.editStatus(data);
	}
	@RequestMapping("updStatus")
	@ResponseBody
	public void updStatus(Login data){
		data.setUserId(data.getId());
		data.setStatus(0);
		iSysAdminInfoService.editStatus(data);
	}
	
	
	
}
