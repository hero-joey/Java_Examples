package com.hero.configure2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 支持获取数组集合
 * 配置方式为name[index]=value
 * @description: TomcatProperties
 * @date: 2020/10/12
 * @author: bear
 * @version: 1.0
 */
@Component
@ConfigurationProperties(prefix = "tomcat")
public class TomcatProperties {
    private List<String> hosts;
    private String[] ports;

    public TomcatProperties() {
    }

    public List<String> getHosts() {
        return hosts;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    public String[] getPorts() {
        return ports;
    }

    public void setPorts(String[] ports) {
        this.ports = ports;
    }

    @Override
    public String toString() {
        return "TomcatProperties{" +
                "hosts=" + hosts +
                ", ports=" + Arrays.toString(ports) +
                '}';
    }
}
