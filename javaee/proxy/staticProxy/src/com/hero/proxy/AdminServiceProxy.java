package com.hero.proxy;

/**
 * @description: AdminServiceProxy
 * @date: 2020/11/20 9:12
 * @author: maccura
 * @version: 1.0
 */
public class AdminServiceProxy implements AdminService {
    private AdminServiceImpl adminService;

    public AdminServiceProxy(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @Override
    public void update() {
        System.out.println("判断用户修改权限");
        adminService.update();
    }

    @Override
    public Object find() {
        System.out.println("判断用户查找权限");
        return adminService.find();
    }
}
