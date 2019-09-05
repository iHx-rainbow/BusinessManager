/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.destroy.web;

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
import com.jeesite.modules.destroy.entity.Destroy;
import com.jeesite.modules.destroy.service.DestroyService;

/**
 * destroyController
 * @author caoyu
 * @version 2019-09-04
 */
@Controller
@RequestMapping(value = "${adminPath}/destroy/destroy")
public class DestroyController extends BaseController {

	@Autowired
	private DestroyService destroyService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Destroy get(String destroyid, boolean isNewRecord) {
		return destroyService.get(destroyid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("destroy:destroy:view")
	@RequestMapping(value = {"list", ""})
	public String list(Destroy destroy, Model model) {
		model.addAttribute("destroy", destroy);
		return "modules/destroy/destroyList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("destroy:destroy:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Destroy> listData(Destroy destroy, HttpServletRequest request, HttpServletResponse response) {
		destroy.setPage(new Page<>(request, response));
		Page<Destroy> page = destroyService.findPage(destroy);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("destroy:destroy:view")
	@RequestMapping(value = "form")
	public String form(Destroy destroy, Model model) {
		model.addAttribute("destroy", destroy);
		return "modules/destroy/destroyForm";
	}

	/**
	 * 保存销毁
	 */
	@RequiresPermissions("destroy:destroy:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Destroy destroy) {
		destroyService.save(destroy);
		return renderResult(Global.TRUE, text("保存销毁成功！"));
	}
	
	/**
	 * 删除销毁
	 */
	@RequiresPermissions("destroy:destroy:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Destroy destroy) {
		destroyService.delete(destroy);
		return renderResult(Global.TRUE, text("删除销毁成功！"));
	}
	
}