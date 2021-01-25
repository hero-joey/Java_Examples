package com.hero.zookeeper.watcher;

import com.hero.zookeeper.utils.ClientFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @description: TreeNodeCacheWatcherDemo
 * @date: 2021/1/25 10:48
 * @author: maccura
 * @version: 1.0
 */
public class TreeCacheWatchDemo {
    private static final String ZK_ADDRESS = "hadoop1:2181";

    public static void testPathChildrenCacheWatch() {
        final String workPath = "/zookeeper/listener/treeCacheNode";
        final String subPath = "/zookeeper/listener/treeCacheNode/subNode";

        try {
            CuratorFramework client = ClientFactory.createSimple(ZK_ADDRESS);
            client.start();


            Stat stat = client.checkExists().forPath(workPath);
            if (stat == null) {
                client.create()
                        .creatingParentsIfNeeded()
                        .withMode(CreateMode.PERSISTENT)
                        .forPath(workPath);
            }

            TreeCache treeCache = new TreeCache(client, workPath);
            TreeCacheListener treeCacheListener = new TreeCacheListener() {
                @Override
                public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                    System.out.println("Handler Thread" + Thread.currentThread().getName());

                    TreeCacheEvent.Type type = treeCacheEvent.getType();
                    ChildData childData = treeCacheEvent.getData();
                    switch (type) {
                        case INITIALIZED:
                            System.out.println("节点初始化");
                            System.out.println(childData.getPath());
                            System.out.println(new String(childData.getData()));
                            break;
                        case NODE_ADDED:
                            System.out.println("增加节点");
                            System.out.println(childData.getPath());
                            System.out.println(new String(childData.getData()));
                            break;

                        case NODE_UPDATED:
                            System.out.println("更新节点");
                            System.out.println(childData.getPath());
                            System.out.println(new String(childData.getData()));
                            break;

                        case NODE_REMOVED:
                            System.out.println("移除节点");
                            System.out.println(childData.getPath());
                            break;
                        default:
                            System.out.println(type);
                    }
                }
            };

            treeCache.getListenable().addListener(treeCacheListener);
            treeCache.start();

            for (int i = 0; i < 2; i++) {
                String subNodePath = subPath  + i;
                client.create()
                        .withMode(CreateMode.PERSISTENT)
                        .forPath(subNodePath);
                System.out.println(String.format("创建节点:%s", subNodePath));
                Thread.sleep(200);
            }

            for (int i = 0; i < 2; i++) {
                String subNodePath = subPath  + i;
                String data = "Tree Cache " + i;

                client.setData().forPath(subNodePath, data.getBytes());
                Thread.sleep(200);
            }

            for (int i = 0; i < 2; i++) {
                String subNodePath = subPath  + i;

                client.delete().forPath(subNodePath);
                System.out.println(String.format("删除节点:%s", subNodePath));
            }

            System.out.println("删除主节点");
            client.delete().forPath(workPath);
            System.out.println(Thread.currentThread().getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        testPathChildrenCacheWatch();
    }
}
