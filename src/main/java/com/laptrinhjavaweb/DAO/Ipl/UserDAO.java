package com.laptrinhjavaweb.DAO.Ipl;

import java.util.List;

import com.laptrinhjavaweb.DAO.IUserDao;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.model.User;

public class UserDAO extends AbstractDAO<User> implements IUserDao {

	@Override
	public List<User> findNByRoleId(Long roleId) {
		String sql = "select * from user where categoryId = ?";
		return query(sql, new UserMapper(), roleId);
	}

	@Override
	public List<User> findAllUser() {
	String sql = "SELECT * FROM news";
		return query(sql, new UserMapper());
	}

	@Override
	public Long save(User user) {
		String sql = "Insert into user ( userName, password, fullname, status, createDate, modifiedDate, createdBy, modifiedBy, roleId) VALUES (?,?,?,?,?,?,?,?,?)";
		return insert(sql, user.getUserName(),user.getPassword(),user.getFullname(),user.getStatus(),
				user.getCreateDate(),user.getModifiedDate(),user.getCreatedBy(),user.getModifiedBy(),user.getRole());
	}

	@Override
	public void update(User user) {
		StringBuilder sql = new StringBuilder("UPDATE user SET userName = ?,password = ?, fullname = ?, status = ?,") ;
		sql.append("createDate = ?, modifiedDate = ? , createdBy = ?, modifiedBy = ?, roleId =?");
		sql.append(" where id = ?");
		this.update(sql.toString(), user.getUserName(),user.getPassword(),user.getFullname(),user.getStatus(),
				user.getCreateDate(),user.getModifiedDate(),user.getCreatedBy(),user.getModifiedBy(),user.getRole(),
				user.getId());
		
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM user WHERE id = ?";
		this.update(sql, id);
		
	}

//	@Override
//	public void deleteByRoleId(Long id) {
//		String sql = "DELETE FROM user WHERE roleId = ?";
//		this.update(sql, id);
//	}

	@Override
	public List<User> findNBy(String filed, Object... objects) {
		String sql = "select * from user where "+ filed+" = ?";
		return query(sql,new UserMapper() ,objects );
	}

	@Override
	public User findOne(Long id) {
		String sql = "select * from user where Id = ?";
		 List<User> user = query(sql, new UserMapper(), id);
		return user.isEmpty() ? null : user.get(0);
	}


	
}
