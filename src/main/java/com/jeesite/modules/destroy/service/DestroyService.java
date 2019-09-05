/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.destroy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.destroy.entity.Destroy;
import com.jeesite.modules.destroy.dao.DestroyDao;

/**
 * destroyService
 * @author caoyu
 * @version 2019-09-04
 */
@Service
@Transactional(readOnly=true)
public class DestroyService extends CrudService<DestroyDao, Destroy> {
	
	/**
	 * 获取单条数据
	 * @param destroy
	 * @return
	 */
	@Override
	public Destroy get(Destroy destroy) {
		return super.get(destroy);
	}
	
	/**
	 * 查询分页数据
	 * @param destroy 查询条件
	 * @param destroy.page 分页对象
	 * @return
	 */
	@Override
	public Page<Destroy> findPage(Destroy destroy) {
		return super.findPage(destroy);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param destroy
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Destroy destroy) {
		super.save(destroy);
	}
	
	/**
	 * 更新状态
	 * @param destroy
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Destroy destroy) {
		super.updateStatus(destroy);
	}
	
	/**
	 * 删除数据
	 * @param destroy
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Destroy destroy) {
		super.delete(destroy);
	}
	
}