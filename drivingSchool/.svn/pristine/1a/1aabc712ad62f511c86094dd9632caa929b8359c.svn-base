package com.HuiShengTec.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HuiShengTec.app.dao.IRoleDao;
import com.HuiShengTec.app.dao.IRolePrivilegeDao;
import com.HuiShengTec.app.service.IRolePrivilegeService;
import com.HuiShengTec.base.cache.RolePrivilegeCache;
import com.HuiShengTec.base.entity.PageBean;
import com.HuiShengTec.base.entity.PageInfo;
import com.HuiShengTec.entity.Privilege;
import com.HuiShengTec.entity.Role;
import com.HuiShengTec.entity.RolePrivilege;
import com.HuiShengTec.utils.Toolkit;
@Service
@Transactional
public class RolePrivilegeServiceImpl implements IRolePrivilegeService {

	@Autowired
	private IRoleDao iRoleDao;
	
	@Autowired
	private IRolePrivilegeDao iRolePrivilegeDao;
	
	/**
	 * 根据角色类型查询所有角色
	 * @param info
	 * @return
	 */
	public PageBean queryRolePage(PageInfo info){
		PageBean data = Toolkit.fillPageInfo(info);
		List<HashMap<String, Object>> rows = iRoleDao.queryRolePage(data);
		data.setRows(rows);
		return data;
	}
	public List<HashMap<String, Object>> queryRolePrivilege(Integer roleId){
		Role role =iRoleDao.queryRoleById(roleId);
		List<HashMap<String, Object>> result = iRolePrivilegeDao.queryRolePrivilege(role);
		for (HashMap<String, Object> hashMap : result) {
			hashMap.put("open", true);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public void updateRolePrivilege(String rolePrivilege,Integer roleId){
		@SuppressWarnings("rawtypes")
		List<HashMap> list =Toolkit.jsonToList(
				rolePrivilege, HashMap.class);
		for (HashMap<String,Object> rp : list) {
			RolePrivilege data = new RolePrivilege();
			data.setRoleId(roleId);
			data.setPrivilegeId(Integer.valueOf((Integer)rp.get("id")));
			
			//更新数据库成功后，更新缓存
			if ((boolean) rp.get("checked")) {
				iRolePrivilegeDao.addRolePrivilege(data);
				RolePrivilegeCache.putRolePrivilege(data.getRoleId(), data.getPrivilegeId(),data);
			}else {
				Integer len = iRolePrivilegeDao.delRolePrivilege(data);
				if(len>0){
					RolePrivilegeCache.removeRolePrivilege(data.getRoleId(), data.getPrivilegeId());
				}
			}
		}
	}
	
	/**
	 * 查询所属权限菜单
	 */
	@Override
	public List<Map<String,Object>> queryPrivilegeMenu(Integer roleId) {
		//查询对应角色ID所具有的权限
		List<Map<String,Object>> privileges = iRolePrivilegeDao.queryPrivilegeMenu(roleId);
		List<Map<String,Object>> menu = new ArrayList<Map<String,Object>>();
		
		//一级菜单
		for(Map<String,Object> item:privileges){
			if("0".equals(String.valueOf(item.get("pid")))){
				menu.add(item);
			}
		}
		//注入二级菜单
		for(Map<String,Object> item:privileges){
			Integer pid = Integer.valueOf(String.valueOf(item.get("pid")));
			if(pid != 0){
				for(Map<String,Object> m1:menu){
					Integer id = Integer.valueOf(String.valueOf(m1.get("id")));
					//是他的子项
					if(pid.equals(id)){
						List<Map<String,Object>> childrens = (List<Map<String, Object>>) m1.get("childrens");
						
						if(childrens==null){
							childrens = new ArrayList<Map<String,Object>>();
							m1.put("childrens", childrens);
						}
						childrens.add(item);
						break;
					}
				}
			}
		}
		
		return menu;
	}
	
	/**
	 *  查询指定角色权限
	 * queryRoleByType
	 */
	@Override
	public List<Role> queryRoleByType(Integer roleType) {
		return iRoleDao.queryRoleByType(roleType);
	}
	
	/**
	 * 查询所有权限Priviles
	 */
	@Override
	public ConcurrentHashMap<String,Privilege> queryAllPrivilege() {
		ConcurrentHashMap<String,Privilege> privileges = new ConcurrentHashMap<String,Privilege>();
		List<Privilege>  list = iRolePrivilegeDao.queryAllPrivilege();//查询出url不为空的权限 也就是不是父菜单
		for(Privilege pri:list){
			privileges.put(pri.getUrl(), pri);
		}
		return privileges;
	}
	
	/**
	 * 查询所有权限角色关系RolePrivileges
	 */
	@Override
	public ConcurrentHashMap<String,RolePrivilege> queryAllRolePrivilege() {
		ConcurrentHashMap<String,RolePrivilege> rolePrivileges = new ConcurrentHashMap<String,RolePrivilege>();
		List<RolePrivilege>  list = iRolePrivilegeDao.queryAllRolePrivilege();
		StringBuffer key = null;
		for(RolePrivilege rp:list){
			key = new StringBuffer("k");// k4-2108
			key.append(rp.getRoleId()).append("-").append(rp.getPrivilegeId());
			rolePrivileges.put(key.toString(), rp);
		}
		return rolePrivileges;
	}
}
