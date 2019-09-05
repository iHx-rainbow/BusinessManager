/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.destroy.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * destroyEntity
 * @author caoyu
 * @version 2019-09-05
 */
@Table(name="destroy", alias="a", columns={
		@Column(name="destroyid", attrName="destroyid", label="销毁", isPK=true),
		@Column(name="archiveid", attrName="archiveid", label="档案ID"),
		@Column(name="loginid", attrName="loginid", label="登录ID"),
		@Column(name="destroytime", attrName="destroytime", label="销毁时间"),
		@Column(name="reason", attrName="reason", label="销毁原因"),
		@Column(name="remark", attrName="remark", label="是否审核"),
	}, orderBy="a.destroyid DESC"
)
public class Destroy extends DataEntity<Destroy> {
	
	private static final long serialVersionUID = 1L;
	private String destroyid;		// 销毁
	private Long archiveid;		// 档案ID
	private Long loginid;		// 登录ID
	private String destroytime;		// 销毁时间
	private String reason;		// 销毁原因
	private String remark;		// 是否审核
	
	public Destroy() {
		this(null);
	}

	public Destroy(String id){
		super(id);
	}
	
	public String getDestroyid() {
		return destroyid;
	}

	public void setDestroyid(String destroyid) {
		this.destroyid = destroyid;
	}
	
	public Long getArchiveid() {
		return archiveid;
	}

	public void setArchiveid(Long archiveid) {
		this.archiveid = archiveid;
	}
	
	public Long getLoginid() {
		return loginid;
	}

	public void setLoginid(Long loginid) {
		this.loginid = loginid;
	}
	
	@Length(min=0, max=100, message="销毁时间长度不能超过 100 个字符")
	public String getDestroytime() {
		return destroytime;
	}

	public void setDestroytime(String destroytime) {
		this.destroytime = destroytime;
	}
	
	@Length(min=0, max=100, message="销毁原因长度不能超过 100 个字符")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Length(min=0, max=100, message="是否审核长度不能超过 100 个字符")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}