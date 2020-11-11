package com.hero.test;

import com.hero.test.bean.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: ApplicationContextTest
 * @date: 2020/11/9
 * @author: bear
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestBeanConfiguration.class)

//测试只能使用@TestConfiguration,Configuration会被忽略,反之亦然
public class ApplicationContextTest {
    @Autowired
    private ApplicationContext applicationContex;

    @Test
    public void testUser() {
        Assert.assertNotNull(applicationContex.getBean(User.class));
        Assert.assertNotNull(applicationContex.getBean(Runnable.class));
    }
}
