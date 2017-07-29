package com.HuiShengTec.app.magAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ICoachInfoService;
import com.HuiShengTec.app.service.ICoachWeekLessonConfigService;
import com.HuiShengTec.app.service.IFinancialService;
import com.HuiShengTec.app.service.IImageService;
import com.HuiShengTec.base.annotation.Token;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.CoachInfo;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.Picture;
import com.HuiShengTec.utils.Toolkit;

/**
 * 教练管理
 * @author mihuajun
 *
 */

@Controller
@Scope("prototype")
@RequestMapping("mag")
public class CoachManageAction extends BaseAction {
	
	@Autowired
	private ICoachInfoService iCoachInfoService;
	
	@Autowired
	private IImageService iImageService;
	
	@Autowired
	private ICoachWeekLessonConfigService iCoachWeekLessonConfigService;
	
	@Autowired
	private IFinancialService iFinancialService;
	

	/**
	 * 根据关键字搜索教练
	 * @param q
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryCoachByKeyWord")
	public PageBean queryCoachByKeyWord(PageInfo info,String q) {
		PageBean bean = Toolkit.fillPageInfo(info);
		bean.addConditions("keyWord", q);
		return iCoachInfoService.queryCoachByKeyWord(bean);
	}
	
	/**
	 * 显示教练管理页面
	 * @return
	 */
	@RequestMapping("coachManage")
	public String coachManage(){
		return "manage/coachManageAction/coachManage";
	}
	
	/**
	 * 新增教练页
	 * @return
	 */
	@RequestMapping("addCoach")
	@Token(addToken=true)
	public String addCoach(){
		return "manage/coachManageAction/addCoach";
	}
	/**
	 * 修改教练页
	 * @return
	 */
	@RequestMapping("/editCoach")
	@Token(addToken=true)
	public String editCoach(Integer id,Model model){
		model.addAttribute("record",iCoachInfoService.queryCohInfo(id));
		return "manage/coachManageAction/editCoach";
	}
	
	/**
	 * 根据ID，查询教练详情
	 * @param id
	 * @return
	 */
	@RequestMapping("queryCoachInfo")
	public String queryCoachInfo(Integer id,Model model){
		model.addAttribute("record",iCoachInfoService.queryCohInfo(id));
		return "manage/coachManageAction/infoCoach";
	}
	
	/**
	 * 查询驾考教练列表
	 */
	@RequestMapping("/queryDriveCoachPage")
	@ResponseBody
	public List<Map<String,Object>> queryDriveCoachPage(String q,Integer id){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("q", Toolkit.isEmpty(q)?null:q);
		param.put("id", Toolkit.isEmpty(id)?null:id);
		return iCoachInfoService.queryDriveCoachPage(param);
	}
	
	/**
	 * 分页显示教练信息
	 * @param info
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryCoachsByPage")
	public PageBean queryCoachsByPage(PageInfo info,String keyWords){
		PageBean pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("keyWords",Toolkit.isEmpty(keyWords)?null:keyWords.trim());
		iCoachInfoService.queryCoachsByPage(pageBean);
		return pageBean;
	}
	
	/**
	 * 教练信息修改操作
	 * @param coachInfo
	 * @param login
	 * @param pic
	 * @param imgCode
	 * @param infoId
	 * @param loginId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("editCoachSubmit")
	@ResponseBody
	@Token(delToken=true)
	public Integer editCoachSubmit(CoachInfo coachInfo,Login login,Picture pic,String imgCode,Integer flag,Integer infoId,Integer loginId) throws IOException{
		
		coachInfo.setId(infoId);
		coachInfo.setForShort(Toolkit.convertShortPinyin(coachInfo.getName()));
		login.setId(loginId);
		login.setUserId(infoId);
		
		//保存时，判断这两值是否相等，否则保存新的图片
		if(flag!=0){
			//删除原头像
			String basePath = request.getSession().getServletContext().getRealPath("/");
			pic.setId(coachInfo.getPicId());
			List<Picture> list = new ArrayList<Picture>();
			list.add(pic);
			iImageService.deleteImage(list,basePath);
			
			//保存新头像
			String path = flag==1?Toolkit.saveCodeImg(request,imgCode):imgCode;
			pic.setPath(path);
			Integer picId = iImageService.saveImages(pic);
			coachInfo.setPicId(picId);
		}
		
		return iCoachInfoService.updateCoach(coachInfo,login);
	}
	
	/**
	 * 保存教练操作
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("addCoachSubmit")
	@ResponseBody
	@Token(delToken=true)
	public Map<String, Object> addCoachSubmit(CoachInfo coachInfo,Login login,String imgCode,String path,Float cash) throws IOException{
		Map<String , Object> result = iCoachInfoService.addCoachSubmit(coachInfo,login,imgCode,Toolkit.isEmpty(imgCode)?path:Toolkit.saveCodeImg(request,imgCode),cash);
		if(result.get("status").equals(0)){
			iCoachWeekLessonConfigService.addWeeklessonconfig(coachInfo.getId());
		}
		return result;
	}
	
}
