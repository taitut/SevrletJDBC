package com.laptrinhjavaweb.service;

import java.util.List;


import com.laptrinhjavaweb.model.Role;

public interface IRoleService {
	List<Role> findAll ();
	Role save(Role role);
	Role update(Role role);
	void delete(Long[] ids);
}
