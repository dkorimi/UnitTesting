package com.unit.testing.controller;

import com.unit.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public Object getUser(@PathVariable String username) {
        Object obj;
        try {
            if (username.contains("@") || username.contains("$")) {
                throw new Exception("invalid chars");
            }

            obj =  userService.getUserInfo(username);

            if (obj == null) {
                return "ERROR_CODE:400 BAD_REQUEST, ERROR_MESSAGE: invalid Username provided, user does not exist";
            } else {
                return obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "400 BAD_REQUEST";
        }
    }

}
