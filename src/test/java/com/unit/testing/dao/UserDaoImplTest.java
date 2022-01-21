package com.unit.testing.dao;

import com.unit.testing.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoImplTest {

    @InjectMocks
    private UserDaoImpl userDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUserInfoSuccess() throws Exception {
        User user = userDao.getUserInfo("testUser1");
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getFirstname(), "testuserfirst");
    }

    @Test
    public void getUserInfoException() throws Exception {
        User user = userDao.getUserInfo("testUser3");
        Assert.assertNull(user);
    }
}
