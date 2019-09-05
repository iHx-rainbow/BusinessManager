/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.save.web;

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
import com.jeesite.modules.save.entity.Save;
import com.jeesite.modules.save.service.SaveService;

/**
 * saveController
 * @author caoyu
 * @version 2019-09-05
 */
@Controller
@RequestMapping(value = "${adminPath}/save/save")
public class SaveController extends BaseController {

	@Autowired
	private SaveService saveService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Save get(String pidJeesite, boolean isNewRecord) {
		return saveService.get(pidJeesite, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("save:save:view")
	@RequestMapping(value = {"list", ""})
	public String list(Save save, Model model) {
		model.addAttribute("save", save);
		return "modules/save/saveList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("save:save:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Save> listData(Save save, HttpServletRequest request, HttpServletResponse response) {
		save.setPage(new Page<>(request, response));
		Page<Save> page = saveService.findPage(save);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("save:save:view")
	@RequestMapping(value = "form")
	public String form(Save save, Model model) {
		model.addAttribute("save", save);
		return "modules/save/saveForm";
	}

	/**
	 * 保存存档点
	 */
	@RequiresPermissions("save:save:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Save save) {
		saveService.save(save);
		return renderResult(Global.TRUE, text("保存存档点成功！"));
	}
	
	/**
	 * 删除存档点
	 */
	@RequiresPermissions("save:save:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Save save) {
		saveService.delete(save);
		return renderResult(Global.TRUE, text("删除存档点成功！"));
	}
	
}