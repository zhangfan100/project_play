package com.HuiShengTec.app.mobileCoachAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ICoachImageService;
import com.HuiShengTec.entity.Picture;
import com.HuiShengTec.utils.Toolkit;
import com.alibaba.fastjson.JSON;
/**
 * 
 * 手机端教师图片管理
 * @author llj
 *
 */
@RequestMapping("cohMobile")
@Controller
public class MobCohImageAction extends BaseAction{
	
	@Autowired
	private ICoachImageService iCoachImageService;
	
	/**
	 * 根据ID删除图像
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/deleteImage",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> deleteImage(String attsJson){
		String basePath = request.getSession().getServletContext().getRealPath("/");
		List<Picture> list = JSON.parseArray(attsJson, Picture.class);
		 Integer count=iCoachImageService.deleteImage(list,basePath);
		return Toolkit.initMapCondition("count", count);
	}
	
	/**
	 *图像批量保存
	 * @param atts
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveImages",method=RequestMethod.POST)
	public HashMap<String, Object> saveImages(String attsJson){
		 List<Picture> list = JSON.parseArray(attsJson, Picture.class);
		 Map<String,Object> param = new HashMap<String,Object>();
		 param.put("list", list);
		 param.put("coachId",getCurrLoginCoach().getId());
		 Integer count=iCoachImageService.saveImages(param);
		 return Toolkit.initMapCondition("count", count);
	}
	

	/**
	 * 根据：显示所有老师详情图片
	 * @param staDate
	 * @param endDate
	 * @param title
	 * @return
	 */
	@RequestMapping("/queryImages")
	@ResponseBody
	public HashMap<String, Object> queryImages(){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("coachId", getCurrLoginCoach().getId());
		List<Map<String, Object>> data=iCoachImageService.queryImages(param);
		return Toolkit.initMapCondition("data", data);
	}
	
	/**
	 * 标记为封面
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/markOver")
	public HashMap<String, Object> markOver(Integer rid){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("coachId",getCurrLoginCoach().getId());
		param.put("rid", rid);
		Integer count=iCoachImageService.markOver(param);
		return Toolkit.initMapCondition("count", count);
	}

}
