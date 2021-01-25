package com.hero.zookeeper.watcher;

import com.hero.zookeeper.utils.ClientFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

/**
 * @description: WatcherDemo
 * @date: 2021/1/23
 * @author: bear
 * @version: 1.0
 */
public class WatcherDemo {
    private static String workPath = "/test/listener/remoteNode";
    private static String subWorkPath = "/test/listener/remoteNode/id-";
    private static final String ZK_ADDRESS = "hadoop1:2181";

    private static void testWatcher() {

        try {
            CuratorFramework client = ClientFactory.createSimple(ZK_ADDRESS);
            client.start();

            Stat stat = client.checkExists().forPath(workPath);
            if (stat == null) {
                  client.create()
                          .creatingParentsIfNeeded()
                          .forPath(workPath);
            }
            //仅第一次生效
            client.getData().usingWatcher(new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println(watchedEvent.getType());
                    System.out.println(watchedEvent.getState());
                    System.out.println(watchedEvent.getPath());
                }
            }).forPath(workPath);
            client.setData().forPath(workPath, "第一次更改内容".getBytes());
            Thread.sleep(1000);

            client.setData().forPath(workPath, "第二次更改内容".getBytes());
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testWatcher();
    }
}
