/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.endtime.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.endtime.entity.Endtime;
import com.jeesite.modules.endtime.dao.EndtimeDao;

/**
 * endtimeService
 * @author caoyu
 * @version 2019-09-05
 */
@Service
@Transactional(readOnly=true)
public class EndtimeService extends CrudService<EndtimeDao, Endtime> {
	
	/**
	 * 获取单条数据
	 * @param endtime
	 * @return
	 */
	@Override
	public Endtime get(Endtime endtime) {
		return super.get(endtime);
	}
	
	/**
	 * 查询分页数据
	 * @param endtime 查询条件
	 * @param endtime.page 分页对象
	 * @return
	 */
	@Override
	public Page<Endtime> findPage(Endtime endtime) {
		return super.findPage(endtime);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param endtime
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Endtime endtime) {
		super.save(endtime);
	}
	
	/**
	 * 更新状态
	 * @param endtime
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Endtime endtime) {
		super.updateStatus(endtime);
	}
	
	/**
	 * 删除数据
	 * @param endtime
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Endtime endtime) {
		super.delete(endtime);
	}
	
}