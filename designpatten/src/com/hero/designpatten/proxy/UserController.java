package com.hero.designpatten.proxy;

/**
 * @description: UserController
 * 性能计数器框架代码侵入到业务代码中，跟业务代
 * 码高度耦合
 *
 *收集接口请求的代码跟业务代码无关，本就不应该放到一个类中。业务类最好职责更加单一，只聚焦业务处
 * 理
 * @date: 2021/3/5 10:28
 * @author: maccura
 * @version: 1.0
 */
public class UserController {
    private MetricsCollector metricsCollector;

    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        // ... 省略login逻辑...
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);

        metricsCollector.recordRequest(requestInfo);
        //...返回UserVo数据...
        return null;
    }

    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        // ... 省略register逻辑...
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        //...返回UserVo数据...
        return null;
    }
}
