package com.hero.designpatten.proxy;

/**
 * @description: UserControllerProxyB
 * 对于这种外部类的扩展，我们一般都是采用继承的方式。这里也不例外。我们让代理类继承
 * 原始类，然后扩展附加功能
 *
 * @date: 2021/3/5 10:46
 * @author: maccura
 * @version: 1.0
 */
public class UserControllerProxyB extends UserControllerA {
    private MetricsCollector metricsCollector;

    public UserControllerProxyB() {
        this.metricsCollector = new MetricsCollector();
    }

    @Override
    public UserVo login(String telephone, String password) {
        System.out.println("Proxy login");
        long startTimestamp = System.currentTimeMillis();
        UserVo userVo = super.login(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        System.out.println("Proxy register");
        long startTimestamp = System.currentTimeMillis();
        UserVo userVo = super.register(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }

    public static void main(String[] args) {
        UserControllerA userController = new UserControllerProxyB();
        userController.login("152", "123");
    }
}
