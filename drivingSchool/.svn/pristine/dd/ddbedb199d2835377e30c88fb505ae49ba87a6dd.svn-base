package com.HuiShengTec.app.magAction;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.IIncomeItemService;
import com.HuiShengTec.base.annotation.Token;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.base.messageConverter.JSONDateOutputMode;
import com.HuiShengTec.entity.IncomeItem;
import com.HuiShengTec.utils.Toolkit;

@Controller
@RequestMapping("mag")
@Scope("prototype")
public class IncomeItemAction extends BaseAction{
	
	
	@Autowired
	private IIncomeItemService iIncomeItemService;
	
	/**
	 * 根据关键字搜索项目
	 * @param q
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryItemByKeyWord")
	public List<HashMap<String, Object>> queryItemByKeyWord(String q) {
		return iIncomeItemService.queryItemByKeyWord(q);
	}
	
	/**
	 * 跳转到收入项目管理页面去
	 * @return
	 */
	@RequestMapping("incomeItemManage")
	public String incomeItemManage(){
		return "manage/incomeItemAction/incomeItemManage";
	}
	
	/**
	 * 跳转到添加收入项目页面去
	 * @return
	 */
	@Token(addToken=true)
	@RequestMapping("addIncomeItem")
	public String addIncomeItem(){
		return "manage/incomeItemAction/addIncomeItem";
	}
	
	/**
	 * 跳转到项目编辑页面
	 * @return
	 */
	@Token(addToken=true)
	@RequestMapping("editIncomeItem")
	public String editIncomeItem(Integer id){
		pushRequestValue("data", iIncomeItemService.queryIncomeItemById(id));
		return "manage/incomeItemAction/editIncomeItem";
	}
	
	/**
	 * 后台编辑提交
	 * @param incomeItem
	 * @return
	 */
	@Token(delToken=true)
	@ResponseBody
	@RequestMapping("submitEditIncomeItem")
	public Integer submitEditIncomeItem(IncomeItem incomeItem){
		iIncomeItemService.updateIncomeItem(incomeItem);
		return 1;
	}
	
	/**
	 * 分页显示收入项目
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryIncomeItemByPage")
	public PageBean queryAllIncomeItem(PageInfo info){
		JSONDateOutputMode.setJSONDateToTimeMode();
		PageBean pageBean = Toolkit.fillPageInfo(info);
		return iIncomeItemService.queryAllIncomeItem(pageBean);
	}
	
	@ResponseBody
	@RequestMapping("delIncomeItem")
	public Integer delIncomeItem(String idStr){
		iIncomeItemService.delIncomeItems(idStr);
		return 1;
	}
	
	/**
	 * 添加项目信息
	 * @param incomeItem
	 * @return
	 */
	@Token(delToken=true)
	@ResponseBody
	@RequestMapping("confirmAddIncomeItem")
	public Integer confirmAddIncomeItem(IncomeItem incomeItem){
		iIncomeItemService.addIncomeItem(incomeItem);
		return 1;
	}
	
}
