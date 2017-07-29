package com.HuiShengTec.app.service;

import com.HuiShengTec.entity.Login;
import com.HuiShengTec.entity.SysAdminInfo;

/**
 * 提供管理员信息管理服务接口
 * @author mihuajun
 *
 */
public interface IMagInfoService {

	SysAdminInfo editMagInfoSubmit(SysAdminInfo userInfo);

	Integer updateMagPassword(Login newLogin);

}
