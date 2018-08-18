package com.jsw.entity;

import java.io.Serializable;

public class Page implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Integer start;
	public Integer nowPage = 1;	//当前页数
	public Integer pageSize = 6;  //每页的个数
	public Integer count;   //总个数
	public Integer pageCount;   //总页数
	
	public String searchStr;
	
	public String getSearchStr() {
		return searchStr;
	}
	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}
	public Integer getStart() {
		this.start = (nowPage - 1) * pageSize;
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getNowPage() {
		return nowPage;
	}
	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getPageCount() {
		if(count==null||count==0)
			return 0;
		if(this.pageCount == null) 
			this.pageCount = count%pageSize>0?count/pageSize+1:count/pageSize;
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
	
}
