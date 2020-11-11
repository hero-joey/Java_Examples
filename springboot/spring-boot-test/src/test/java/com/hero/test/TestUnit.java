package com.hero.test;

import com.hero.test.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: TestUnit
 * @date: 2020/11/9
 * @author: bear
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUnit {
    @Autowired
    private UserDao userDao;

    @Test
    public void addUserTest() {
        Assert.assertEquals(Integer.valueOf(1), userDao.addUser("root"));
        Assert.assertEquals(Integer.valueOf(1), userDao.addUser(null));
    }


}
