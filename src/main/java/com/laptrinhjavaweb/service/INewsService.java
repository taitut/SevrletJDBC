package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.News;

public interface INewsService {
	List<News>  findByCategoryId(Long categoryId);
	News save(News news);
	News update(News news);
	void delete(Long[] ids);

	List<News>  findAllNews();
	List<News>  findNBy(String filed, Object... objects);
}
