/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.busnesslog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.busnesslog.entity.BusnessLog;
import com.jeesite.modules.busnesslog.dao.BusnessLogDao;

/**
 * busnesslogService
 * @author caoyu
 * @version 2019-09-05
 */
@Service
@Transactional(readOnly=true)
public class BusnessLogService extends CrudService<BusnessLogDao, BusnessLog> {
	
	/**
	 * 获取单条数据
	 * @param busnessLog
	 * @return
	 */
	@Override
	public BusnessLog get(BusnessLog busnessLog) {
		return super.get(busnessLog);
	}
	
	/**
	 * 查询分页数据
	 * @param busnessLog 查询条件
	 * @param busnessLog.page 分页对象
	 * @return
	 */
	@Override
	public Page<BusnessLog> findPage(BusnessLog busnessLog) {
		return super.findPage(busnessLog);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param busnessLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(BusnessLog busnessLog) {
		super.save(busnessLog);
	}
	
	/**
	 * 更新状态
	 * @param busnessLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(BusnessLog busnessLog) {
		super.updateStatus(busnessLog);
	}
	
	/**
	 * 删除数据
	 * @param busnessLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(BusnessLog busnessLog) {
		super.delete(busnessLog);
	}
	
}