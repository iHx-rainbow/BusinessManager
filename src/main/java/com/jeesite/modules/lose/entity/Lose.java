/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.lose.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * loseEntity
 * @author caoyu
 * @version 2019-09-05
 */
@Table(name="lose", alias="a", columns={
		@Column(name="loseid", attrName="loseid", label="loseid", isPK=true),
		@Column(name="archiveid", attrName="archiveid", label="档案ID"),
		@Column(name="type", attrName="type", label="丢失类型"),
		@Column(name="loginid", attrName="loginid", label="登录ID", isQuery=false),
		@Column(name="loser", attrName="loser", label="丢失者"),
		@Column(name="losertime", attrName="losertime", label="丢失时间"),
		@Column(name="remark", attrName="remark", label="审核状态"),
	}, orderBy="a.loseid DESC"
)
public class Lose extends DataEntity<Lose> {
	
	private static final long serialVersionUID = 1L;
	private String loseid;		// loseid
	private Long archiveid;		// 档案ID
	private String type;		// 丢失类型
	private Long loginid;		// 登录ID
	private String loser;		// 丢失者
	private String losertime;		// 丢失时间
	private String remark;		// 审核状态
	
	public Lose() {
		this(null);
	}

	public Lose(String id){
		super(id);
	}
	
	public String getLoseid() {
		return loseid;
	}

	public void setLoseid(String loseid) {
		this.loseid = loseid;
	}
	
	public Long getArchiveid() {
		return archiveid;
	}

	public void setArchiveid(Long archiveid) {
		this.archiveid = archiveid;
	}
	
	@Length(min=0, max=500, message="丢失类型长度不能超过 500 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Long getLoginid() {
		return loginid;
	}

	public void setLoginid(Long loginid) {
		this.loginid = loginid;
	}
	
	@Length(min=0, max=100, message="丢失者长度不能超过 100 个字符")
	public String getLoser() {
		return loser;
	}

	public void setLoser(String loser) {
		this.loser = loser;
	}
	
	@Length(min=0, max=100, message="丢失时间长度不能超过 100 个字符")
	public String getLosertime() {
		return losertime;
	}

	public void setLosertime(String losertime) {
		this.losertime = losertime;
	}
	
	@Length(min=0, max=100, message="审核状态长度不能超过 100 个字符")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}