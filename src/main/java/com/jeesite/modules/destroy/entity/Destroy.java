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
 * @version 2019-09-04
 */
@Table(name="destroy", alias="a", columns={
		@Column(name="destroyid", attrName="destroyid", label="destroyid", isPK=true),
		@Column(name="archiveid", attrName="archiveid", label="archiveid"),
		@Column(name="loginid", attrName="loginid", label="loginid"),
		@Column(name="destroytime", attrName="destroytime", label="destroytime"),
		@Column(name="reason", attrName="reason", label="reason"),
		@Column(name="remark", attrName="remark", label="remark"),
	}, orderBy="a.destroyid DESC"
)
public class Destroy extends DataEntity<Destroy> {
	
	private static final long serialVersionUID = 1L;
	private Long destroyid;		// destroyid
	private Long archiveid;		// archiveid
	private Long loginid;		// loginid
	private String destroytime;		// destroytime
	private String reason;		// reason
	private String remark;		// remark
	
	public Destroy() {
		this(null);
	}

	public Destroy(String id){
		super(id);
	}
	
	public Long getDestroyid() {
		return destroyid;
	}

	public void setDestroyid(Long destroyid) {
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
	
	@Length(min=0, max=100, message="destroytime长度不能超过 100 个字符")
	public String getDestroytime() {
		return destroytime;
	}

	public void setDestroytime(String destroytime) {
		this.destroytime = destroytime;
	}
	
	@Length(min=0, max=100, message="reason长度不能超过 100 个字符")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Length(min=0, max=100, message="remark长度不能超过 100 个字符")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}