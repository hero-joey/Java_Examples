package com.hero.mybatis.entity;

import java.io.Serializable;

/**
 * 人员表(Person)实体类
 *
 * @author maccura
 * @since 2020-09-14 10:59:49
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 851239416949235922L;
    
    private Integer id;
    
    private String name;
    
    private Integer age;
    
    private String sex;
    
    private IdCard cardId;

    public IdCard getCardId() {
        return cardId;
    }

    public void setCardId(IdCard cardId) {
        this.cardId = cardId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}