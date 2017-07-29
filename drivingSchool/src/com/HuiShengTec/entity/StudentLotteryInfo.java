/**********************************************************************   
 * <p>文件名：StudentLotteryInfo.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：drivingSchool
 * @author mihuajun  
 * @date 2014年12月24日 下午6:10:33 
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
 * @Package:      [com.HuiShengTec.entity.StudentLotteryInfo.java]  
 * @ClassName:    [StudentLotteryInfo]   
 * @Description:  [抽奖记录]   
 * @Author:       [llj]   
 * @CreateDate:   [2014年12月24日 下午6:10:33] 
 * @Version:      [v1.0] 
 */

public class StudentLotteryInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer stuId;//学生信息
	
	private Integer lotteryId;//抽奖信息
	
	private Integer prizeId;//奖品信息
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;//抽奖时间
	
	private String stuLotteryCode;//编号
	
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public Integer getLotteryId() {
		return lotteryId;
	}

	public void setLotteryId(Integer lotteryId) {
		this.lotteryId = lotteryId;
	}

	public Integer getPrizeId() {
		return prizeId;
	}

	public void setPrizeId(Integer prizeId) {
		this.prizeId = prizeId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getStuLotteryCode() {
		return stuLotteryCode;
	}

	public void setStuLotteryCode(String stuLotteryCode) {
		this.stuLotteryCode = stuLotteryCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
