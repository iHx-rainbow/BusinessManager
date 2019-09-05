/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.borrow.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * borrowEntity
 * @author caoyu
 * @version 2019-09-04
 */
@Table(name="borrow", alias="a", columns={
		@Column(name="borrowid", attrName="borrowid", label="borrowid", isPK=true),
		@Column(name="borrower", attrName="borrower", label="borrower"),
		@Column(name="loginid", attrName="loginid", label="loginid"),
		@Column(name="archiveid", attrName="archiveid", label="archiveid"),
		@Column(name="borrowtime", attrName="borrowtime", label="borrowtime"),
		@Column(name="endtime", attrName="endtime", label="endtime"),
		@Column(name="returntime", attrName="returntime", label="returntime"),
		@Column(name="returnloginid", attrName="returnloginid", label="returnloginid"),
	}, orderBy="a.borrowid DESC"
)
public class Borrow extends DataEntity<Borrow> {
	
	private static final long serialVersionUID = 1L;
	private Long borrowid;		// borrowid
	private String borrower;		// borrower
	private Long loginid;		// loginid
	private Long archiveid;		// archiveid
	private String borrowtime;		// borrowtime
	private String endtime;		// endtime
	private String returntime;		// returntime
	private String returnloginid;		// returnloginid
	
	public Borrow() {
		this(null);
	}

	public Borrow(String id){
		super(id);
	}
	
	public Long getBorrowid() {
		return borrowid;
	}

	public void setBorrowid(Long borrowid) {
		this.borrowid = borrowid;
	}
	
	@Length(min=0, max=500, message="borrower长度不能超过 500 个字符")
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
	
	@Length(min=0, max=100, message="borrowtime长度不能超过 100 个字符")
	public String getBorrowtime() {
		return borrowtime;
	}

	public void setBorrowtime(String borrowtime) {
		this.borrowtime = borrowtime;
	}
	
	@Length(min=0, max=100, message="endtime长度不能超过 100 个字符")
	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	@Length(min=0, max=100, message="returntime长度不能超过 100 个字符")
	public String getReturntime() {
		return returntime;
	}

	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}
	
	@Length(min=0, max=100, message="returnloginid长度不能超过 100 个字符")
	public String getReturnloginid() {
		return returnloginid;
	}

	public void setReturnloginid(String returnloginid) {
		this.returnloginid = returnloginid;
	}
	
}