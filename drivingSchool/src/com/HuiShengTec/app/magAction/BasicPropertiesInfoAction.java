package com.HuiShengTec.app.magAction;


import java.io.IOException;
import com.HuiShengTec.app.core.BaseAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.IBasicPropertiesService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.BasicProperty;
import com.HuiShengTec.utils.Toolkit;

/**
 * 基础信息管理
 * @author llj
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("mag")
public class BasicPropertiesInfoAction extends BaseAction{
	
	@Autowired
	private IBasicPropertiesService iBasicPropertiesService;
	

	
	/**
	 * 跳转至基础信息界面
	 * @return
	 * */
	@RequestMapping("basicPropeInfoManage")
	public String BasicPropeInfoManage(){
		return "manage/basicPropeInfoAction/basicPropeInfoManage";
	}

	/**
	 * 查询基础信息 分页
	 * @param info
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryBasicPropeInfoPage")
	public PageBean basicPropInfo(PageInfo info,String keyWords){
		PageBean  pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("keyWords",keyWords);
		return iBasicPropertiesService.queryBasicProperties(pageBean);
	}
	
	
	/**
	 * 修改基础信息提交 
	 * @param Info
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("updateSbmitBasicPropeInfo")
	public void updateSbmitBasicPropeInfo(BasicProperty Info) throws IOException{
		iBasicPropertiesService.updateBasicPropInfo(Info);
		//更新数据查询
		printSingleWordJson(1);
	}
	
}
