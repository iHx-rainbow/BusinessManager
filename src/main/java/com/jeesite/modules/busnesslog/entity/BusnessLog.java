/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.busnesslog.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * busnesslogEntity
 * @author caoyu
 * @version 2019-09-05
 */
@Table(name="log", alias="a", columns={
		@Column(name="logid", attrName="logid", label="logid", isPK=true),
		@Column(name="uid", attrName="uid", label="用户id"),
		@Column(name="logname", attrName="logname", label="日志名字"),
		@Column(name="logdesc", attrName="logdesc", label="日志描述"),
		@Column(name="logtime", attrName="logtime", label="记录时间"),
	}, orderBy="a.logid DESC"
)
public class BusnessLog extends DataEntity<BusnessLog> {
	
	private static final long serialVersionUID = 1L;
	private Integer logid;		// logid
	private String uid;		// 用户id
	private String logname;		// 日志名字
	private String logdesc;		// 日志描述
	private String logtime;		// 记录时间
	
	public BusnessLog() {
		this(null);
	}

	public BusnessLog(String id){
		super(id);
	}
	
	public Integer getLogid() {
		return logid;
	}

	public void setLogid(Integer logid) {
		this.logid = logid;
	}
	
	@Length(min=0, max=50, message="用户id长度不能超过 50 个字符")
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	@Length(min=0, max=50, message="日志名字长度不能超过 50 个字符")
	public String getLogname() {
		return logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}
	
	@Length(min=0, max=500, message="日志描述长度不能超过 500 个字符")
	public String getLogdesc() {
		return logdesc;
	}

	public void setLogdesc(String logdesc) {
		this.logdesc = logdesc;
	}
	
	@Length(min=0, max=500, message="记录时间长度不能超过 500 个字符")
	public String getLogtime() {
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	
}