package com.HuiShengTec.app.magAction;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.IAccountstatisticsService;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.Accountstatistics;

@Controller
@Scope("prototype")
@RequestMapping("mag")
public class AccountLogAction extends BaseAction {

	@Autowired
	private IAccountstatisticsService iAccountstatisticsService;
	
	/**
	 * 转到统计页面
	 * @author [zf]
	 */
	@RequestMapping("statisticalDataPage")
	public String statisticalDataPage(){
		return "manage/statisticalDataAction/statisticalDataPage";
	}
	
	/**
	 * 得到从选择日之间的统计的图
	 * * @author [zf]
	 */
	@RequestMapping("getStatisticalData")
	@ResponseBody
	public Map<String, Object> getStatisticalData(Accountstatistics data){
		return iAccountstatisticsService.getStatisticalData(data);
	}
	
	/**
	 * 周统计的图
	 * * @author [zf]
	 */
	@RequestMapping("getWeekStatisticalData")
	@ResponseBody
	public Map<String, Object> getWeekStatisticalData(Accountstatistics data){
		return iAccountstatisticsService.getWeekStatisticalData(data);
	}
	/**
	 * 月统计的图
	 * * @author [zf]
	 */
	@RequestMapping("getMonthStatisticalData")
	@ResponseBody
	public Map<String, Object> getMonthStatisticalData(Accountstatistics data){
		return iAccountstatisticsService.getMonthStatisticalData(data);
	}
	
	/**
	 * 季度统计的图
	 * * @author [zf]
	 */
	@RequestMapping("getQuarterStatisticalData")
	@ResponseBody
	public Map<String, Object> getQuarterStatisticalData(Accountstatistics data){
		return iAccountstatisticsService.getQuarterStatisticalData(data);
	}
	
	/**
	 * 年统计的图
	 * * @author [zf]
	 */
	@RequestMapping("getYearStatisticalData")
	@ResponseBody
	public Map<String, Object> getYearStatisticalData(Accountstatistics data){
		return iAccountstatisticsService.getYearStatisticalData(data);
	}
	
	/**
	 * 封装统计数据用于显示到表格中
	 * * @author [zf]
	 */
	@RequestMapping("fillStatisticalData")
	@ResponseBody
	public PageBean fillStatisticalData(Accountstatistics accountstatistics){
		return iAccountstatisticsService.fillStatisticalData(accountstatistics);
	}
	
}
