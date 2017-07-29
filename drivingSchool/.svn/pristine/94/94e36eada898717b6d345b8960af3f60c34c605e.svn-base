package com.HuiShengTec.app.Interceptor;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.HuiShengTec.app.service.IAttachmentService;
import com.HuiShengTec.app.service.IBasicPropertiesService;
import com.HuiShengTec.app.service.IMessageService;
import com.HuiShengTec.app.service.IRolePrivilegeService;
import com.HuiShengTec.base.cache.MessageCache;
import com.HuiShengTec.base.cache.RolePrivilegeCache;
import com.HuiShengTec.base.cache.PropertiesCache;
import com.HuiShengTec.base.taskJob.TaskJobSyncImg;
import com.HuiShengTec.entity.BasicProperty;
import com.HuiShengTec.utils.Toolkit;

/**
 * 覆盖原始servletContextListener，实现启动该listener时就加载系统必要的一些参数
 * @author mihuajun
 * @createTime 2014-11-5 下午9:16:05
 */
public class ServletContextListenerOverride extends ContextLoaderListener  {
	
	
	private IBasicPropertiesService iBasicPropertiesService;
	private IAttachmentService iAttachmentService;
	private IMessageService iMessageService;
	private IRolePrivilegeService iRolePrivilegeService;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
     
		super.contextInitialized(event);
		 //初始化容器
		 ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		 
		 applicationContext.getBeanDefinitionNames();
		 //获取实例
		 iBasicPropertiesService = (IBasicPropertiesService) applicationContext.getBean("basicPropertiesServiceImpl");
		 iAttachmentService = (IAttachmentService) applicationContext.getBean("attachmentServiceImpl");
		 iMessageService = (IMessageService) applicationContext.getBean("messageServiceImpl");
		 iRolePrivilegeService = (IRolePrivilegeService) applicationContext.getBean("rolePrivilegeServiceImpl");
		 //执行业务
		 excute();
	}
	
	/**
	 * 业务实现
	 */
	private void excute(){
		
		//缓存BasicProperty
		cacheBasicProperty();
		//缓存Message
		cacheMessage();
		//缓存权限
		cachePrivilege();
	}
	
	/**F:/work/apache-tomcat-8.0.15-windows-x64/apache-tomcat-8.0.15/webapps/drivingSchool
	 * 更新项目绝对路径(d:/xx/xx)
	 * @author mihuajun
	 * @throws UnsupportedEncodingException 
	 * @createTime 2014-11-12 上午11:34:11
	 */
	private  void updateWebBasePath(){
		BasicProperty info = PropertiesCache.getBasicProperty("webBasePath");
		if(Toolkit.isEmpty(info))
			return;
		String url = TaskJobSyncImg.class.getClassLoader().getResource("").getFile();
		System.out.println(url);// /F:/work/apache-tomcat-8.0.15-windows-x64/apache-tomcat-8.0.15/webapps/drivingSchool/WEB-INF/classes/
		String localBasePath =new File(url).getParentFile().getParentFile().toString();
		System.out.println(localBasePath);
		// F:\work\apache-tomcat-8.0.15-windows-x64\apache-tomcat-8.0.15\webapps\drivingSchool
		try {
			//String 的 replaceAll（） 方法，实际是采用正则表达式的规则去匹配的，
			//   \\\\   ，java解析为\\交给正则表达式，   正则表达式再经过一次转换，把\\转换成为\ 
			info.setValue((java.net.URLDecoder.decode(localBasePath, "utf-8")).replaceAll("\\\\","/"));
			iBasicPropertiesService.updateBasicPropInfo(info);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 缓存BasicProperty
	 */
	private void cacheBasicProperty(){
		ConcurrentHashMap<String, BasicProperty> str_basic = iBasicPropertiesService.queryAllCache();
		//将驾校logo图片的Id放进cache中
		String logoId = str_basic.get("jxlogo").getValue();
		if(!Toolkit.isEmpty(logoId)){
			//得到图片的地址
			String logoPath =  iAttachmentService.queryById(Integer.parseInt(logoId));
			str_basic.get("jxlogo").setValue(logoPath);//设置对应的值为图片的地址而不是id
		}  
		PropertiesCache.refreshProperties(str_basic);
		
		//更新网站基本路径
		updateWebBasePath();
	}
	
	/**
	 * 缓存Message
	 */
	private void cacheMessage(){
		MessageCache.refreshMessages(iMessageService.queryTopCache(MessageCache.kindKeys));
	}
	
	/**
	 * 缓存权限
	 * @author mihuajun
	 * @createTime 2014-11-21 下午3:50:20
	 */
	private void cachePrivilege(){
		RolePrivilegeCache.refreshPrivileges(iRolePrivilegeService.queryAllPrivilege());
		RolePrivilegeCache.refreshRolePrivileges(iRolePrivilegeService.queryAllRolePrivilege());
	}
}
