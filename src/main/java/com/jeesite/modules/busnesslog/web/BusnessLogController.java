/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.busnesslog.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.busnesslog.entity.BusnessLog;
import com.jeesite.modules.busnesslog.service.BusnessLogService;

/**
 * busnesslogController
 * @author caoyu
 * @version 2019-09-05
 */
@Controller
@RequestMapping(value = "${adminPath}/busnesslog/busnessLog")
public class BusnessLogController extends BaseController {

	@Autowired
	private BusnessLogService busnessLogService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public BusnessLog get(String logid, boolean isNewRecord) {
		return busnessLogService.get(logid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("busnesslog:busnessLog:view")
	@RequestMapping(value = {"list", ""})
	public String list(BusnessLog busnessLog, Model model) {
		model.addAttribute("busnessLog", busnessLog);
		return "modules/busnesslog/busnessLogList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("busnesslog:busnessLog:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<BusnessLog> listData(BusnessLog busnessLog, HttpServletRequest request, HttpServletResponse response) {
		busnessLog.setPage(new Page<>(request, response));
		Page<BusnessLog> page = busnessLogService.findPage(busnessLog);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("busnesslog:busnessLog:view")
	@RequestMapping(value = "form")
	public String form(BusnessLog busnessLog, Model model) {
		model.addAttribute("busnessLog", busnessLog);
		return "modules/busnesslog/busnessLogForm";
	}

	/**
	 * 保存日志
	 */
	@RequiresPermissions("busnesslog:busnessLog:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated BusnessLog busnessLog) {
		busnessLogService.save(busnessLog);
		return renderResult(Global.TRUE, text("保存日志成功！"));
	}
	
	/**
	 * 删除日志
	 */
	@RequiresPermissions("busnesslog:busnessLog:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(BusnessLog busnessLog) {
		busnessLogService.delete(busnessLog);
		return renderResult(Global.TRUE, text("删除日志成功！"));
	}
	
}