/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.borrow.web;

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
import com.jeesite.modules.borrow.entity.Borrow;
import com.jeesite.modules.borrow.service.BorrowService;

/**
 * borrowController
 * @author caoyu
 * @version 2019-09-05
 */
@Controller
@RequestMapping(value = "${adminPath}/borrow/borrow")
public class BorrowController extends BaseController {

	@Autowired
	private BorrowService borrowService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Borrow get(String borrowPid, boolean isNewRecord) {
		return borrowService.get(borrowPid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("borrow:borrow:view")
	@RequestMapping(value = {"list", ""})
	public String list(Borrow borrow, Model model) {
		model.addAttribute("borrow", borrow);
		return "modules/borrow/borrowList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("borrow:borrow:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Borrow> listData(Borrow borrow, HttpServletRequest request, HttpServletResponse response) {
		borrow.setPage(new Page<>(request, response));
		Page<Borrow> page = borrowService.findPage(borrow);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("borrow:borrow:view")
	@RequestMapping(value = "form")
	public String form(Borrow borrow, Model model) {
		model.addAttribute("borrow", borrow);
		return "modules/borrow/borrowForm";
	}

	/**
	 * 保存借阅
	 */
	@RequiresPermissions("borrow:borrow:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Borrow borrow) {
		borrowService.save(borrow);
		return renderResult(Global.TRUE, text("保存借阅成功！"));
	}
	
	/**
	 * 删除借阅
	 */
	@RequiresPermissions("borrow:borrow:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Borrow borrow) {
		borrowService.delete(borrow);
		return renderResult(Global.TRUE, text("删除借阅成功！"));
	}
	
}