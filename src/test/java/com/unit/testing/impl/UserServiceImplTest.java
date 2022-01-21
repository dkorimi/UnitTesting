package com.unit.testing.impl;

import com.unit.testing.dao.UserDaoImpl;
import com.unit.testing.model.User;
import junit.framework.TestCase;
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
public class UserServiceImplTest extends TestCase {

    @Mock
    private UserDaoImpl userDao;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUserInfoSuccess() throws Exception {
        Mockito.when(userDao.getUserInfo(Mockito.anyString())).thenReturn(getUser("testUser1"));
        User user = userServiceImpl.getUserInfo("testUser1");
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getFirstname(), "testUserFirst");
    }

    @Test
    public void getUserInfoException() throws Exception {
        Mockito.when(userDao.getUserInfo(Mockito.anyString())).thenThrow(new Exception("invalid user"));
        User user = userServiceImpl.getUserInfo("testUser1");
        Assert.assertNull(user);
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