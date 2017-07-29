package com.HuiShengTec.app.magAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.app.core.BaseAction;
import com.HuiShengTec.app.service.ICampusInfoService;
import com.HuiShengTec.app.service.IImageService;
import com.HuiShengTec.app.service.ILoginService;
import com.HuiShengTec.app.service.IStuInfoService;
import com.HuiShengTec.base.annotation.Token;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.Picture;
import com.HuiShengTec.entity.StudentInfo;
import com.HuiShengTec.utils.Toolkit;

/**
 * 学员管理
 * @author mihuajun
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("mag")
public class StuManageAction extends BaseAction {
	
	@Autowired
	private IStuInfoService iStuManageService;
	@Autowired
	private IImageService iImageService;
	@Autowired
	private ICampusInfoService iCampusInfoService;
	@Autowired
	private ILoginService iLoginService;
	
	/**
	 * 跳转到学生管理首页
	 * @return
	 */
	@RequestMapping("stuManage")
	public String stuManage(){
		return "manage/stuManageAction/stuManage";
	}
	
	/**
	 * 新增学员页面
	 * @return
	 */
	@RequestMapping("addStudent")
	@Token(addToken=true)
	public String addStudent(){
		return "manage/stuManageAction/addStudent";
	}
	
	/**
	 * 分页显示学员信息
	 * @param info
	 * @param keyWords
	 * @return
	 */
	@RequestMapping("queryStudentsByPage")
	@ResponseBody
	public PageBean queryStudentsByPage(PageInfo info,String keyWords){
		PageBean  pageBean = Toolkit.fillPageInfo(info);
		pageBean.addConditions("keyWords",Toolkit.isEmpty(keyWords)?null:keyWords.trim());
		return iStuManageService.queryStudentsByPage(pageBean);
	}
	
	/**
	 * 显示学生详情
	 * @return
	 */
	@RequestMapping("queryStudentInfo")
	public String queryStudentInfo(Integer id,Model model){
		model.addAttribute("record",iStuManageService.queryStudentInfoById(id));
		return "manage/stuManageAction/infoStudent";
	}
	
	/**
	 * 编辑学生
	 * @return
	 */
	@RequestMapping("editStudentInfo")
	@Token(addToken=true)
	public String editStudentInfo(Integer id){
		pushRequestValue("record",iStuManageService.queryStudentInfoById(id));
		return "manage/stuManageAction/editStudent";
	}
	
	/**
	 * 编辑学生学习进度
	 * @return
	 */
	@RequestMapping("editLessonStep")
	@Token(addToken=true)
	public String editLessonStep(Integer id){
		pushRequestValue("record",iStuManageService.queryStudentInfoById(id));
		return "manage/stuManageAction/editLessonStep";
	}
	
	
	/**
	 * 学生信息修改操作
	 * @param stuInf
	 * @param login
	 * @param imgCode
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("editStudentSubmit")
	@ResponseBody
	@Token(delToken=true)
	public Integer editStudentSubmit(StudentInfo stuInfo,Login login,Picture pic,String imgCode,Integer infoId,Integer loginId) throws IOException{
		
		stuInfo.setId(infoId);
		stuInfo.setCreateDate(null);
		login.setId(loginId);
		login.setUserId(infoId);
		
		//保存时，判断这两值是否相等，否则保存新的图片
		if(!imgCode.equals(String.valueOf(stuInfo.getPhotoId()))){
			
			//删除原头像
			String basePath = request.getSession().getServletContext().getRealPath("/");
			pic.setId(stuInfo.getPhotoId());
			List<Picture> list = new ArrayList<Picture>();
			list.add(pic);
			iImageService.deleteImage(list,basePath);
			
			//保存新头像
			String path = Toolkit.saveCodeImg(request,imgCode);
			pic.setPath(path);
			Integer pictureId = iImageService.saveImages(pic);
			stuInfo.setPhotoId(pictureId);
		}
		
		//修改对应学员的角色ID为对应的角色ID 比如从科目一改变为科目二时 那么就是从已激活学员（科目二）到已激活学员（科目三）
		if(stuInfo.getLessonStep()==1){//为科目一时roleId应该是已激活学员（科目二）
			login.setRoleId(6);
		}
		if(stuInfo.getLessonStep()==2){
			login.setRoleId(8);
		}
//		iLoginService.editLoginRoleId(login);
		return iStuManageService.updateStudent(stuInfo,login);
	}
	
	/**
	 * 学员信息保存操作
	 * @param stuInf
	 * @param login
	 * @param comfirmPassword
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("addStudentSubmit")
	@ResponseBody
	@Token(delToken=true)
	public Integer addStudentSubmit(StudentInfo stuInf,Login login,String imgCode) throws IOException{
		
		String path = Toolkit.saveCodeImg(request,imgCode);
		Picture pic = new Picture();
		pic.setPath(path);
		Integer pictureId = iImageService.saveImages(pic);
		
		stuInf.setPhotoId(pictureId);
		login.setPassword(Toolkit.Md5encode("123456"));
		return iStuManageService.registerStudent(stuInf,login);
	}
	
}
