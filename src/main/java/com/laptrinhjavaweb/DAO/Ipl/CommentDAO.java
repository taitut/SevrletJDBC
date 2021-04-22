package com.laptrinhjavaweb.DAO.Ipl;

import java.util.List;

import com.laptrinhjavaweb.DAO.ICommentDao;
import com.laptrinhjavaweb.mapper.CommentMapper;
import com.laptrinhjavaweb.model.Comment;

public class CommentDAO extends AbstractDAO<Comment> implements ICommentDao{

	@Override
	public List<Comment> findNByUser(Long userId) {
		String sql = "select * from comment where userId = ?";
		return query(sql, new CommentMapper(), userId);
	}

	@Override
	public List<Comment> findNByNews(Long userId) {
		String sql = "select * from comment where newsId = ?";
		return query(sql, new CommentMapper(), userId);
	}

	@Override
	public List<Comment> findAllComment() {
		String sql = "SELECT * FROM comment";		
		return query(sql, new CommentMapper());
	}

	@Override
	public Long save(Comment comment) {
		String sql = "Insert into comment (content, userId, newsId, createDate, modifiedDate, createdBy, modifiedBy) VALUES (?,?,?,?,?,?,?)";
		return insert(sql, comment.getContent(),comment.getUserId(),comment.getNewsId(),
				comment.getCreateDate(),comment.getModifiedDate(),comment.getCreatedBy(),comment.getModifiedBy());
	}

	@Override
	public void update(Comment comment) {
		StringBuilder sql = new StringBuilder("UPDATE comment SET content = ?,userId = ?, newsId = ?,") ;
		sql.append("createDate = ?, modifiedDate = ? , createdBy = ?, modifiedBy = ?");
		sql.append(" where id = ?");
		this.update(sql.toString(), comment.getContent(),comment.getUserId(),comment.getNewsId(),
				comment.getCreateDate(),comment.getModifiedDate(),comment.getCreatedBy(),comment.getModifiedBy(),comment.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM comment WHERE id = ?";
		this.update(sql, id);
		
	}

	@Override
	public void deleteByUserId(Long id) {
		String sql = "DELETE FROM comment WHERE userId = ?";
		this.update(sql, id);
		
	}

	@Override
	public void deleteByNewsId(Long id) {
		String sql = "DELETE FROM comment WHERE newsId = ?";
		this.update(sql, id);
		
	}

	@Override
	public List<Comment> findNBy(String filed, Object... objects) {
		String sql = "select * from comment where "+ filed+" = ?";
		return query(sql,new CommentMapper() ,objects );
	}

	@Override
	public Comment findOne(Long id) {
		String sql = "select * from comment where Id = ?";
		 List<Comment> comment = query(sql, new CommentMapper(), id);
		return comment.isEmpty() ? null : comment.get(0);
	}

}
