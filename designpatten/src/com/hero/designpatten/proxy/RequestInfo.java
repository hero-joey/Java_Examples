package com.hero.designpatten.proxy;

/**
 * @description: Request
 * @date: 2021/3/5 10:26
 * @author: maccura
 * @version: 1.0
 */
public class RequestInfo {
    private String command;
    private Long startTime;
    private Long responseTime;

    public RequestInfo(String command, Long startTime, Long responseTime) {
        this.command = command;
        this.startTime = startTime;
        this.responseTime = responseTime;
    }

    @Override
    public String toString() {
        return "RequestInfo{" +
                "command='" + command + '\'' +
                ", startTime=" + startTime +
                ", responseTime=" + responseTime +
                '}';
    }
}
