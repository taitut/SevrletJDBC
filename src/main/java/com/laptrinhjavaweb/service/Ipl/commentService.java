package com.laptrinhjavaweb.service.Ipl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.DAO.ICommentDao;
import com.laptrinhjavaweb.model.Comment;
import com.laptrinhjavaweb.service.ICommentService;

public class commentService implements ICommentService {
	
	@Inject
	private ICommentDao commentDao;

	
	@Override
	public List<Comment> findNByUser(Long userId) {
		return commentDao.findNByUser(userId);
	}

	@Override
	public List<Comment> findNByNews(Long userId) {
		return commentDao.findNByNews(userId);
	}

	@Override
	public List<Comment> findAllComment() {
		return commentDao.findAllComment();
		
	}

	@Override
	public Comment save(Comment comment) {
		comment.setCreateDate(new Timestamp(System.currentTimeMillis()));
		comment.setCreatedBy("");
		comment.setModifiedBy("");
		comment.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		Long commentId = commentDao.save(comment);
		System.out.println(commentId);
		return commentDao.findOne(commentId);
	}

	@Override
	public Comment update(Comment comment) {
		Comment oldCmment = commentDao.findOne(comment.getId());
		comment.setCreateDate(oldCmment.getCreateDate());
		comment.setCreatedBy(oldCmment.getCreatedBy());
		comment.setModifiedBy("");
		comment.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		commentDao.update(comment);
		return commentDao.findOne(comment.getId());
		
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			commentDao.delete(id);
		}
		
	}

	@Override
	public List<Comment> findNBy(String filed, Object... objects) {
		return commentDao.findNBy(filed, objects);
	}


	

}