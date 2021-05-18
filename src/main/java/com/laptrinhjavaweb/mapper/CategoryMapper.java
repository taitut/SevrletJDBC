package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.Category;

public class CategoryMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet resultSet) {
        try {
            Category category = new Category();
            category.setId(resultSet.getLong("id"));
            category.setCode(resultSet.getString("code"));
            category.setName(resultSet.getString("name"));
            category.setCreatedBy(resultSet.getString("createdBy"));
            category.setModifiedBy(resultSet.getString("modifiedBy"));
            category.setCreateDate(resultSet.getTimestamp("createDate"));
            category.setCreateDate(resultSet.getTimestamp("modifiedDate"));
            return category;
        } catch (SQLException e) {
            return null;
        }

    }


}
