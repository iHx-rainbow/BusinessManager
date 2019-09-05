/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.lose.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.lose.entity.Lose;
import com.jeesite.modules.lose.dao.LoseDao;

/**
 * loseService
 * @author caoyu
 * @version 2019-09-05
 */
@Service
@Transactional(readOnly=true)
public class LoseService extends CrudService<LoseDao, Lose> {
	
	/**
	 * 获取单条数据
	 * @param lose
	 * @return
	 */
	@Override
	public Lose get(Lose lose) {
		return super.get(lose);
	}
	
	/**
	 * 查询分页数据
	 * @param lose 查询条件
	 * @param lose.page 分页对象
	 * @return
	 */
	@Override
	public Page<Lose> findPage(Lose lose) {
		return super.findPage(lose);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param lose
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Lose lose) {
		super.save(lose);
	}
	
	/**
	 * 更新状态
	 * @param lose
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Lose lose) {
		super.updateStatus(lose);
	}
	
	/**
	 * 删除数据
	 * @param lose
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Lose lose) {
		super.delete(lose);
	}
	
}