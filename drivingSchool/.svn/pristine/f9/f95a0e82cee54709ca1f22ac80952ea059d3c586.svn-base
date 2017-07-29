package com.HuiShengTec.app.dao;

import java.util.List;
import java.util.Map;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.entity.CoachPicture;
import com.HuiShengTec.entity.Picture;

public interface ICoachImageDao extends IBaseDao {
	
	/**
	 * 显示老师所有详情图片
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> queryImages(Map<String, Object> param);
	
	/**
	 * 取消该教师的封面标记
	 * @param string
	 * @return
	 */
	Integer markNoConver(Integer teaId);
	
	/**
	 * 指定该图片为封面
	 * @param string
	 * @return
	 */
	Integer markConver(Integer rid);
	
	/**
	 * 删除图像表数据
	 * @param atts
	 * @return
	 */
	Integer deleteImage(List<Picture> atts);

	/**
	 * 删除老师关系图像表数据
	 * @param atts
	 * @return
	 */
	Integer deleteTeacherAttachment(List<Picture> atts);
	
	
	/**
	 * 保存图像表数据
	 * @param attachment
	 * @return
	 */
	Integer saveImages(Picture picture);
	
	/**
	 * 保存老师关系图像表数据
	 * @param ta
	 */
	Integer saveTeacherAttachment(CoachPicture ta);
	

}
