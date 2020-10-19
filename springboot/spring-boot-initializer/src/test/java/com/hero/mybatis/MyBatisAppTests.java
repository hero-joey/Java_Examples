package com.hero.mybatis;

import com.hero.initializer.entity.Customer;
import com.hero.initializer.entity.NbUser;
import com.hero.initializer.entity.Person;
import com.hero.initializer.entity.User;
import com.hero.initializer.service.CustomerService;
import com.hero.initializer.service.NbUserService;
import com.hero.initializer.service.PersonService;
import com.hero.initializer.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisAppTests {

    @Autowired
    CustomerService customerService;

    @Autowired
    UserService userService;

    @Autowired
    PersonService personService;

    @Autowired
    NbUserService nbUserService;

    @Test
    public void testSelectById()
    {
        Customer customer = customerService.queryById(1);
        System.out.println(customer.toString());
    }
    @Test
    public void testInsert() {
        Customer customer = new Customer();
        customer.setUsername("monkey");
        customer.setJob("programmer");
        customer.setPhone("1522848346");
        customerService.insert(customer);
        System.out.println(customer.getId());
    }

    @Test
    public void testInsertCustomer() {
        Customer customer = new Customer();
        customer.setUsername("huge");
        customer.setJob("programmer");
        customer.setPhone("1522849346");
        customerService.insertCustomer(customer);
        System.out.println(customer.getId());
    }

    @Test
    public void testSelectUser() {
        List<User> userList = userService.queryAllByLimit(0,50);
    }

    //使用if语句查询
    @Test
    public void testSelectUserByIfCondition() {
        User user = new User();
        user.setName("L");
        List<User> userList = userService.findUsersByNamesAndJobs(user);
        System.out.println(userList);
    }

    //使用choose,when,otherwise语句查询
    @Test
    public void testSelectUserByOrCondition() {
        User user = new User();
        //user.setName("L");
        //user.setAge(20);
        List<User> userList = userService.findUsersByNamesOrJobs(user);
        System.out.println(userList);
    }

    //使用if元素
    @Test
    public void testSelectUserByOrCondition2() {
        User user = new User();
        user.setAge(25);
        List<User> userList = userService.findUsersByNamesOrJobs2(user);
        System.out.println(userList);
    }

    //使用set元素
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(3);
        user.setName("snow");
        user = userService.update(user);
        System.out.println(user);
    }

    //使用List foreach查询
    @Test
    public void testSelectByUserIds() {
        List<User> searchUsers = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        User user2 = new User();
        user2.setId(2);
        searchUsers.add(user1);
        searchUsers.add(user2);
        List<User> users = userService.findUsersByUserIds(searchUsers);
        System.out.println(users);
    }

    //使用array foreach查询
    @Test
    public void testSelectByIds() {
        Integer[] ids = new Integer[]{0, 1, 2, 3, 4};
        List<User> users = userService.findUsersByIds(ids);
        System.out.println(users);
    }

    //使用Map foreach 查询
    @Test
    public void testSelectByNameAndIds() {
        Map userMap = new HashMap();
        userMap.put("name", "L");

        List<Integer> userIds = Arrays.asList(1, 2, 3, 4);
        userMap.put("ids", userIds);

        List<User> users = userService.findUsersByNameAndIds(userMap);
        System.out.println(users);
    }

    //使用bind组装字符串
    @Test
    public void testSelectByName() {
        User user = new User();
        user.setName("L");

        List<User> users = userService.findUsersByNames(user);
        System.out.println(users);
    }

    //一对一关联查询，不推荐，需要查询两次
    @Test
    public void testPersonAssociationQuery() {
        Person person = personService.queryById(1);
        System.out.println(person);
    }

    //连表查询
    @Test
    public void testPersonJoinQuery() {
        Person person = personService.findPersonById(2);
        System.out.println(person);
    }

    //连表List查询
    @Test
    public void testPersonJoinQuerys() {
        NbUser nbUser = nbUserService.queryById(1);

        System.out.println(nbUser);
    }





}
