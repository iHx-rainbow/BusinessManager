/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.archive.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.archive.entity.Archive;
import com.jeesite.modules.busnesslog.service.BusnessLogService;
import com.jeesite.modules.sys.utils.UserUtils;
import com.jeesite.modules.archive.dao.ArchiveDao;

/**
 * archiveService
 * @author caoyu
 * @version 2019-09-04
 */
@Service
@Transactional(readOnly=true)
public class ArchiveService extends CrudService<ArchiveDao, Archive> {
	
	/**
	 * 获取单条数据
	 * @param archive
	 * @return
	 */
	@Override
	public Archive get(Archive archive) {
		return super.get(archive);
	}
	
	/**
	 * 查询分页数据
	 * @param archive 查询条件
	 * @param archive.page 分页对象
	 * @return
	 */
	@Override
	public Page<Archive> findPage(Archive archive) {
		return super.findPage(archive);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param archive
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Archive archive) {
		super.save(archive);
	}
	
	/**
	 * 更新状态
	 * @param archive
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Archive archive) {
		super.updateStatus(archive);
	}
	
	/**
	 * 删除数据
	 * @param archive
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Archive archive) {
		super.delete(archive);
	}
	
}