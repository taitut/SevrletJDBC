package com.laptrinhjavaweb.service.Ipl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.DAO.IRoleDao;
//import com.laptrinhjavaweb.DAO.IUserDao;
import com.laptrinhjavaweb.model.Role;
import com.laptrinhjavaweb.service.IRoleService;

public class roleService implements IRoleService {
    @Inject
    private IRoleDao roleDao;

    //	@Inject
//	private IUserDao userDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAllRole();
    }

    @Override
    public Role save(Role role) {
        role.setCreateDate(new Timestamp(System.currentTimeMillis()));
        role.setCreatedBy("");
        role.setModifiedBy("");
        role.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        Long roleId = roleDao.save(role);
        return roleDao.findOne(roleId);
    }

    @Override
    public Role update(Role role) {
        Role oldRole = roleDao.findOne(role.getId());
        role.setCreateDate(oldRole.getCreateDate());
        role.setCreatedBy(oldRole.getCreatedBy());
        role.setModifiedBy("");
        role.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        roleDao.update(role);
        return roleDao.findOne(role.getId());
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
//			userDao.deleteByRoleId(id);
            roleDao.delete(id);
        }
    }


}
