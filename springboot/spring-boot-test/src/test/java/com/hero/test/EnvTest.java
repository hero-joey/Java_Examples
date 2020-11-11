package com.hero.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.TestPropertySourceUtils;

/**
 * @description: EnvTest
 * springboot会优先加载测试环境下的配置文件
 * 测试环境配置文件不存在，则读取正式环境下的配置
 * @date: 2020/11/9
 * @author: bear
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "app.version=1.0.0")
public class EnvTest {

    @Autowired
    private ConfigurableEnvironment env;

    @Before
    public void init() {
        TestPropertySourceUtils.addInlinedPropertiesToEnvironment(env, "app.admin.password=123456");
        TestPropertySourceUtils.addInlinedPropertiesToEnvironment(env,"app.admin.username=daxiong");
    }

    @Test
    public void testValue() {
        Assert.assertEquals("springboottest", env.getProperty("app.name"));
        Assert.assertEquals("1.0.0", env.getProperty("app.version"));
        Assert.assertEquals("daxiong", env.getProperty("app.admin.username"));
        Assert.assertEquals("123456", env.getProperty("app.admin.password"));
        //Assert.assertEquals("8081", env.getProperty("app.port"));
    }
}
