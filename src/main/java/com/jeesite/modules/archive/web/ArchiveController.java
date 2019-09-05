/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.archive.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.validator.constraints.Length;
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
import com.jeesite.modules.archive.entity.Archive;
import com.jeesite.modules.archive.service.ArchiveService;
import com.jeesite.modules.busnesslog.entity.BusnessLog;
import com.jeesite.modules.busnesslog.service.BusnessLogService;
import com.jeesite.modules.save.entity.Save;
import com.jeesite.modules.save.service.SaveService;
import com.jeesite.modules.sys.utils.UserUtils;

/**
 * archiveController
 * @author caoyu
 * @version 2019-09-04
 */
@Controller
@RequestMapping(value = "${adminPath}/archive/archive")
public class ArchiveController extends BaseController {

	@Autowired
	private ArchiveService archiveService;
	@Autowired
	private BusnessLogService bussnesslogService;
	@Autowired
	private SaveService saveService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Archive get(String archiveid, boolean isNewRecord) {
		return archiveService.get(archiveid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("archive:archive:view")
	@RequestMapping(value = {"list", ""})
	public String list(Archive archive, Model model) {
		/*
		Save save = new Save();
		save.setSaveid(archive.getSaveid());
		String bbb = saveService.get(save).getSavename().toString();
		
		String bbb = "adsfadsfadsfas";
		model.addAttribute("bbb", bbb);
		*/
		model.addAttribute("archive", archive);
		return "modules/archive/archiveList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("archive:archive:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Archive> listData(Archive archive, HttpServletRequest request, HttpServletResponse response) {
		archive.setPage(new Page<>(request, response));
		/*
		Save save = new Save();
		save.setSaveid(archive.getSaveid());
		saveService.get(save).getSavename();
		
		*/
		Page<Archive> page = archiveService.findPage(archive);
		

		
		
		
		
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("archive:archive:view")
	@RequestMapping(value = "form")
	public String form(Archive archive, Model model) {
		model.addAttribute("archive", archive);
		return "modules/archive/archiveForm";
	}

	/**
	 * 保存档案
	 */
	@RequiresPermissions("archive:archive:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Archive archive) {
		
		String username = UserUtils.getUser().getUserName();
		System.out.println(username);
		BusnessLog busnessLog = new BusnessLog();
		busnessLog.setUid(username);
		busnessLog.setLogname("档案标题："+archive.getTitle().toString());
		busnessLog.setLogdesc("保存档案");
		Date now = new Date(); 
		busnessLog.setLogtime(now.toString());
		bussnesslogService.save(busnessLog);
		
		archiveService.save(archive);
		return renderResult(Global.TRUE, text("保存档案成功！"));
	}
	
	/**
	 * 删除档案
	 */
	@RequiresPermissions("archive:archive:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Archive archive) {

		String username = UserUtils.getUser().getUserName();
		System.out.println(username);
		BusnessLog busnessLog = new BusnessLog();
		busnessLog.setUid(username);
		//busnessLog.setLogname("档案id："+archive.getArchiveid().toString());
		busnessLog.setLogname("档案标题："+archive.getTitle().toString());
		busnessLog.setLogdesc("删除档案");
		Date now = new Date(); 
		busnessLog.setLogtime(now.toString());
		bussnesslogService.save(busnessLog);
		
		archiveService.delete(archive);
		return renderResult(Global.TRUE, text("删除档案成功！"));
	}
	
}