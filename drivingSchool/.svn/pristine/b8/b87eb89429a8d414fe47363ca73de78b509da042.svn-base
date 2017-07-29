package com.HuiShengTec.app.cohAction;

import java.io.IOException;
import com.HuiShengTec.app.core.BaseAction;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HuiShengTec.app.service.ICoachInfoService;
import com.HuiShengTec.app.service.IImageService;
import com.HuiShengTec.entity.CoachInfo;
import com.HuiShengTec.entity.Picture;
import com.HuiShengTec.utils.Toolkit;

/**
 * 教员信息管理
 * @author llj
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("coh")

public class CoachInfoAction extends BaseAction{
	@Autowired
	private IImageService iImageService;
	@Autowired
	private ICoachInfoService iCoachInfoService;
	
	/**
	 * 用户信息修改跳转
	 * */
	@RequestMapping("cohInfo")
	public String editCoachInfo(){
		request.setAttribute("att", iImageService.queryImage((getCurrLoginCoach().getPicId())));
		return "coach/cohInfoAction/editCohInfo";
	}
	
	/**
	 * 用户图片修改
	 * */
	@RequestMapping("editCoachPhoto")
	public String editCoachPhone(){
		return "teacherInfoAction/editTeacherPhoto";
	}
	
	
	/**
	 * 教员信息修改提交
	 * @throws IOException 
	 */
	@RequestMapping("editCoachInfoSubmit")
	public void editCoachInfoSubmit(CoachInfo cohInfo,String newCoachImg,String oldCoachImg) throws IOException{
		
		Picture at = new Picture();
		at.setId(cohInfo.getPicId());
		at.setPath(oldCoachImg);
		
		if(!Toolkit.isEmpty(newCoachImg)){
			//调用接口修改当前图像
			Picture att = new Picture();
			att.setPath(newCoachImg);
			att.setType(4);
			Integer imgId = iImageService.saveImages(att);
			cohInfo.setPicId(imgId);
		}
		
		iCoachInfoService.editCoachInfo(cohInfo);
		
		if(!Toolkit.isEmpty(newCoachImg)){

			//调用接口删除原图片
			if(cohInfo.getPicId()!=null){
				List<Picture> imgs = new ArrayList<Picture>();
				imgs.add(at);
				iImageService.deleteImage(imgs, session.getServletContext().getRealPath(""));
			}
		}
		
		//更新SESSION 信息
		session.setAttribute("userInfo", iCoachInfoService.queryCoachInfo(cohInfo.getId()));
		printSingleWordJson(1);
	}
	
}
	