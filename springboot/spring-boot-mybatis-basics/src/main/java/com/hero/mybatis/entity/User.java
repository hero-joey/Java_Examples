package com.hero.mybatis.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author hero
 * @since 2020-09-13 13:35:02
 */
public class User implements Serializable {
    private static final long serialVersionUID = -37261634663731606L;
    
    private Integer id;
    
    private String name;
    
    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer tId) {
        this.id = tId;
    }

    public String getName() {
        return name;
    }

    public void setName(String tName) {
        this.name = tName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer tAge) {
        this.age = tAge;
    }

}