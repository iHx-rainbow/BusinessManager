/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.archivetype.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.archivetype.entity.Archivetype;
import com.jeesite.modules.archivetype.dao.ArchivetypeDao;

/**
 * archivetypeService
 * @author caoyu
 * @version 2019-09-04
 */
@Service
@Transactional(readOnly=true)
public class ArchivetypeService extends CrudService<ArchivetypeDao, Archivetype> {
	
	/**
	 * 获取单条数据
	 * @param archivetype
	 * @return
	 */
	@Override
	public Archivetype get(Archivetype archivetype) {
		return super.get(archivetype);
	}
	
	/**
	 * 查询分页数据
	 * @param archivetype 查询条件
	 * @param archivetype.page 分页对象
	 * @return
	 */
	@Override
	public Page<Archivetype> findPage(Archivetype archivetype) {
		return super.findPage(archivetype);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param archivetype
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Archivetype archivetype) {
		super.save(archivetype);
	}
	
	/**
	 * 更新状态
	 * @param archivetype
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Archivetype archivetype) {
		super.updateStatus(archivetype);
	}
	
	/**
	 * 删除数据
	 * @param archivetype
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Archivetype archivetype) {
		super.delete(archivetype);
	}
	
}