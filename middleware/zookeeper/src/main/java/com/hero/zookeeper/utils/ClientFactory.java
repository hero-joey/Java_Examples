package com.hero.zookeeper.utils;

import org.apache.curator.RetryPolicy;
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
    private static CuratorFramework client;
    private static ExponentialBackoffRetry retryPolicy =
            new ExponentialBackoffRetry(1000, 3);

    public enum ZOOKEEP_RETRY_POLICY{
      ZOOKEEP_RETRY_POLICY_SIMPLE,
              ZOOKEEP_RETRY_POLICY_WITH_OPTION
    }

    public static CuratorFramework getClient() {
        return client;
    }

    public static void start(String connectionString, ZOOKEEP_RETRY_POLICY zookeeperRetryPolicy) {
        switch (zookeeperRetryPolicy) {
            case ZOOKEEP_RETRY_POLICY_SIMPLE:
                client = createSimple(connectionString);
                break;
            case ZOOKEEP_RETRY_POLICY_WITH_OPTION:
                client = createWithOptions(connectionString, retryPolicy, 2000, 200);
                break;
            default:
                System.out.println("UnSupported");
        }
    }

    public static CuratorFramework createSimple(String connectionString) {
        // 重试策略:第一次重试等待1s， 第二次重试等待2s， 第三次重试等待4s
        // 第一个参数： 等待时间的基础单位， 单位为毫秒
        // 第二个参数： 最大重试次数


        // 获取CuratorFramework实例的最简单方式
        // 第一个参数： zk的连接地址
        // 第二个参数： 重试策略
        return CuratorFrameworkFactory.newClient(connectionString,
                retryPolicy);
    }

    /**
     * @param connectionString zk的连接地址
     * @param retryPolicy 重试策略
     * @param connectionTimeoutMs 连接超时时间
     * @param sessionTimeoutMs 会话超时时间
     * @return CuratorFramework实例
     */
    public static CuratorFramework createWithOptions(
            String connectionString, RetryPolicy retryPolicy,
            int connectionTimeoutMs,int sessionTimeoutMs)
    {
        // 用builder方法创建CuratorFramework实例
        return CuratorFrameworkFactory.builder()
                .connectString(connectionString)
                .retryPolicy(retryPolicy)
                .connectionTimeoutMs(connectionTimeoutMs)
                .sessionTimeoutMs(sessionTimeoutMs)
                // 其他的创建选项
                .build();
    }

}
