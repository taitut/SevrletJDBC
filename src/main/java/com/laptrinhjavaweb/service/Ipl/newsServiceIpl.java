package com.laptrinhjavaweb.service.Ipl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.DAO.ICommentDao;
import com.laptrinhjavaweb.DAO.INewsDao;

import com.laptrinhjavaweb.model.News;
import com.laptrinhjavaweb.service.INewsService;

public class newsServiceIpl implements INewsService {
	@Inject
	private INewsDao newDao;
	@Inject
	private ICommentDao commentDao;
	@Override
	public List<News> findByCategoryId(Long categoryId) {
		return newDao.findNByCategoryId(categoryId);
	}

	@Override
	public News save(News news) {
		news.setCreateDate(new Timestamp(System.currentTimeMillis()));
		news.setCreatedBy("");
		news.setModifiedBy("");
		news.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		Long newsId = newDao.save(news);
		System.out.println(newsId);
		return newDao.findOne(newsId);
	}

	@Override
	public News update(News news) {
		
		News oldNews = newDao.findOne(news.getId());
		news.setCreateDate(oldNews.getCreateDate());
		news.setCreatedBy(oldNews.getCreatedBy());
		news.setModifiedBy("");
		news.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		newDao.update(news);
		return newDao.findOne(news.getId());
	}


	@Override
	public List<News> findAllNews(Integer offSet, Integer limit) {

		return newDao.findAllNews(offSet,limit);
	}

	@Override
	public List<News> findNBy(String filed, Object... objects) {

		return newDao.findNBy(filed, objects);
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			commentDao.deleteByNewsId(id);
			newDao.delete(id);
		}
	}

	@Override
	public int getTotalItem() {
		return newDao.getTotalItem();
	}

	
		
	

}
