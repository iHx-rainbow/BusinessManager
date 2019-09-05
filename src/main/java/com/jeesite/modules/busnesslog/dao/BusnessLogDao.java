/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.busnesslog.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.busnesslog.entity.BusnessLog;

/**
 * busnesslogDAO接口
 * @author caoyu
 * @version 2019-09-05
 */
@MyBatisDao
public interface BusnessLogDao extends CrudDao<BusnessLog> {
	
}