package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.mapper.RowMapper;

public interface GenericDAO<T> {
    <T> List<T> query(String sql, RowMapper<T> row, Object... parameters);

    void update(String Sql, Object... parameters);

    Long insert(String Sql, Object... parameters);

    int Count(String sql, Object... parameters);
}
