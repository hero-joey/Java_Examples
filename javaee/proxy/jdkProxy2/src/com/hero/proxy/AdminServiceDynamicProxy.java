package com.hero.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description: AdminServiceDynamicProxy
 * @date: 2020/11/20 9:58
 * @author: maccura
 * @version: 1.0
 */
public class AdminServiceDynamicProxy {
    private Object target;
    private InvocationHandler invocationHandler;
    public AdminServiceDynamicProxy(Object target, InvocationHandler invocationHandler){
        this.target = target;
        this.invocationHandler = invocationHandler;
    }

    public Object getPersonProxy() {
        Object obj = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), invocationHandler);
        return obj;
    }
}
