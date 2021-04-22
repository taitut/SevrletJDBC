package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.Comment;

public interface ICommentService {
	List<Comment>  findNByUser(Long userId);
	List<Comment>  findNByNews(Long userId);
	List<Comment>  findAllComment();
	Comment save(Comment comment);
	Comment update(Comment comment);
	void delete(Long [] ids);
	List<Comment>  findNBy( String filed, Object... objects);
}
