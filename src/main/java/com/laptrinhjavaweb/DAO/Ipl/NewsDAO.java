package com.laptrinhjavaweb.DAO.Ipl;

import java.util.List;

import com.laptrinhjavaweb.DAO.INewsDao;
import com.laptrinhjavaweb.mapper.NewsMapper;
import com.laptrinhjavaweb.model.News;

public class NewsDAO extends AbstractDAO<News> implements INewsDao {

	@Override
	public List<News> findNByCategoryId(Long categoryId) {
		String sql = "select * from news where categoryId = ?";
		return query(sql, new NewsMapper(), categoryId);
	}

	@Override
	public Long save(News news) {
			String sql = "Insert into news ( title, thumbnail, shortDescription, content, createDate, modifiedDate, createdBy, modifiedBy, categoryId) VALUES (?,?,?,?,?,?,?,?,?)";
			return insert(sql, news.getTitle(),news.getThumbnail(),news.getShortDescription(),news.getContent(),
					news.getCreateDate(),news.getModifiedDate(),news.getCreatedBy(),news.getModifiedBy(),news.getCatgoryId());
	}

	@Override
	public void update(News news) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?,thumbnail = ?, shortDescription = ?, content = ?,") ;
		sql.append("createDate = ?, modifiedDate = ? , createdBy = ?, modifiedBy = ?, categoryId =?");
		sql.append(" where id = ?");
		this.update(sql.toString(), news.getTitle(),news.getThumbnail(),news.getShortDescription(),news.getContent(),
				news.getCreateDate(),news.getModifiedDate(),news.getCreatedBy(),news.getModifiedBy(),news.getCatgoryId(),news.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		this.update(sql, id);
	}

	@Override
	public List<News> findAllNews() {
		String sql = "SELECT * FROM news";
		
		return query(sql, new NewsMapper());
		
	}

	@Override
	public List<News> findNBy( String filed, Object... objects ) {
		
		String sql = "select * from news where "+ filed+" = ?";
		return query(sql,new NewsMapper() ,objects );
	}

	@Override
	public News findOne(Long id) {
		String sql = "select * from news where Id = ?";
		 List<News> news = query(sql, new NewsMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

//	@Override
//	public void deleteByCategoryId(Long id) {
//		String sql = "DELETE FROM news WHERE categoryId = ?";
//		this.update(sql, id);
//	}
	
}
