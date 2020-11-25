package com.hero.proxy;

import java.lang.reflect.Method;

/**
 * @description: GPInvocationHandler
 * @date: 2020/11/21
 * @author: bear
 * @version: 1.0
 */
public interface GPInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
