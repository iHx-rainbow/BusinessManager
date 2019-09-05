/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.endtime.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * endtimeEntity
 * @author caoyu
 * @version 2019-09-05
 */
@Table(name="borrow", alias="a", columns={
		@Column(name="borrowid", attrName="borrowid", label="借阅ID", isUpdate=false, isQuery=false),
		@Column(name="borrower", attrName="borrower", label="借阅人", isQuery=false),
		@Column(name="loginid", attrName="loginid", label="登录ID", isQuery=false),
		@Column(name="archiveid", attrName="archiveid", label="档案ID", isQuery=false),
		@Column(name="borrowtime", attrName="borrowtime", label="借出时间", isQuery=false),
		@Column(name="endtime", attrName="endtime", label="归还期限"),
		@Column(name="returntime", attrName="returntime", label="归还时间"),
		@Column(name="returnloginid", attrName="returnloginid", label="归还备注", isQuery=false),
		@Column(name="borrow_pid", attrName="borrowPid", label="borrow_pid", isPK=true),
	}, orderBy="a.borrow_pid DESC"
)
public class Endtime extends DataEntity<Endtime> {
	
	private static final long serialVersionUID = 1L;
	private Long borrowid;		// 借阅ID
	private String borrower;		// 借阅人
	private Long loginid;		// 登录ID
	private Long archiveid;		// 档案ID
	private Date borrowtime;		// 借出时间
	private Date endtime;		// 归还期限
	private String returntime;		// 归还时间
	private String returnloginid;		// 归还备注
	private String borrowPid;		// borrow_pid
	
	public Endtime() {
		this(null);
	}

	public Endtime(String id){
		super(id);
	}
	
	public Long getBorrowid() {
		return borrowid;
	}

	public void setBorrowid(Long borrowid) {
		this.borrowid = borrowid;
	}
	
	@Length(min=0, max=500, message="借阅人长度不能超过 500 个字符")
	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	
	public Long getLoginid() {
		return loginid;
	}

	public void setLoginid(Long loginid) {
		this.loginid = loginid;
	}
	
	public Long getArchiveid() {
		return archiveid;
	}

	public void setArchiveid(Long archiveid) {
		this.archiveid = archiveid;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBorrowtime() {
		return borrowtime;
	}

	public void setBorrowtime(Date borrowtime) {
		this.borrowtime = borrowtime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	
	@Length(min=0, max=100, message="归还时间长度不能超过 100 个字符")
	public String getReturntime() {
		return returntime;
	}

	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}
	
	@Length(min=0, max=100, message="归还备注长度不能超过 100 个字符")
	public String getReturnloginid() {
		return returnloginid;
	}

	public void setReturnloginid(String returnloginid) {
		this.returnloginid = returnloginid;
	}
	
	public String getBorrowPid() {
		return borrowPid;
	}

	public void setBorrowPid(String borrowPid) {
		this.borrowPid = borrowPid;
	}
	
	public Date getEndtime_gte() {
		return sqlMap.getWhere().getValue("endtime", QueryType.GTE);
	}

	public void setEndtime_gte(Date endtime) {
		sqlMap.getWhere().and("endtime", QueryType.GTE, endtime);
	}
	
	public Date getEndtime_lte() {
		return sqlMap.getWhere().getValue("endtime", QueryType.LTE);
	}

	public void setEndtime_lte(Date endtime) {
		sqlMap.getWhere().and("endtime", QueryType.LTE, endtime);
	}
	
}