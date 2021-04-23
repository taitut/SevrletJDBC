package com.laptrinhjavaweb.Pageble;

import com.laptrinhjavaweb.sort.sorter;

public interface Pageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	sorter getSorter();
}
