package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet resultSet) {
		try {
			User user = new User();
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("userName"));
			user.setPassword(resultSet.getString("password"));
			user.setStatus(resultSet.getInt("status"));
			user.setRole(resultSet.getLong("roleId"));
			user.setCreatedBy(resultSet.getString("createdBy"));
			user.setModifiedBy(resultSet.getString("modifiedBy"));
			user.setCreateDate(resultSet.getTimestamp("createDate"));
			user.setCreateDate(resultSet.getTimestamp("modifiedDate"));
		
		return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
