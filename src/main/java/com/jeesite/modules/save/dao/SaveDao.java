/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.save.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.save.entity.Save;

/**
 * saveDAO接口
 * @author caoyu
 * @version 2019-09-05
 */
@MyBatisDao
public interface SaveDao extends CrudDao<Save> {
	
}