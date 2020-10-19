package com.hero.initializer.entity;

import java.io.Serializable;

/**
 * 订单表(NbOrders)实体类
 *
 * @author maccura
 * @since 2020-09-14 15:15:57
 */
public class NbOrders implements Serializable {
    private static final long serialVersionUID = -69365021723634906L;
    
    private Integer id;
    
    private String number;
    
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}