package com.HuiShengTec.app.magAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.IMapMarkService;
import com.HuiShengTec.app.service.ISceneService;
import com.HuiShengTec.utils.Toolkit;
import com.alibaba.fastjson.JSONObject;

/**
 * 电子围栏
 * @author zf
 *
 */
@Controller
@RequestMapping("mag")
@Scope("prototype")
public class MapMarkAction extends BaseAction{
	
	@Autowired
	private IMapMarkService iMapMarkService;
	@Autowired
	private ISceneService iSceneService;
	
	
	
	/**
	 * @Description: TODO(地图页)
	 */
	@RequestMapping("mapMarkManage")
	public String mapMarkAction(){
		return "manage/mapMarkAction/mapMarkManage";
	}
	
	@RequestMapping("getAllScenes")
	@ResponseBody
	public List<Map<String, Object>> getAllScenes(){
		return iSceneService.getAllScenes();
	}
	
	/**
	 * @Description: TODO(保存标记信息)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("saveMapMarkInfo")
	@ResponseBody
	public Integer saveMapMarkInfo(@RequestParam Map<String, Object> param){
		List<HashMap> paramList=JSONObject.parseArray((String)param.get("param"),HashMap.class);
		if(!Toolkit.isEmpty(paramList)){
			 for (Map<String, Object> paramMap : paramList) {
				    //设置他的sceneId
				    paramMap.put("sceneId",iSceneService.queryIdByTitle(Toolkit.initMapCondition("keyWord", paramMap.get("title").toString())));
				    //如果经纬度有了 那么就更新
				    if(null != paramMap.get("id").toString() && !"0".equals(paramMap.get("id").toString())){//有了 就更新
				    	iMapMarkService.updateMapMarkInfo(paramMap);
				    }else{
				    	iMapMarkService.saveMapMarkInfo(paramMap);
				    }
				}
				return 1;
		}
		return 0;
	}
	
	/**
	 * @Description: TODO(查询标注坐标)
	 */
	@RequestMapping("queryMapMarkInfo")
	@ResponseBody
	public List<Map<String, Object>> queryMapMarkInfo(){
		return iMapMarkService.queryMapMarkInfo();
	}
	
	/**
	 * 
	 * @Description: TODO(移除坐标点)
	 */
	@RequestMapping("deleteMapMarkInfo")
	@ResponseBody
	public List<Map<String, Object>> deleteMapMarkInfo(@RequestParam Map<String, Object> param){
		iMapMarkService.deleteMapMarkInfo(param);
		return iMapMarkService.queryMapMarkInfo();
	}

}
