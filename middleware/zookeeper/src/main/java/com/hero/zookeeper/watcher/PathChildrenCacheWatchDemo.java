package com.hero.zookeeper.watcher;


import com.hero.zookeeper.utils.ClientFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.zookeeper.CreateMode;

/**
 * @description: PathChildrenCacheWatcher
 * @date: 2021/1/25 10:21
 * @author: maccura
 * @version: 1.0
 */
public class PathChildrenCacheWatchDemo {
    private static final String ZK_ADDRESS = "hadoop1:2181";

    public static void testPathChildrenCacheWatch() {
        final String workPath = "/zookeeper/listener/pathCacheNode";
        final String subPath = "/zookeeper/listener/pathCacheNode/subNode";

        try {
            CuratorFramework client = ClientFactory.createSimple(ZK_ADDRESS);
            client.start();

            PathChildrenCache pathChildrenCache = new PathChildrenCache(client, workPath, true);
            PathChildrenCacheListener pathChildrenCacheListener = new PathChildrenCacheListener() {
                @Override
                public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                    PathChildrenCacheEvent.Type type = pathChildrenCacheEvent.getType();
                    ChildData childData = pathChildrenCacheEvent.getData();

                    switch (type) {
                        case CHILD_ADDED:
                            System.out.println("子节点增加");
                            System.out.println(childData.getPath());
                            System.out.println(new String(childData.getData()));
                            break;
                        case CHILD_UPDATED:
                            System.out.println("子节点修改");
                            System.out.println(childData.getPath());
                            System.out.println(new String(childData.getData()));
                            break;
                        case CHILD_REMOVED:
                            System.out.println("子节点移除");
                            System.out.println(childData.getPath());
                            System.out.println(new String(childData.getData()));
                        default:
                            System.out.println(type);
                            break;
                    }
                }
            };

            pathChildrenCache.getListenable().addListener(pathChildrenCacheListener);
            pathChildrenCache.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);

            for (int i = 0; i < 3; i++) {
                String subNodePath = subPath  + i;
                client.create()
                        .withMode(CreateMode.PERSISTENT)
                        .forPath(subNodePath);
                System.out.println(String.format("创建节点:%s", subNodePath));
                Thread.sleep(200);

                String data = "Data" + i;
                client.setData().forPath(subNodePath, data.getBytes());
                Thread.sleep(200);

                client.delete().forPath(subNodePath);
                System.out.println(String.format("删除节点:%s", subNodePath));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        testPathChildrenCacheWatch();
    }
}
