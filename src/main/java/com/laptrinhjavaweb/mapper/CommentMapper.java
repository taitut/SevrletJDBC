package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;

import com.laptrinhjavaweb.model.Comment;

public class CommentMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet resultSet) {
        try {
            Comment comment = new Comment();
            comment.setId(resultSet.getLong("id"));
            comment.setNewsId(resultSet.getLong("newsId"));
            comment.setUserId(resultSet.getLong("userId"));
            comment.setContent(resultSet.getString("content"));
            comment.setCreatedBy(resultSet.getString("createdBy"));
            comment.setModifiedBy(resultSet.getString("modifiedBy"));
            comment.setCreateDate(resultSet.getTimestamp("createDate"));
            comment.setCreateDate(resultSet.getTimestamp("modifiedDate"));
            return comment;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
