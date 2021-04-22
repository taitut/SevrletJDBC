package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.model.User;

public interface IUserDao extends GenericDAO<User>{
	List<User>  findNByRoleId(Long roleId);
	List<User>  findAllUser();
	Long save(User user);
	void update(User user);
	void delete(Long id);
//	void deleteByRoleId(Long id);
//	void deleteByComment(Long id);
	List<User>  findNBy( String filed, Object... objects);
	User findOne(Long id);
}
