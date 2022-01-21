package com.unit.testing.controller;

import com.unit.testing.model.User;
import com.unit.testing.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUserInfoSuccess() throws Exception {
        Mockito.when(userService.getUserInfo(Mockito.anyString())).thenReturn(getUser("testUser1"));
        Object obj = userController.getUser("testUser1");
        User user = (User) obj;
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getFirstname(), "testUserFirst");
    }

    @Test
    public void getUserInfoException() throws Exception {
        Mockito.when(userService.getUserInfo(Mockito.anyString())).thenThrow(new Exception("invalid user"));
        Object obj = userController.getUser("testUser1");
        Assert.assertNotNull(obj);
    }

    @Test
    public void getUserInfoSpecialChars1() {
        Object obj = userController.getUser("testUser1@");
        Assert.assertNotNull(obj);
        Assert.assertEquals("400 BAD_REQUEST", obj);
    }

    @Test
    public void getUserInfoNull() throws Exception {
        Mockito.when(userService.getUserInfo(Mockito.anyString())).thenReturn(null);
        Object obj = userController.getUser("testUser145");
        Assert.assertNotNull(obj);
        Assert.assertEquals("ERROR_CODE:400 BAD_REQUEST, ERROR_MESSAGE: invalid Username provided, user does not exist", obj);
    }


    private User getUser(String username) {
        User user = new User();
        if (username.equals("testUser1")) {
            user.setUsername("testUser");
            user.setFirstname("testUserFirst");
            user.setLastname("testUserLast");
        }
        return user;
    }

}
