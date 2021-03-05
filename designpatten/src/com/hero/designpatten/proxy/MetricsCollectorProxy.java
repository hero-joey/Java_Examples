package com.hero.designpatten.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: MetricsCollectorProxy
 * @date: 2021/3/5 10:56
 * @author: maccura
 * @version: 1.0
 */
public class MetricsCollectorProxy {
    private MetricsCollector metricsCollector;

    public MetricsCollectorProxy() {
        this.metricsCollector = new MetricsCollector();
    }
    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }

    private class DynamicProxyHandler implements InvocationHandler {
        private Object proxiedObject;
        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        long startTimestamp = System.currentTimeMillis();
        Object result = method.invoke(proxiedObject, args);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
        RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimestamp);
                metricsCollector.recordRequest(requestInfo);
        return result;
        }
    }

    public static void main(String[] args) {
        MetricsCollectorProxy metricsCollectorProxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) metricsCollectorProxy.createProxy(new UserControllerA());
    }
}

