package com.HuiShengTec.app.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IImageDao;
import com.HuiShengTec.app.service.IImageService;
import com.HuiShengTec.base.cache.PropertiesCache;
import com.HuiShengTec.entity.Picture;

/**
 * 图像管理
 * @author mihuajun
 *
 */

@Transactional
@Service
public class ImageServiceImpl implements IImageService {
		
	@Autowired
	private IImageDao iImageDao;
	
	/**
	 * 根据ID删除图像
	 */
	@Override
	public void deleteImage(List<Picture> atts,String basePath) {
		// TODO Auto-generated method stub
		iImageDao.deleteImage(atts);
		
		//删除目录文件(包括该缩略图及原图)
		for(int i=0;i<atts.size();i++){
			String temp = atts.get(i).getPath();
			String img = temp.replace("thum/TMP_", "images/IMG_");
			new File(basePath+temp).delete();
			new File(basePath+img).delete();
		}
	}
	
	/**
	 * 编辑图像-更名
	 */
	@Override
	public Integer editImage(Picture atta) {
		// TODO Auto-generated method stub
		return iImageDao.editImage(atta)>0?0:1;
	}
	
	/**
	 * 根据：开始时间-截至时间-描述信息查询图像
	 */
	@Override
	public List<Picture> queryImages(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return iImageDao.queryImages(params);
	}
	
	/**
	 * 图像批量保存
	 */
	@Override
	public void saveImages(List<Picture> atts) {
		// TODO Auto-generated method stub
		for(int i=0;i<atts.size();i++){
			iImageDao.saveImages(atts.get(i));
		}
	}
	
	/**
	 * 单图像保存
	 */
	
	@Override
	public Integer saveImages(Picture att) {
		// TODO Auto-generated method stub
		iImageDao.saveImages(att);
		return att.getId();
	}
	
	/**
	 * 根据ID获取数据
	 */
	@Override 
	public Picture queryImage(Integer id){
		return iImageDao.queryImage(id);
	}
	
	/**
	 * 同步图像操作
	 */
	@Override
	public void syncImg(String baseLocalPath) {
		// TODO Auto-generated method stub
		List<String> atts = iImageDao.queryImagesAttPath();
		
		String imgPath = PropertiesCache.getValue("imgPath");
		String thumPath = PropertiesCache.getValue("thumPath");
		File folder1 = new File(baseLocalPath+imgPath);
		File folder2 = new File(baseLocalPath+thumPath);
		String[] files1 = folder1.list();
		String[] files2 = folder2.list();
		
		///attchment/thum/TMP_2014083010093205901915.jpg
		List<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList(files1));
		list.addAll(Arrays.asList(files2));
		
		
		//去重
		for(int i=0;i<list.size();i++){
			list.set(i, list.get(i).substring(list.get(i).indexOf("_")+1));
		}
		HashSet<String> h = new HashSet<String>(list);
		list.clear();
		list.addAll(h);
		
			
		//同步
		for(String name:list){
			if(!atts.contains(name)){
				new File(baseLocalPath+imgPath+"IMG_"+name).delete();
				new File(baseLocalPath+thumPath+"TMP_"+name).delete();
			}
		}
		
	}
	
}
