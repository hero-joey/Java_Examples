package com.hero.zookeeper;

import com.hero.zookeeper.utils.ClientFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.data.Stat;

/**
 * Hello world!
 *
 */
public class Demos
{
    private static final String ZK_ADDRESS = "hadoop1:2181, hadoop2:2181, hadoop3:2181";

    public static void checkNode() {
        //创建客户端
        CuratorFramework client = ClientFactory.createSimple(ZK_ADDRESS);
        try {
            //启动客户端实例,连接服务器
            client.start();

            // 创建一个 ZNode 节点
            // 节点的数据为 payload

            String zkPath = "/zookeeper/testnode";
            Stat stat = client.checkExists().forPath(zkPath);
            if (null == stat) {
                System.out.println("节点不存在");
            } else {
                System.out.println("节点存在");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(client);
        }
    }

    public static void main(String[] args) {
        checkNode();
    }
}
