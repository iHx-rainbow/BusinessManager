/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.output.web;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.output.entity.Output;
import com.jeesite.modules.output.service.OutputService;

/**
 * outputController
 * @author caoyu
 * @version 2019-09-05
 */
@Controller
@RequestMapping(value = "${adminPath}/output/output")
public class OutputController extends BaseController {

	@Autowired
	private OutputService outputService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Output get(String archiveid, boolean isNewRecord) {
		return outputService.get(archiveid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("output:output:view")
	@RequestMapping(value = {"list", ""})
	public String list(Output output, Model model) {
		model.addAttribute("output", output);
		return "modules/output/outputList";
	}
	
	/**
	 * 查询列表数据
	 */
	public Page<Output> aaa;
	@RequiresPermissions("output:output:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Output> listData(Output output, HttpServletRequest request, HttpServletResponse response) {
		output.setPage(new Page<>(request, response));
		Page<Output> page = outputService.findPage(output);
		aaa=page;
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("output:output:view")
	@RequestMapping(value = "form")
	public String form(Output output, Model model) {
		model.addAttribute("output", output);
		return "modules/output/outputForm";
	}
	
	/**
	 * 导出表单
	 */
	@RequiresPermissions("output:output:view")
	@RequestMapping(value = "Output")
	public String output() {
		//try {
			//Output output = new Output();
			//Page<Output> page = outputService.findPage(output);
			
			List<Output> findList1 = aaa.getList();
			@SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("档案数据");
			HSSFRow row = sheet.createRow(0);// 第一行
			row.createCell(0).setCellValue("档案ID");
			row.createCell(1).setCellValue("档案类型");
			row.createCell(2).setCellValue("存档点");
			row.createCell(3).setCellValue("档案标题");
			row.createCell(4).setCellValue("内容");
			row.createCell(5).setCellValue("标记");
			row.createCell(6).setCellValue("创造时间");
			row.createCell(7).setCellValue("最后修改时间");
			row.createCell(8).setCellValue("到期时间");
			row.createCell(9).setCellValue("状态");
			
			/*
			row.createCell(9).setCellValue("通知");
			row.createCell(9).setCellValue("通知");
			row.createCell(9).setCellValue("天数");
			row.createCell(9).setCellValue("常用");
			row.createCell(9).setCellValue("编号");
			row.createCell(9).setCellValue("部门");
			row.createCell(9).setCellValue("单位");
			row.createCell(9).setCellValue("发文者");
			row.createCell(9).setCellValue("有效时间");
			row.createCell(9).setCellValue("usertime");
			row.createCell(9).setCellValue("productcode");
			row.createCell(9).setCellValue("stuffcode");
			row.createCell(9).setCellValue("stuffcode");
			row.createCell(9).setCellValue("stuffcode");
			row.createCell(9).setCellValue("stuffcode");
			row.createCell(9).setCellValue("stuffcode");
			row.createCell(9).setCellValue("stuffcode");
			row.createCell(9).setCellValue("stuffcode");
			*/
			
			
			if (findList1 != null && findList1.size() != 0) {
				for (int i = 0; i < findList1.size(); i++) {
					row = sheet.createRow(i + 1);// 从第二行开始
					Output e = findList1.get(i);
					row.createCell(0).setCellValue(e.getArchiveid());
					row.createCell(1).setCellValue(e.getTypeid());
					row.createCell(2).setCellValue(e.getSaveid());
					row.createCell(3).setCellValue(e.getTitle());
					row.createCell(4).setCellValue(e.getContent());
					row.createCell(5).setCellValue(e.getRemark());
					row.createCell(6).setCellValue(e.getCreatetime());
					row.createCell(7).setCellValue(e.getLastmoditime());
					row.createCell(8).setCellValue(e.getEndtime());
					row.createCell(9).setCellValue(e.getState());
				}
			}
			
			String fileURL ="F:\\企业档案管理.xls";//path为将输出实际哪个盘下的哪个文件夹
			FileOutputStream outputStream;
			try {
				outputStream = new FileOutputStream(fileURL);
			
			outputStream.flush();// 写入生成的excel表格到服务端下
			workbook.write(outputStream);
			outputStream.close();
			} catch (Exception ex) {
			ex.printStackTrace();
			}
		
		
		
		
		
		
		
		return "modules/output/outputList";
	}
	
}