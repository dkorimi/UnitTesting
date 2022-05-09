package com.unit.testing.dao;

import com.unit.testing.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl {

    public User getUserInfo(String username) throws Exception {
        User user = null;
            if (username.equalsIgnoreCase("testuser1")) {
                user = new User();
                user.setUsername("testuser1");
                user.setFirstname("testuserfirst");
                user.setLastname("testuserlast");
            } else if (username.equalsIgnoreCase("testuser2")) {
                user = new User();
                user.setUsername("testuser2");
                user.setFirstname("testuser2first");
                user.setLastname("testuser2last");
            } else if (username.equalsIgnoreCase("testuser3")) {
                user = new User();
                user.setUsername("testuser3");
                user.setFirstname("testuser3first");
                user.setLastname("testuser3last");
            } else if (username.equals("invalidUser")) {
               throw new Exception("invalid user provided");
            }
        return user;
    }
}

