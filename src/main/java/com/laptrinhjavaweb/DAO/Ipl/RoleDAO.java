package com.laptrinhjavaweb.DAO.Ipl;

import java.util.List;

import com.laptrinhjavaweb.DAO.IRoleDao;
import com.laptrinhjavaweb.mapper.RoleMapper;
import com.laptrinhjavaweb.model.Role;

public class RoleDAO extends AbstractDAO<Role> implements IRoleDao{


	@Override
	public Role findOne(Long id) {
		String sql = "select * from role where Id = ?";
		 List<Role> role = query(sql, new RoleMapper(), id);
		return role.isEmpty() ? null : role.get(0);
	}
	@Override
	public List<Role> findAllRole() {
		String sql = "SELECT * FROM role";
		return query(sql, new RoleMapper());
	}

	@Override
	public Long save(Role role) {
		String sql = "INSERT INTO role (name, code, createDate, modifiedDate, createdBy, modifiedBy) VALUES (?,?,?,?,?,?) ";
		return insert(sql,role.getName(),role.getCode(),
				role.getCreateDate(),role.getModifiedDate(),role.getCreatedBy(),role.getModifiedBy());
	}

	@Override
	public void update(Role role) {
		StringBuilder sql = new StringBuilder("UPDATE role SET name = ?,code = ?,") ;
		sql.append("createDate = ?, modifiedDate = ? , createdBy = ?, modifiedBy = ?");
		sql.append(" where id = ?");
		this.update(sql.toString(),role.getName(),role.getCode(),
				role.getCreateDate(),role.getModifiedDate(),role.getCreatedBy(),role.getModifiedBy(),
				role.getId());
	}

	
	@Override
	public void delete(Long id) {
		String sql = "DELETE  FROM role WHERE id = ?  ";
		this.update(sql, id);	
	}

	

	

}
 