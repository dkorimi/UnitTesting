package com.unit.testing.service;

import com.unit.testing.model.User;

public interface UserService {
    User getUserInfo(String username) throws Exception;
}
