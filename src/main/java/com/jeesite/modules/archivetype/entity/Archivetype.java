/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.archivetype.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * archivetypeEntity
 * @author caoyu
 * @version 2019-09-04
 */
@Table(name="archivetype", alias="a", columns={
		@Column(name="archivetypeid", attrName="archivetypeid", label="档案类型编号", isPK=true),
		@Column(name="archivetypename", attrName="archivetypename", label="档案类型名字"),
	}, orderBy="a.archivetypeid DESC"
)
public class Archivetype extends DataEntity<Archivetype> {
	
	private static final long serialVersionUID = 1L;
	private Long archivetypeid;		// 档案类型编号
	private String archivetypename;		// 档案类型名字
	
	public Archivetype() {
		this(null);
	}

	public Archivetype(String id){
		super(id);
	}
	
	public Long getArchivetypeid() {
		return archivetypeid;
	}

	public void setArchivetypeid(Long archivetypeid) {
		this.archivetypeid = archivetypeid;
	}
	
	@Length(min=0, max=100, message="档案类型名字长度不能超过 100 个字符")
	public String getArchivetypename() {
		return archivetypename;
	}

	public void setArchivetypename(String archivetypename) {
		this.archivetypename = archivetypename;
	}
	
}