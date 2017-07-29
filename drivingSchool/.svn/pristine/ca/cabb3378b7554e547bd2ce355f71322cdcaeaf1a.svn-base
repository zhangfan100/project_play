package com.HuiShengTec.app.dao;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.entity.Picture;

/**
 * 图像管理
 * @author mihuajun
 *
 */
public interface IImageDao extends IBaseDao{
	
	/**
	 * 根据ID删除图像
	 * @param atts
	 * @return
	 */
	Integer deleteImage(List<Picture> atts);
	
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
	 * 图像保存
	 * @param attachment
	 */
	Integer saveImages(Picture attachment);
	
	/**
	 * 查询所有图像attPath
	 * @return
	 */
	List<String> queryImagesAttPath();

	Picture queryImage(Integer id);

}
