package com.laptrinhjavaweb.service.Ipl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.DAO.ICommentDao;
import com.laptrinhjavaweb.DAO.IUserDao;
import com.laptrinhjavaweb.model.User;
import com.laptrinhjavaweb.service.IUserService;

public class userService implements IUserService {
    @Inject
    private IUserDao userDao;
    @Inject
    private ICommentDao commentDao;

    @Override
    public List<User> findByRoleId(Long RoleId) {
        return userDao.findNByRoleId(RoleId);
    }

    @Override
    public User findNByUserNameRole(String userName, String password, Integer status) {
        return userDao.findNByUserNameRole(userName, password, status);
    }


    @Override
    public User save(User user) {
        user.setCreateDate(new Timestamp(System.currentTimeMillis()));
        user.setCreatedBy("");
        user.setModifiedBy("");
        user.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        Long userId = userDao.save(user);
        System.out.println(userDao);
        return userDao.findOne(userId);
    }

    @Override
    public User update(User user) {
        User oldNews = userDao.findOne(user.getId());
        user.setCreateDate(oldNews.getCreateDate());
        user.setCreatedBy(oldNews.getCreatedBy());
        user.setModifiedBy("");
        user.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        userDao.update(user);
        return userDao.findOne(user.getId());
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            commentDao.deleteByUserId(id);
            userDao.delete(id);
        }

    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public List<User> findNBy(String filed, Object... objects) {
        return userDao.findNBy(filed, objects);
    }

}
