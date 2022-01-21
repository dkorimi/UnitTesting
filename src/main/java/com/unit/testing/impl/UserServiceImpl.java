package com.unit.testing.impl;

import com.unit.testing.dao.UserDaoImpl;
import com.unit.testing.model.User;
import com.unit.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    public User getUserInfo(String username) {

        try {
            return userDao.getUserInfo(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
