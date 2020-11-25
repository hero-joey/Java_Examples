package com.hero.proxy;

/**
 * @description: SuperAdminServiceImpl
 * @date: 2020/11/23 10:37
 * @author: maccura
 * @version: 1.0
 */
public class SuperAdminServiceImpl implements AdminService {
    @Override
    public void update() {
        System.out.println("Super update");
    }

    @Override
    public Object find() {
        System.out.println("Super find");
        return new Object();
    }
}
