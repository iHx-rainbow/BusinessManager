/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.archivetype.web;

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
import com.jeesite.modules.archivetype.entity.Archivetype;
import com.jeesite.modules.archivetype.service.ArchivetypeService;

/**
 * archivetypeController
 * @author caoyu
 * @version 2019-09-04
 */
@Controller
@RequestMapping(value = "${adminPath}/archivetype/archivetype")
public class ArchivetypeController extends BaseController {

	@Autowired
	private ArchivetypeService archivetypeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Archivetype get(String archivetypeid, boolean isNewRecord) {
		return archivetypeService.get(archivetypeid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("archivetype:archivetype:view")
	@RequestMapping(value = {"list", ""})
	public String list(Archivetype archivetype, Model model) {
		model.addAttribute("archivetype", archivetype);
		return "modules/archivetype/archivetypeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("archivetype:archivetype:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Archivetype> listData(Archivetype archivetype, HttpServletRequest request, HttpServletResponse response) {
		archivetype.setPage(new Page<>(request, response));
		Page<Archivetype> page = archivetypeService.findPage(archivetype);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("archivetype:archivetype:view")
	@RequestMapping(value = "form")
	public String form(Archivetype archivetype, Model model) {
		model.addAttribute("archivetype", archivetype);
		return "modules/archivetype/archivetypeForm";
	}

	/**
	 * 保存档案类型
	 */
	@RequiresPermissions("archivetype:archivetype:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Archivetype archivetype) {
		archivetypeService.save(archivetype);
		return renderResult(Global.TRUE, text("保存档案类型成功！"));
	}
	
	/**
	 * 删除档案类型
	 */
	@RequiresPermissions("archivetype:archivetype:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Archivetype archivetype) {
		archivetypeService.delete(archivetype);
		return renderResult(Global.TRUE, text("删除档案类型成功！"));
	}
	
}