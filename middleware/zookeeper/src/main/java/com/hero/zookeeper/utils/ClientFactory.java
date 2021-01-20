package com.hero.zookeeper.utils;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @description: ClientFactory
 * @date: 2021/1/20
 * @author: bear
 * @version: 1.0
 */
public class ClientFactory {

    public static CuratorFramework createSimple(String connectionString) {
        // 重试策略:第一次重试等待1s， 第二次重试等待2s， 第三次重试等待4s
        // 第一个参数： 等待时间的基础单位， 单位为毫秒
        // 第二个参数： 最大重试次数
        ExponentialBackoffRetry retryPolicy =
                new ExponentialBackoffRetry(1000, 3);

        // 获取CuratorFramework实例的最简单方式
        // 第一个参数： zk的连接地址
        // 第二个参数： 重试策略
        return CuratorFrameworkFactory.newClient(connectionString,
                retryPolicy);
    }

}
