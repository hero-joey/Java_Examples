package com.hero.aop.dao;

import org.springframework.stereotype.Repository;

/**
 * @description: UserDao
 * @date: 2020/11/1
 * @author: bear
 * @version: 1.0
 */

@Repository
public class UserDao {
    private String username;
    private String password;

    public UserDao() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addUser(String username, String password) {
        System.out.println("add user, username:"+username+", password: "+password+"");
    }

}
