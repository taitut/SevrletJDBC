package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.model.Comment;

public interface ICommentDao {

    List<Comment> findNByUser(Long userId);

    List<Comment> findNByNews(Long userId);

    List<Comment> findAllComment();

    Long save(Comment comment);

    void update(Comment comment);

    void delete(Long id);

    void deleteByUserId(Long id);

    void deleteByNewsId(Long id);

    List<Comment> findNBy(String filed, Object... objects);

    Comment findOne(Long id);
}
