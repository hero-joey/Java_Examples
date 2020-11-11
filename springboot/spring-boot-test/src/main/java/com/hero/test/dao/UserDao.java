package com.hero.test.dao;

import org.springframework.stereotype.Repository;

/**
 * @description: UserDao
 * 直接在测试类增加如下两个注解：
 * @RunWith(SpringRunner.class)
 * @SpringBootTest
 *
 *
 * @date: 2020/11/9
 * @author: bear
 * @version: 1.0
 */
@Repository
public class UserDao {

    public Integer addUser(String username) {
        System.out.println("User dao add user: "+username+"");
        if (username == null) {
            return 0;
        }
        return 1;
    }
}
