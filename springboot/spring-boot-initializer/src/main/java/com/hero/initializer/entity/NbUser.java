package com.hero.initializer.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 用户表(NbUser)实体类
 *
 * @author maccura
 * @since 2020-09-14 15:15:37
 */
public class NbUser implements Serializable {
    private static final long serialVersionUID = 700950772587568947L;
    
    private Integer id;
    
    private String username;
    
    private String address;

    private List<NbOrders> nbOrders;

    public List<NbOrders> getNbOrders() {
        return nbOrders;
    }

    public void setNbOrders(List<NbOrders> nbOrders) {
        this.nbOrders = nbOrders;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "NbUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", nbOrders=" + nbOrders +
                '}';
    }
}