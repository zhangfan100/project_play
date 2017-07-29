package com.HuiShengTec.app.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.ICoachImageDao;
import com.HuiShengTec.app.service.ICoachImageService;
import com.HuiShengTec.entity.CoachPicture;
import com.HuiShengTec.entity.Picture;


/**
 * 老师图像管理
 * @author llj
 *
 */

@Transactional
@Service
public class CoachImageServiceImpl implements ICoachImageService {
	
	@Autowired
	private ICoachImageDao imageDao;
	
	/**
	 * 显示老师所有详情图片
	 * @param param
	 * @return
	 */
	@Override
	public List<Map<String, Object>> queryImages(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return imageDao.queryImages(param);
	}
	
	/**
	 * 标记该图片为封面
	 */
	@Override
	public Integer markOver(Map<String, Object> param) {
		// TODO Auto-generated method stub
		
		//取消该教师的封面标记
		imageDao.markNoConver((Integer)param.get("coachId"));
		
		//指定该图片为封面
		int len = imageDao.markConver((Integer)param.get("rid"));
		
		return len>0?0:1;
	}
	
	
	/**
	 * 根据ID删除图像
	 */
	@Override
	public Integer deleteImage(List<Picture> attsJson,String basePath) {
		// TODO Auto-generated method stub
		
		//删除老师关系图像表数据
		imageDao.deleteTeacherAttachment(attsJson);
		

		//删除图像表数据
		imageDao.deleteImage(attsJson);
		
		//删除目录文件(包括该缩略图及原图)
		for(int i=0;i<attsJson.size();i++){
			String temp = attsJson.get(i).getPath();
			String img = temp.replace("thum/TMP_", "images/IMG_");
			new File(basePath+temp).delete();
			new File(basePath+img).delete();
		}
		return 0;
	}
	
	/**
	 * 图像批量保存
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Integer saveImages(Map<String, Object> param) {
		// TODO Auto-generated method stub
		 List<Picture> atts = (List<Picture>)param.get("list");
		 Integer coachId = (Integer)param.get("coachId");
		for(int i=0;i<atts.size();i++){
			atts.get(i).setType(4);
			imageDao.saveImages(atts.get(i));
			
			CoachPicture ta = new CoachPicture(null, coachId, atts.get(i).getId(), 2);
			imageDao.saveTeacherAttachment(ta);
		}
		return 0;
	}
	

}
