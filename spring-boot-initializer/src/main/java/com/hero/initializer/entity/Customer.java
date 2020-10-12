package com.hero.initializer.entity;

import java.io.Serializable;

/**
 * (Customer)实体类
 *
 * @author maccura
 * @since 2020-09-11 16:25:21
 */
public class Customer implements Serializable {
    private static final long serialVersionUID = 972276976097457147L;
    
    private Integer id;
    
    private String username;
    
    private String job;
    
    private String phone;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}