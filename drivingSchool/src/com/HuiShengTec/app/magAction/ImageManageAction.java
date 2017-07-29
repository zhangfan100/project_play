package com.HuiShengTec.app.magAction;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.IAttachmentService;
import com.HuiShengTec.app.service.IImageService;
import com.HuiShengTec.base.action.BaseAction;
import com.HuiShengTec.base.cache.PropertiesCache;
import com.HuiShengTec.entity.Picture;
import com.alibaba.fastjson.JSON;

/**
 * 图像管理
 * @author mihuajun
 *
 */
@Controller
@RequestMapping("/mag")
@Scope("prototype")
public class ImageManageAction extends BaseAction {
	
	@Autowired
	private IImageService imageService;
	@Autowired
	private IAttachmentService iAttachmentService;
	/**
	 * 跳转至图像管理页
	 * @return
	 */
	@RequestMapping("/imageManage")
	public String imageManage(){
		return "manage/imageManageAction/imageManage";
	}
	
	/**
	 * 转到至图像上传页
	 * @return
	 */
	@RequestMapping("/addImage")
	public String addImage(){
		return "manage/imageManageAction/addImage";
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
		imageService.deleteImage(list,basePath);

		//刷新图片缓存
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("type", 1);
		session.setAttribute("ads_photoPath", imageService.queryImages(params));
		return 0;
	}
	
	/**
	 * 删除临时图像文件，（只保存在了本地，未保存attachement对象到数据库）
	 */
	@RequestMapping("/deleteTempImage")
	@ResponseBody
	public Integer deleteTempImage(String urlPath[]){
		String baseLocalPath = request.getSession().getServletContext().getRealPath("/");
		
		String imgPath = PropertiesCache.getValue("imgPath");
		String thumPath = PropertiesCache.getValue("thumPath");
		
		for(int i=0;i<urlPath.length;i++){
			String fileName = urlPath[i].substring(urlPath[i].lastIndexOf(".")+1);
			new File(baseLocalPath+imgPath+fileName).delete();	//删除真实文件
			new File(baseLocalPath+thumPath+fileName).delete();	//删除临时文件
		}
		return 0;
	}
	
	/**
	 * 编辑图像-更名
	 * @param Atta
	 * @return
	 */
	@RequestMapping("/editImage")
	@ResponseBody
	public Integer editImage(Picture atta){
		return imageService.editImage(atta);
	}
	
	/**
	 * 根据：开始时间-截至时间-描述信息查询图像
	 * @param staDate
	 * @param endDate
	 * @param title
	 * @return
	 */
	@RequestMapping("/queryImages")
	@ResponseBody
	public List<Picture> queryImages(String beginDate,String endDate,String title,Integer kind){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("beginDate", beginDate==null?null:beginDate.trim().isEmpty()?null:beginDate.trim());
		params.put("endDate", endDate==null?null:endDate.trim().isEmpty()?null:endDate.trim());
		params.put("type", kind);
		
		return imageService.queryImages(params);
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
		imageService.saveImages(list);
		
		//刷新图片缓存
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("type", 1);
		session.setAttribute("ads_photoPath", imageService.queryImages(params));
		return 0;
	}
	
}
