/**********************************************************************   
 * <p>文件名：PrizeInfo.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：drivingSchool
 * @author mihuajun  
 * @date 2014年12月24日 下午6:13:31 
 * @history
 * @department：慧莘软件部
 * Copyright ChengDu Huishen Technology Development CO.,LTD 2014
 * All Rights Reserved.
*/
package com.HuiShengTec.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/******************************************************************************
 * @Package:      [com.HuiShengTec.entity.PrizeInfo.java]  
 * @ClassName:    [PrizeInfo]   
 * @Description:  [奖品列表]   
 * @Author:       [llj]   
 * @CreateDate:   [2014年12月24日 下午6:13:31] 
 * @Version:      [v1.0] 
 */

public class PrizeInfo  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String prizeName;//奖品名称
	
	private Integer picId;//奖品图标
	
	private Integer lotteryId;//所属活动
	
	private Integer type;//类型（1-正常奖品 2-轮空奖品）
	
	private Integer prizeCount;//份数
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date prizeBeginDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date prizeEndDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrizeName() {
		return prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public Integer getPicId() {
		return picId;
	}

	public void setPicId(Integer picId) {
		this.picId = picId;
	}

	public Integer getLotteryId() {
		return lotteryId;
	}

	public void setLotteryId(Integer lotteryId) {
		this.lotteryId = lotteryId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPrizeCount() {
		return prizeCount;
	}

	public void setPrizeCount(Integer prizeCount) {
		this.prizeCount = prizeCount;
	}

	public Date getPrizeBeginDate() {
		return prizeBeginDate;
	}

	public void setPrizeBeginDate(Date prizeBeginDate) {
		this.prizeBeginDate = prizeBeginDate;
	}

	public Date getPrizeEndDate() {
		return prizeEndDate;
	}

	public void setPrizeEndDate(Date prizeEndDate) {
		this.prizeEndDate = prizeEndDate;
	}
	
}
