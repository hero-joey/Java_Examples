package com.hero.proxy;

/**
 * @description: AdminServiceImpl
 * @date: 2020/11/20 9:10
 * @author: maccura
 * @version: 1.0
 */
public class AdminServiceImpl implements AdminService {
    @Override
    public void update() {
        System.out.println("修改管理系统数据");
    }

    @Override
    public Object find() {
        System.out.println("查看管理系统数据");
        return new Object();
    }
}
