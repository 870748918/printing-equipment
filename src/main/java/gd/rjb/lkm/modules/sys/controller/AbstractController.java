/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package gd.rjb.lkm.modules.sys.controller;

import gd.rjb.lkm.modules.sys.dao.SysUserDao;
import gd.rjb.lkm.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Controller公共组件
 *
 * @author Mark sunlightcs@gmail.com
 */
public abstract class AbstractController {
	@Resource
	SysUserDao sysUserDao;
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUserEntity getUser() {
		SysUserEntity sysUserEntity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
		sysUserEntity.setAddress(sysUserDao.queryRegion(sysUserEntity.getAddress()));
		return sysUserEntity;
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}
}
