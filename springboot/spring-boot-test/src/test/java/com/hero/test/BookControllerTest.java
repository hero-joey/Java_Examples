package com.hero.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: BookControllerTest
 * TestRestTemplate需要执行在web环境中
 * @date: 2020/11/9
 * @author: bear
 * @version: 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testBookHome() {
        String result = testRestTemplate.getForObject("/book/home", String.class);
        Assert.assertEquals("book home", result);
    }

    @Test
    public void testBookShow() {
        String result = testRestTemplate.getForObject("/book/show?id=100", String.class);
        Assert.assertEquals("book100", result);
    }
}
