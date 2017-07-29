package com.HuiShengTec.app.stuAction;


import java.io.IOException;

import com.HuiShengTec.app.core.BaseAction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.service.IImageService;
import com.HuiShengTec.app.service.ILessonInfoService;
import com.HuiShengTec.app.service.IStuInfoService;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.Picture;
import com.HuiShengTec.entity.StudentInfo;
import com.HuiShengTec.utils.Toolkit;
/**
 * 学生信息管理
 * @author llj
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("stu")
public class StudentInfoAction extends BaseAction{
	@Autowired
	private IImageService iImageService;
	@Autowired
	private IStuInfoService iStuInfoService;
	@Autowired
	private ILessonInfoService iLessonInfoService;
	
	
	/**
	 * 跳转至编辑学生信息界面
	 * @return
	 */
	@RequestMapping("editStudentInfo")
	public String editStudentInfo(){
		request.setAttribute("att", iImageService.queryImage(this.getCurrLoginStudent().getPhotoId()));
		return "student/studentInfoAction/editStudentInfo";
	}
	/**
	 * 跳转至编辑学生登陆信息界面
	 * @return
	 */
	@RequestMapping("editStuLoginInfo")
	public String editStuLoginInfo(){
		return "student/stuLoginInfoAction/editStuLoginInfo";
	}
	
	
	/**
	 * 编辑学生界面提交
	 * @throws IOException 
	 */
	@RequestMapping("editStudentInfoSubmit")
	public void editStudentInfoSubmit(StudentInfo info,String newStuImg,String oldStuImg) throws IOException{
	
		Picture at = new Picture();
		at.setId(info.getPhotoId());
		at.setPath(oldStuImg);
		
		if(!Toolkit.isEmpty(newStuImg)){
			//调用接口修改当前图像
			Picture att = new Picture();
			att.setPath(newStuImg);
			att.setType(1);
			Integer imgId = iImageService.saveImages(att);
			info.setPhotoId(imgId);
		}
		
		iStuInfoService.editStudentInfo(info);
		
		if(!Toolkit.isEmpty(newStuImg)){

			//调用接口删除原图片
			if(info.getPhotoId()!=null){
				List<Picture> imgs = new ArrayList<Picture>();
				imgs.add(at);
				iImageService.deleteImage(imgs, session.getServletContext().getRealPath(""));
			}
		}
		
		//更新SESSION 信息
		session.setAttribute("userInfo", iStuInfoService.queryStuInfo(info.getId()));
		printSingleWordJson(1);
	}
	
	/**
	 * 修改密码
	 * @param formerPassword
	 * @param newPassword
	 * @return
	 */
	@RequestMapping("editStuPasswordSubmit")
	@ResponseBody
	public Integer updateStuPassword(String formerPassword,String newPassword){
		Login userInfo = this.getCurrLoginInfo();
		//填写的密码与原始密码不匹配
		if(!userInfo.getPassword().equals(Toolkit.Md5encode(formerPassword))){
			return 1;
		}
		
		Login newLogin = new Login();
		newLogin.setPassword(Toolkit.Md5encode(newPassword));
		newLogin.setId(userInfo.getId());
		
		Integer status = iStuInfoService.updateStuPassword(newLogin);
		
		//将修改后的密码植入session中
		if(status==0){
			userInfo.setPassword(Toolkit.Md5encode(newPassword));
		}
		return  status;
		
	}

}
