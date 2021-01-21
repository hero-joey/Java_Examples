package com.hero.zookeeper.idmaker;

import com.hero.zookeeper.utils.ClientFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;

/**
 * @description: IdMaker
 * @date: 2021/1/21
 * @author: bear
 * @version: 1.0
 */
public class IdMaker {
    private static final String ZK_ADDRESS = "hadoop1:2181";
    private static CuratorFramework client;
    private static boolean initSuccess = false;

    static {
        try {
            client = ClientFactory.createSimple(ZK_ADDRESS);
            client.start();
            initSuccess = true;
        } catch (Exception exception) {
            initSuccess = false;
            System.out.println("IdMaker start failed.");
        }

    }

    public static void destroy() {
        if (null != client) {
            client.close();
        }
        initSuccess = false;
    }

    private static String createSeqNode(String nodePathPrefix) {
        try {
            // 创建一个 ZNode 顺序节点
            return client.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                    //避免zookeeper的顺序节点暴增，需要删除创建的持久化顺序节点
                    //.withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                    .forPath(nodePathPrefix);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String makeId(String nodeName) {
        String str = createSeqNode(nodeName);
        if (null == str) {
            return null;
        }
        int index = str.lastIndexOf(nodeName);
        if (index >= 0) {
            index += nodeName.length();
            return index <= str.length() ? str.substring(index) : "";
        }
        return str;

    }


}
