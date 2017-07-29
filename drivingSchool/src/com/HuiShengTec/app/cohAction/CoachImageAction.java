package com.HuiShengTec.app.cohAction;

import java.util.HashMap;
import com.HuiShengTec.app.core.BaseAction;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.ICoachImageService;
import com.HuiShengTec.entity.Picture;
import com.alibaba.fastjson.JSON;

/**
 * 
 * 教师图像管理
 * @author llj
 *
 */
@RequestMapping("coh")
@Controller
public class CoachImageAction extends BaseAction{
	@Autowired
	private ICoachImageService iCoachImageService;
	/**
	 * 图片管理页
	 * @return
	 */
	@RequestMapping("/imageCoach")
	public String view(){
		return "coach/coachImageAction/imageCoach";
	}
	/**
	 * 图片管理页
	 * @return
	 */
	@RequestMapping("/addImage")
	public String addImage(){
		return "coach/coachImageAction/addImage";
	}
	/**
	 * 根据ID删除图像
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/deleteImage",method=RequestMethod.POST)
	@ResponseBody
	public Integer deleteImage(String attsJson){
		String basePath = request.getSession().getServletContext().getRealPath("/");
		List<Picture> list = JSON.parseArray(attsJson, Picture.class);
		return iCoachImageService.deleteImage(list,basePath);
	}
	
	/**
	 *图像批量保存
	 * @param atts
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveImages",method=RequestMethod.POST)
	public Integer saveImages(String attsJson){
		 List<Picture> list = JSON.parseArray(attsJson, Picture.class);
		 Map<String,Object> param = new HashMap<String,Object>();
		 param.put("list", list);
		 param.put("coachId",getCurrLoginCoach().getId());
		 return iCoachImageService.saveImages(param);
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
	public List<Map<String, Object>> queryImages(){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("coachId", getCurrLoginCoach().getId());
		return iCoachImageService.queryImages(param);
	}
	
	/**
	 * 标记为封面
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/markOver")
	public Integer markOver(Integer rid){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("coachId",getCurrLoginCoach().getId());
		param.put("rid", rid);
		return iCoachImageService.markOver(param);
	}
}
