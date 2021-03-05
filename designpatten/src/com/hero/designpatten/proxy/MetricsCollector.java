package com.hero.designpatten.proxy;

/**
 * @description: MetricsCollector
 * @date: 2021/3/5 10:25
 * @author: maccura
 * @version: 1.0
 */
public class MetricsCollector {
    public void recordRequest(RequestInfo requestInfo) {
        System.out.println(requestInfo.toString());
    }
}
