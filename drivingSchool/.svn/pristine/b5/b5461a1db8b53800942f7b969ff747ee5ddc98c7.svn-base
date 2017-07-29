package com.HuiShengTec.app.service;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.entity.Picture;

/**
 * 图像管理
 * @author mihuajun
 *
 */
public interface IImageService {
	
	
	/**
	 * 编辑图像-更名
	 * @param atta
	 * @return
	 */
	Integer editImage(Picture atta);
	
	/**
	 * 根据：开始时间-截至时间-描述信息查询图像
	 * @param params
	 * @return
	 */
	List<Picture> queryImages(Map<String, Object> params);
	
	/**
	 * 根据ID删除图像
	 */
	void deleteImage(List<Picture> list, String basePath);
	
	/**
	 * 图像批量保存
	 * @param list
	 * @return
	 */
	void saveImages(List<Picture> list);
	
	/**
	 * 同步图像操作
	 */
	void syncImg(String baseLocalPath);
	
	/**
	 * 单图像保存
	 * @param att
	 * @return
	 */
	Integer saveImages(Picture att);

	Picture queryImage(Integer id);

}
