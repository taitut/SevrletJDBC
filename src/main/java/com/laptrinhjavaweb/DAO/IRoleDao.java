package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.model.Role;

public interface IRoleDao extends GenericDAO<Role> {
    List<Role> findAllRole();

    Long save(Role role);

    void update(Role role);

    void delete(Long id);

    Role findOne(Long id);
}
