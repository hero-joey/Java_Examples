package com.hero.proxy;

public class AdminServiceTest {

    public static void main(String[] args) {
	    AdminServiceImpl adminService = new AdminServiceImpl();
	    AdminServiceProxy adminServiceProxy = new AdminServiceProxy(adminService);
	    adminServiceProxy.find();
	    adminServiceProxy.update();
    }
}
