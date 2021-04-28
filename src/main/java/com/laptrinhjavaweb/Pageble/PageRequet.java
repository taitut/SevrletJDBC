package com.laptrinhjavaweb.Pageble;

import com.laptrinhjavaweb.sort.sorter;

public class PageRequet implements Pageble {

	private Integer page;
	private Integer maxPageItem;
	private sorter sort;
	public PageRequet(Integer page, Integer maxPageItem, sorter sort) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sort = sort;
	}

	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getOffset() {
		if (this.page != null && this.maxPageItem != null) {
			return (this.page-1 ) * this.maxPageItem;
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		return this.maxPageItem+1;
	}
	@Override
	public sorter getSorter() {
		if (this.sort != null) {
			return sort;
		}
		return null;
		
	}



}
