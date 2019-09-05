/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.save.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.save.entity.Save;
import com.jeesite.modules.save.dao.SaveDao;

/**
 * saveService
 * @author caoyu
 * @version 2019-09-05
 */
@Service
@Transactional(readOnly=true)
public class SaveService extends CrudService<SaveDao, Save> {
	
	/**
	 * 获取单条数据
	 * @param save
	 * @return
	 */
	@Override
	public Save get(Save save) {
		return super.get(save);
	}
	
	/**
	 * 查询分页数据
	 * @param save 查询条件
	 * @param save.page 分页对象
	 * @return
	 */
	@Override
	public Page<Save> findPage(Save save) {
		return super.findPage(save);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param save
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Save save) {
		super.save(save);
	}
	
	/**
	 * 更新状态
	 * @param save
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Save save) {
		super.updateStatus(save);
	}
	
	/**
	 * 删除数据
	 * @param save
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Save save) {
		super.delete(save);
	}
	
}