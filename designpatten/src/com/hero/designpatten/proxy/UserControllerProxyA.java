package com.hero.designpatten.proxy;

/**
 * @description: UserControllerProxy
 * @date: 2021/3/5 10:35
 * @author: maccura
 * @version: 1.0
 */
public class UserControllerProxyA implements IUserController {
    private MetricsCollector metricsCollector;
    private UserController userController;

    public UserControllerProxyA(MetricsCollector metricsCollector, UserController userController) {
        this.metricsCollector = metricsCollector;
        this.userController = userController;
    }

    @Override
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        // 委托
        UserVo userVo = userController.login(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return null;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        UserVo userVo = userController.register(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return null;
    }

    public static void main(String[] args) {
        //因为原始类和代理类实现相同的接口，是基于接口而非实现编程
        //将UserController类对象替换为UserControllerProxy类对象，不需要改动太多代码
        IUserController userController = new UserControllerProxyA(new MetricsCollector(), new UserController());
    }
}
