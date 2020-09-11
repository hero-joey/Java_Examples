package com.hero.mybatis;

import com.hero.mybatis.entity.Customer;
import com.hero.mybatis.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisAppTests {

    @Autowired
    CustomerService customerService;

    @Test
    public void testSelectById()
    {
        Customer customer = customerService.queryById(1);
        System.out.println(customer.toString());
    }
}
