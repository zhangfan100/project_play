package com.HuiShengTec.app.dao;

import java.util.HashMap;
import java.util.List;

import com.HuiShengTec.base.dao.IBaseDao;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.entity.Privilege;
import com.HuiShengTec.entity.Role;

public interface IRoleDao extends IBaseDao {

	public List<HashMap<String, Object>> queryRolePage(PageBean data);
	
	public Role queryRoleById(Integer id);
	
	/**
	 * 查询指定角色权限
	 * @author mihuajun
	 * @createTime 2014-11-7 下午3:22:10
	 * @param roleType
	 * @return
	 */
	public List<Role> queryRoleByType(Integer roleType);
	
}
