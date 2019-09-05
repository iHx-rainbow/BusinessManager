/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.output.dao;

import com.jeesite.common.dao.QueryDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.output.entity.Output;

/**
 * outputDAO接口
 * @author caoyu
 * @version 2019-09-05
 */
@MyBatisDao
public interface OutputDao extends QueryDao<Output> {
	
}