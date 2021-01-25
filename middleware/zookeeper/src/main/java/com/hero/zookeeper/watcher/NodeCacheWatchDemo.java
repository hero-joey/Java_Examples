package com.hero.zookeeper.watcher;

import com.hero.zookeeper.utils.ClientFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import javax.sound.midi.Soundbank;
import java.nio.charset.Charset;

/**
 * @description: NodeCacheWatcher
 * @date: 2021/1/25 9:23
 * @author: maccura
 * @version: 1.0
 */
public class NodeCacheWatchDemo {

    private static final String ZK_ADDRESS = "hadoop1:2181";

    private  static void testNodeCacheWatch() {

        try {

            final String workPath = "/zookeeper/listener/remoteNode-none";
            CuratorFramework client = ClientFactory.createSimple(ZK_ADDRESS);
            client.start();

            Stat stat = client.checkExists().forPath(workPath);
            if (stat == null) {
                client.create()
                        .creatingParentsIfNeeded()
                        .withMode(CreateMode.PERSISTENT)
                        .forPath(workPath);
            }

            NodeCache nodeCache = new NodeCache(client, workPath, false);
            NodeCacheListener nodeCacheListener = new NodeCacheListener() {
                @Override
                public void nodeChanged() throws Exception {
                    ChildData childData = nodeCache.getCurrentData();
                    System.out.println(childData.getPath());
                    byte[] data = childData.getData();
                    System.out.println(new String(data, Charset.defaultCharset()));
                }
            };
            //增加监听器
            nodeCache.getListenable().addListener(nodeCacheListener);
            nodeCache.start();

            client.setData().forPath(workPath, "Test1".getBytes());
            Thread.sleep(500);

            client.setData().forPath(workPath, "Test2".getBytes());
            Thread.sleep(500);

            client.setData().forPath(workPath, "Test3".getBytes());
            Thread.sleep(500);

            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        testNodeCacheWatch();
    }
}
