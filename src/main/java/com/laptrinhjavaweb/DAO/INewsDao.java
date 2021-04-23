package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.Pageble.Pageble;
import com.laptrinhjavaweb.model.News;

public interface INewsDao extends GenericDAO<News> {
	List<News>  findNByCategoryId(Long categoryId);
	List<News>  findAllNews(Pageble pageble);
	Long save(News news);
	void update(News news);
	void delete(Long id);
//	void deleteByCategoryId(Long id);
	List<News>  findNBy( String filed, Object... objects);
	News findOne(Long id);
	int getTotalItem();
}
