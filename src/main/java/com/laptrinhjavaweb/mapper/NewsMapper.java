package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.laptrinhjavaweb.model.News;

public class NewsMapper implements RowMapper<News> {

    @Override
    public News mapRow(ResultSet resultSet) {
        try {
            News news = new News();
            news.setId(resultSet.getLong("id"));
            news.setTitle(resultSet.getString("title"));
            news.setShortDescription(resultSet.getString("shortDescription"));
            news.setContent(resultSet.getString("content"));
            news.setThumbnail(resultSet.getString("thumbnail"));
            news.setCatgoryId(resultSet.getLong("categoryId"));
            news.setCreatedBy(resultSet.getString("createdBy"));
            news.setCreateDate(resultSet.getTimestamp("createDate"));
            if (resultSet.getTimestamp("modifiedDate") != null) {
                news.setModifiedDate(resultSet.getTimestamp("modifiedDate"));
            } else {
                news.setModifiedDate(new Timestamp(System.currentTimeMillis()));
            }
            if (resultSet.getString("modifiedBy") != null) {
                news.setModifiedBy(resultSet.getString("modifiedBy"));
            } else {
                news.setModifiedBy("");
            }
            return news;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
