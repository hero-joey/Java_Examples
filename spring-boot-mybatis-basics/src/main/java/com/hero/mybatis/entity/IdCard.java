package com.hero.mybatis.entity;

import java.io.Serializable;

/**
 * (IdCard)实体类
 *
 * @author maccura
 * @since 2020-09-14 10:57:39
 */
public class IdCard implements Serializable {
    private static final long serialVersionUID = -75040668111754199L;
    
    private Integer id;
    
    private String code;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}