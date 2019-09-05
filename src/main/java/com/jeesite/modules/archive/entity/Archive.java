/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.archive.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * archiveEntity
 * @author caoyu
 * @version 2019-09-04
 */
@Table(name="archive", alias="a", columns={
		@Column(name="archiveid", attrName="archiveid", label="档案编号", isPK=true),
		@Column(name="typeid", attrName="typeid", label="档案类型"),
		@Column(name="saveid", attrName="saveid", label="存档点"),
		@Column(name="title", attrName="title", label="档案标题", queryType=QueryType.LIKE),
		@Column(name="content", attrName="content", label="内容描述"),
		@Column(name="remark", attrName="remark", label="观察、评论"),
		@Column(name="creater", attrName="creater", label="建档用户"),
		@Column(name="createtime", attrName="createtime", label="建档日期"),
		@Column(name="lastmodiuser", attrName="lastmodiuser", label="修改用户"),
		@Column(name="lastmoditime", attrName="lastmoditime", label="修改日期"),
		@Column(name="levelid", attrName="levelid", label="安全级别"),
		@Column(name="endtime", attrName="endtime", label="过期时间", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="state", attrName="state", label="档案状态", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="endalert", attrName="endalert", label="过期通知", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="endisalert", attrName="endisalert", label="过期通知", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="endbeforeday", attrName="endbeforeday", label="通知天数", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="isoften", attrName="isoften", label="是否常用", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="filecode", attrName="filecode", label="文件编号", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="fromdept", attrName="fromdept", label="来问部门", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="fromunit", attrName="fromunit", label="发文单位", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="fromuser", attrName="fromuser", label="发文者", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="impacttime", attrName="impacttime", label="有效时间", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="usertime", attrName="usertime", label="usertime", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="productcode", attrName="productcode", label="productcode", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="stuffcode", attrName="stuffcode", label="stuffcode", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="number", attrName="number", label="number", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="pagecount", attrName="pagecount", label="pagecount", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="patenrcode", attrName="patenrcode", label="专利id", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="checkuser", attrName="checkuser", label="审查者", isInsert=false, isUpdate=false, isQuery=false),
	}, orderBy="a.archiveid DESC"
)
public class Archive extends DataEntity<Archive> {
	
	private static final long serialVersionUID = 1L;
	private Long archiveid;		// 档案编号
	private Long typeid;		// 档案类型
	private Long saveid;		// 存档点
	private String title;		// 档案标题
	private String content;		// 内容描述
	private String remark;		// 观察、评论
	private Long creater;		// 建档用户
	private String createtime;		// 建档日期
	private String lastmodiuser;		// 修改用户
	private String lastmoditime;		// 修改日期
	private Long levelid;		// 安全级别
	private String endtime;		// 过期时间
	private String state;		// 档案状态
	private String endalert;		// 过期通知
	private String endisalert;		// 过期通知
	private Long endbeforeday;		// 通知天数
	private String isoften;		// 是否常用
	private String filecode;		// 文件编号
	private Long fromdept;		// 来问部门
	private String fromunit;		// 发文单位
	private String fromuser;		// 发文者
	private String impacttime;		// 有效时间
	private String usertime;		// usertime
	private String productcode;		// productcode
	private String stuffcode;		// stuffcode
	private Long number;		// number
	private Long pagecount;		// pagecount
	private Long patenrcode;		// 专利id
	private String checkuser;		// 审查者
	
	public Archive() {
		this(null);
	}

	public Archive(String id){
		super(id);
	}
	
	public Long getArchiveid() {
		return archiveid;
	}

	public void setArchiveid(Long archiveid) {
		this.archiveid = archiveid;
	}
	
	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}
	
	public Long getSaveid() {
		return saveid;
	}

	public void setSaveid(Long saveid) {
		this.saveid = saveid;
	}
	
	@Length(min=0, max=150, message="档案标题长度不能超过 150 个字符")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=500, message="内容描述长度不能超过 500 个字符")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=500, message="观察、评论长度不能超过 500 个字符")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Long getCreater() {
		return creater;
	}

	public void setCreater(Long creater) {
		this.creater = creater;
	}
	
	@Length(min=0, max=100, message="建档日期长度不能超过 100 个字符")
	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	@Length(min=0, max=100, message="修改用户长度不能超过 100 个字符")
	public String getLastmodiuser() {
		return lastmodiuser;
	}

	public void setLastmodiuser(String lastmodiuser) {
		this.lastmodiuser = lastmodiuser;
	}
	
	@Length(min=0, max=100, message="修改日期长度不能超过 100 个字符")
	public String getLastmoditime() {
		return lastmoditime;
	}

	public void setLastmoditime(String lastmoditime) {
		this.lastmoditime = lastmoditime;
	}
	
	public Long getLevelid() {
		return levelid;
	}

	public void setLevelid(Long levelid) {
		this.levelid = levelid;
	}
	
	@Length(min=0, max=100, message="过期时间长度不能超过 100 个字符")
	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	@Length(min=0, max=100, message="档案状态长度不能超过 100 个字符")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Length(min=0, max=100, message="过期通知长度不能超过 100 个字符")
	public String getEndalert() {
		return endalert;
	}

	public void setEndalert(String endalert) {
		this.endalert = endalert;
	}
	
	@Length(min=0, max=100, message="过期通知长度不能超过 100 个字符")
	public String getEndisalert() {
		return endisalert;
	}

	public void setEndisalert(String endisalert) {
		this.endisalert = endisalert;
	}
	
	public Long getEndbeforeday() {
		return endbeforeday;
	}

	public void setEndbeforeday(Long endbeforeday) {
		this.endbeforeday = endbeforeday;
	}
	
	@Length(min=0, max=100, message="是否常用长度不能超过 100 个字符")
	public String getIsoften() {
		return isoften;
	}

	public void setIsoften(String isoften) {
		this.isoften = isoften;
	}
	
	@Length(min=0, max=100, message="文件编号长度不能超过 100 个字符")
	public String getFilecode() {
		return filecode;
	}

	public void setFilecode(String filecode) {
		this.filecode = filecode;
	}
	
	public Long getFromdept() {
		return fromdept;
	}

	public void setFromdept(Long fromdept) {
		this.fromdept = fromdept;
	}
	
	@Length(min=0, max=100, message="发文单位长度不能超过 100 个字符")
	public String getFromunit() {
		return fromunit;
	}

	public void setFromunit(String fromunit) {
		this.fromunit = fromunit;
	}
	
	@Length(min=0, max=100, message="发文者长度不能超过 100 个字符")
	public String getFromuser() {
		return fromuser;
	}

	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}
	
	@Length(min=0, max=100, message="有效时间长度不能超过 100 个字符")
	public String getImpacttime() {
		return impacttime;
	}

	public void setImpacttime(String impacttime) {
		this.impacttime = impacttime;
	}
	
	@Length(min=0, max=100, message="usertime长度不能超过 100 个字符")
	public String getUsertime() {
		return usertime;
	}

	public void setUsertime(String usertime) {
		this.usertime = usertime;
	}
	
	@Length(min=0, max=100, message="productcode长度不能超过 100 个字符")
	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	
	@Length(min=0, max=100, message="stuffcode长度不能超过 100 个字符")
	public String getStuffcode() {
		return stuffcode;
	}

	public void setStuffcode(String stuffcode) {
		this.stuffcode = stuffcode;
	}
	
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	
	public Long getPagecount() {
		return pagecount;
	}

	public void setPagecount(Long pagecount) {
		this.pagecount = pagecount;
	}
	
	public Long getPatenrcode() {
		return patenrcode;
	}

	public void setPatenrcode(Long patenrcode) {
		this.patenrcode = patenrcode;
	}
	
	@Length(min=0, max=100, message="审查者长度不能超过 100 个字符")
	public String getCheckuser() {
		return checkuser;
	}

	public void setCheckuser(String checkuser) {
		this.checkuser = checkuser;
	}
	
}