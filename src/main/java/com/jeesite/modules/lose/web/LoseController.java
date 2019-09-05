/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.lose.web;

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
import com.jeesite.modules.lose.entity.Lose;
import com.jeesite.modules.lose.service.LoseService;

/**
 * loseController
 * @author caoyu
 * @version 2019-09-05
 */
@Controller
@RequestMapping(value = "${adminPath}/lose/lose")
public class LoseController extends BaseController {

	@Autowired
	private LoseService loseService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Lose get(String loseid, boolean isNewRecord) {
		return loseService.get(loseid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("lose:lose:view")
	@RequestMapping(value = {"list", ""})
	public String list(Lose lose, Model model) {
		model.addAttribute("lose", lose);
		return "modules/lose/loseList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("lose:lose:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Lose> listData(Lose lose, HttpServletRequest request, HttpServletResponse response) {
		lose.setPage(new Page<>(request, response));
		Page<Lose> page = loseService.findPage(lose);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("lose:lose:view")
	@RequestMapping(value = "form")
	public String form(Lose lose, Model model) {
		model.addAttribute("lose", lose);
		return "modules/lose/loseForm";
	}

	/**
	 * 保存丢失
	 */
	@RequiresPermissions("lose:lose:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Lose lose) {
		loseService.save(lose);
		return renderResult(Global.TRUE, text("保存丢失成功！"));
	}
	
	/**
	 * 删除丢失
	 */
	@RequiresPermissions("lose:lose:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Lose lose) {
		loseService.delete(lose);
		return renderResult(Global.TRUE, text("删除丢失成功！"));
	}
	
}