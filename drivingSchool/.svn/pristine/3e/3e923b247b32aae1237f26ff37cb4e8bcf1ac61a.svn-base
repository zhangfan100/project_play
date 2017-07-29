package com.HuiShengTec.app.service;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.entity.Picture;

/**
 * 老师图像管理
 * @author llj
 *
 */
public interface ICoachImageService {

	/**
	 * 显示所有老师详情图片
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> queryImages(Map<String, Object> param);
	
	/**
	 * 标记该图片为封面
	 * @param param
	 * @return
	 */
	Integer markOver(Map<String, Object> param);
	
	/**
	 * 根据ID删除图像
	 * @param atts
	 * @param basePath
	 * @return
	 */
	Integer deleteImage(List<Picture> atts, String basePath);
	
	/**
	 * 图像批量保存
	 * @param param
	 * @return
	 */
	Integer saveImages(Map<String, Object> param);
}
