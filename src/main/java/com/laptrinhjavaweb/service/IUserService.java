package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.User;

public interface IUserService {
    List<User> findByRoleId(Long RoleId);

    User findNByUserNameRole(String userName, String password, Integer status);

    User save(User user);

    User update(User user);

    void delete(Long[] ids);

    List<User> findAllUser();

    List<User> findNBy(String filed, Object... objects);
}
