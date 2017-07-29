package com.HuiShengTec.app.magAction;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.IAttachmentService;
import com.HuiShengTec.app.service.IWebPropertiesService;
import com.HuiShengTec.base.action.BaseAction;
import com.HuiShengTec.base.cache.PropertiesCache;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.BasicProperty;
import com.HuiShengTec.entity.Picture;
import com.HuiShengTec.entity.StationInfo;
import com.HuiShengTec.utils.Toolkit;
import com.alibaba.fastjson.JSONObject;
@Controller
@Scope("prototype")
@RequestMapping("mag")
public class WebPropertiesInfoAction extends BaseAction {
	@Autowired
	private IWebPropertiesService iWebPropertiesService;
	@Autowired
	private IAttachmentService iAttachmentService;
	/**
	 * 跳转至网站信息界面
	 * @return
	 * */
	@RequestMapping("webPropeInfoManage")
	public String webPropeInfoManage(){
		return "manage/basicPropeInfoAction/webPropeInfoManage";
	}

	/**
	 * 查询网站信息
	 * @param info
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryWebPropeInfoPage")
	public JSONObject webPropInfo(PageInfo info){
		
		String keys[] = {"jxlogo","jx_chineseName","jx_englishName","record_nums","record_cards","site_domain_name"};
		
		List<BasicProperty> list = iWebPropertiesService.queryWebPropertiesByKeys(keys);
		
		JSONObject result = new JSONObject();
		for(int i=0;i<list.size();i++){
			result.put(list.get(i).getKey(), list.get(i).getValue());
		}
		
		String jxlogo = result.getString("jxlogo");
		if(!Toolkit.isEmpty(jxlogo)){
			String logo = iAttachmentService.queryById(Integer.parseInt(jxlogo));
			result.put("logo", logo);
		}
		
		return result;
	}
	
	/**
	 * 修改网站信息提交 
	 * @param Info
	 * @return
	 * @throws IOException 
	 * @throws Exception 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping("updateSubmitWebPropeInfo")
	public void updateSubmitWebPropeInfo(StationInfo info) throws Exception{
		Map<String,String> data = BeanUtils.describe(info);
		String s = data.get("jxlogo");
		Picture attachment = new Picture();
		attachment.setPath(s);
		attachment.setCreateTime(new Date());
		attachment.setTitle("jxlogo");
		Integer id = iAttachmentService.queryByPath(s);
		
		if(id!=null){
			attachment.setId(id);
			iAttachmentService.updateById(attachment);
		}else{
			iAttachmentService.saveAttachment(attachment);
		}
		id = iAttachmentService.queryByPath(s);
		data.put("jxlogo", String.valueOf(id));
		for(String key:data.keySet()){
			BasicProperty bp = new BasicProperty();
			bp.setKey(key);
			bp.setValue(data.get(key));
			Integer len = iWebPropertiesService.updateWebPropInfo(bp);
			
			//刷新缓存
			if(len>0){
				if("jxlogo".equals(key)){	//如果是jxlogo时，保存路径
					PropertiesCache.setValue(key, attachment.getPath());
				}else{
					PropertiesCache.setValue(key, data.get(key));
				}
			}
		}
		
		printSingleWordJson(1);
	}
}
