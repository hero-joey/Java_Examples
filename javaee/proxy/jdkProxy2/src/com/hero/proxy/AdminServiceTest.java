package com.hero.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: AdminServiceTest
 * @date: 2020/11/23 10:39
 * @author: maccura
 * @version: 1.0
 */
public class AdminServiceTest {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class clazz = Class.forName("com.hero.proxy.AdminService");

        AdminService superAdminService = new SuperAdminServiceImpl();
        AdminService adminService = new AdminServiceImpl();

        Method[] methods= clazz.getMethods();
        for (Method method: methods) {
            method.invoke(superAdminService, null);
            method.invoke(adminService, null);
        }
        System.out.println("Test finish");
    }
}
