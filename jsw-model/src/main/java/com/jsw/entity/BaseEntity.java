package com.jsw.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable{
	
	public Page page = new Page();
	
	public String [] companyIds;//companyids
	
	public Date createTimeStart;
    
    public Date createTimeEnd;
    
    

	public Date getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(Date createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String[] getCompanyIds() {
		return companyIds;
	}

	public void setCompanyIds(String[] companyIds) {
		this.companyIds = companyIds;
	}

	public Page getPage() {
		
		return page;
	}

	public void setPage(Page page) {
		BaseEntityRsr br = new BaseEntityRsr();
		br.setStart(page.getStart());
		br.setPageSize(page.getPageSize());
		br.setSearchStr(page.getSearchStr());
		this.page = page;
	}
	
	
}
