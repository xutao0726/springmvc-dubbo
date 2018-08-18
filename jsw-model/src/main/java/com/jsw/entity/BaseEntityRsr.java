package com.jsw.entity;

import java.io.Serializable;
import java.util.Date;


public class BaseEntityRsr extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 2572825715541036821L;

	/**
	 * 起始页
	 */
	public int start;

	/**
	 * 一页显示的查询记录
	 */
	public int pageSize =6;
	
	
	public Date updateTime;
	
	public String searchStr;
	
	public Integer limit;
	
	

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
		super.getPage().setStart(start);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		super.getPage().setPageSize(pageSize);
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getSearchStr() {
		return searchStr;
	}

	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
		super.getPage().setSearchStr(searchStr);
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	
}