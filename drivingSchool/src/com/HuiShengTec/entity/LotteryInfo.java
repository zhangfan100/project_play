/**********************************************************************   
 * <p>文件名：LotteryInfo.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：drivingSchool
 * @author mihuajun  
 * @date 2014年12月24日 下午6:06:27 
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
 * @Package:      [com.HuiShengTec.entity.LotteryInfo.java]  
 * @ClassName:    [LotteryInfo]   
 * @Description:  [抽奖信息表]   
 * @Author:       [llj]   
 * @CreateDate:   [2014年12月24日 下午6:06:27] 
 * @Version:      [v1.0] 
 */

public class LotteryInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String title;//抽奖标题
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date beginTime;//开始时间
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endTime;//结束时间
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createDate;//创建时间
	
	private Integer status;//状态

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
