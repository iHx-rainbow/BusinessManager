/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.output.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.QueryService;
import com.jeesite.modules.output.entity.Output;
import com.jeesite.modules.output.dao.OutputDao;

/**
 * outputService
 * @author caoyu
 * @version 2019-09-05
 */
@Service
public class OutputService extends QueryService<OutputDao, Output> {
	
	/**
	 * 获取单条数据
	 * @param output
	 * @return
	 */
	@Override
	public Output get(Output output) {
		return super.get(output);
	}
	
	/**
	 * 查询分页数据
	 * @param output 查询条件
	 * @param output.page 分页对象
	 * @return
	 */
	@Override
	public Page<Output> findPage(Output output) {
		return super.findPage(output);
	}
	
}