/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.save.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * saveEntity
 * @author caoyu
 * @version 2019-09-05
 */
@Table(name="save", alias="a", columns={
		@Column(name="saveid", attrName="saveid", label="存档点ID", isUpdate=false, isQuery=false),
		@Column(name="savename", attrName="savename", label="存档点名称"),
		@Column(name="saveaddress", attrName="saveaddress", label="存档地址"),
		@Column(name="linker", attrName="linker", label="联系人"),
		@Column(name="telephone", attrName="telephone", label="联系电话"),
		@Column(name="fax", attrName="fax", label="传真"),
		@Column(name="remark", attrName="remark", label="备注"),
		@Column(name="pid_jeesite", attrName="pidJeesite", label="pid_jeesite", isPK=true),
	}, orderBy="a.pid_jeesite DESC"
)
public class Save extends DataEntity<Save> {
	
	private static final long serialVersionUID = 1L;
	private Long saveid;		// 存档点ID
	private String savename;		// 存档点名称
	private String saveaddress;		// 存档地址
	private String linker;		// 联系人
	private String telephone;		// 联系电话
	private String fax;		// 传真
	private String remark;		// 备注
	private String pidJeesite;		// pid_jeesite
	
	public Save() {
		this(null);
	}

	public Save(String id){
		super(id);
	}
	
	@NotNull(message="存档点ID不能为空")
	public Long getSaveid() {
		return saveid;
	}

	public void setSaveid(Long saveid) {
		this.saveid = saveid;
	}
	
	@Length(min=0, max=100, message="存档点名称长度不能超过 100 个字符")
	public String getSavename() {
		return savename;
	}

	public void setSavename(String savename) {
		this.savename = savename;
	}
	
	@Length(min=0, max=500, message="存档地址长度不能超过 500 个字符")
	public String getSaveaddress() {
		return saveaddress;
	}

	public void setSaveaddress(String saveaddress) {
		this.saveaddress = saveaddress;
	}
	
	@Length(min=0, max=100, message="联系人长度不能超过 100 个字符")
	public String getLinker() {
		return linker;
	}

	public void setLinker(String linker) {
		this.linker = linker;
	}
	
	@Length(min=0, max=100, message="联系电话长度不能超过 100 个字符")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Length(min=0, max=100, message="传真长度不能超过 100 个字符")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@Length(min=0, max=500, message="备注长度不能超过 500 个字符")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getPidJeesite() {
		return pidJeesite;
	}

	public void setPidJeesite(String pidJeesite) {
		this.pidJeesite = pidJeesite;
	}
	
}