package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;

import com.laptrinhjavaweb.model.Role;

public class RoleMapper implements RowMapper<Role> {

	@Override
	public Role mapRow(ResultSet resultSet) {
		try {
			Role role = new Role();
			role.setId(resultSet.getLong("id"));
			role.setName(resultSet.getString("name"));
			role.setCode(resultSet.getString("code"));
			role.setCreatedBy(resultSet.getString("createdBy"));
			role.setModifiedBy(resultSet.getString("modifiedBy"));
			role.setCreateDate(resultSet.getTimestamp("createDate"));
			role.setCreateDate(resultSet.getTimestamp("modifiedDate"));
			return role;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	

}
