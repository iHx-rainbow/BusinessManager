/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.borrow.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.borrow.entity.Borrow;
import com.jeesite.modules.borrow.dao.BorrowDao;

/**
 * borrowService
 * @author caoyu
 * @version 2019-09-04
 */
@Service
@Transactional(readOnly=true)
public class BorrowService extends CrudService<BorrowDao, Borrow> {
	
	/**
	 * 获取单条数据
	 * @param borrow
	 * @return
	 */
	@Override
	public Borrow get(Borrow borrow) {
		return super.get(borrow);
	}
	
	/**
	 * 查询分页数据
	 * @param borrow 查询条件
	 * @param borrow.page 分页对象
	 * @return
	 */
	@Override
	public Page<Borrow> findPage(Borrow borrow) {
		return super.findPage(borrow);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param borrow
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Borrow borrow) {
		super.save(borrow);
	}
	
	/**
	 * 更新状态
	 * @param borrow
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Borrow borrow) {
		super.updateStatus(borrow);
	}
	
	/**
	 * 删除数据
	 * @param borrow
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Borrow borrow) {
		super.delete(borrow);
	}
	
}