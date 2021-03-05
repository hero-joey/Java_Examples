package com.hero;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: UserServiceCglibProxy
 * @date: 2021/3/5 14:43
 * @author: maccura
 * @version: 1.0
 */
public class UserServiceCglibProxy implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 设置回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("事务开始...");
        Object result = methodProxy.invokeSuper(o, args);
        System.out.println("事务结束...");
        return result;
    }


    public static void main(String[] args) {
        UserServiceCglibProxy userServiceCglibProxy = new UserServiceCglibProxy();
        UserService bookFacedImpl = (UserService) userServiceCglibProxy.getInstance(new UserService());
        bookFacedImpl.addUser();
        bookFacedImpl.editUser();
    }

}
