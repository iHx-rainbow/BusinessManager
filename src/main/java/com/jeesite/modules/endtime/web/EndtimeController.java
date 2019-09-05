/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.endtime.web;

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
import com.jeesite.modules.endtime.entity.Endtime;
import com.jeesite.modules.endtime.service.EndtimeService;

/**
 * endtimeController
 * @author caoyu
 * @version 2019-09-05
 */
@Controller
@RequestMapping(value = "${adminPath}/endtime/endtime")
public class EndtimeController extends BaseController {

	@Autowired
	private EndtimeService endtimeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Endtime get(String borrowPid, boolean isNewRecord) {
		return endtimeService.get(borrowPid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("endtime:endtime:view")
	@RequestMapping(value = {"list", ""})
	public String list(Endtime endtime, Model model) {
		model.addAttribute("endtime", endtime);
		return "modules/endtime/endtimeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("endtime:endtime:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Endtime> listData(Endtime endtime, HttpServletRequest request, HttpServletResponse response) {
		endtime.setPage(new Page<>(request, response));
		Page<Endtime> page = endtimeService.findPage(endtime);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("endtime:endtime:view")
	@RequestMapping(value = "form")
	public String form(Endtime endtime, Model model) {
		model.addAttribute("endtime", endtime);
		return "modules/endtime/endtimeForm";
	}

	/**
	 * 保存到期
	 */
	@RequiresPermissions("endtime:endtime:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Endtime endtime) {
		endtimeService.save(endtime);
		return renderResult(Global.TRUE, text("保存到期成功！"));
	}
	
	/**
	 * 删除到期
	 */
	@RequiresPermissions("endtime:endtime:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Endtime endtime) {
		endtimeService.delete(endtime);
		return renderResult(Global.TRUE, text("删除到期成功！"));
	}
	
}