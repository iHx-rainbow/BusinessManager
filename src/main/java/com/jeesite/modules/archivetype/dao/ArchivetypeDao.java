/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.archivetype.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.archivetype.entity.Archivetype;

/**
 * archivetypeDAO接口
 * @author caoyu
 * @version 2019-09-04
 */
@MyBatisDao
public interface ArchivetypeDao extends CrudDao<Archivetype> {
	
}