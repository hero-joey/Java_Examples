package com.hero.zookeeper.basics;

import com.hero.zookeeper.utils.ClientFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Crud
{
    private static final String ZK_ADDRESS = "hadoop1:2181";

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

    public static void createNode() {
        //创建客户端
        CuratorFramework client = ClientFactory.createSimple(ZK_ADDRESS);
        try {
            //启动客户端实例,连接服务器
            client.start();

            // 创建一个 ZNode 节点
            // 节点的数据为 payload

            String createNodePath = "/zookeeper/test/create-node";
            byte[] createNodeDate = "createTest".getBytes(Charset.defaultCharset());
            client.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT)
                    .forPath(createNodePath,createNodeDate);
            System.out.println("创建成功");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(client);
        }
    }

    public static void createSequentialNode() {
        //创建客户端
        CuratorFramework client = ClientFactory.createSimple(ZK_ADDRESS);
        try {
            //启动客户端实例,连接服务器
            client.start();
            for (int i = 0; i < 10; i++) {
                String createNodePath = "/zookeeper/test/sequential-node/node";
                byte[] createNodeDate = "createTest".getBytes(Charset.defaultCharset());
                client.create()
                        .creatingParentsIfNeeded()
                        .withMode(CreateMode.PERSISTENT_SEQUENTIAL)
                        .forPath(createNodePath,createNodeDate);
                System.out.println("创建成功");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(client);
        }
    }

    public static void createEphemeralSequentialNode() {
        //创建客户端
        CuratorFramework client = ClientFactory.createSimple(ZK_ADDRESS);
        try {
            //启动客户端实例,连接服务器
            client.start();
            for (int i = 0; i < 10; i++) {
                String createNodePath = "/zookeeper/test/ephemeral-node/node";
                byte[] createNodeDate = "ephemeral".getBytes(Charset.defaultCharset());
                client.create()
                        .creatingParentsIfNeeded()
                        .withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                        .forPath(createNodePath,createNodeDate);
                System.out.println("创建成功");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(client);
        }
    }

    public static void readNode() {
        //创建客户端
        CuratorFramework client = ClientFactory.createSimple(ZK_ADDRESS);
        try {
            //启动客户端实例,连接服务器
            client.start();

            String readNode = "/zookeeper/test/sequential-node";
            Stat stat = client.checkExists().forPath(readNode);
            if (stat != null) {
                byte[] data = client.getData().forPath(readNode);
                System.out.println(new String(data, Charset.defaultCharset()));
                List<String> childrenPaths = client.getChildren().forPath(readNode);
                for (String childPath : childrenPaths) {
                    System.out.println(childPath);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(client);
        }
    }

    public static void updateNode() {
        //创建客户端
        CuratorFramework client = ClientFactory.createSimple(ZK_ADDRESS);
        try {
            //启动客户端实例,连接服务器
            client.start();

            String updateNode = "/zookeeper/test/sequential-node";
            Stat stat = client.checkExists().forPath(updateNode);
            if (stat != null) {
                byte[] data = client.getData().forPath(updateNode);
                System.out.println(new String(data, Charset.defaultCharset()));
                client.setData().forPath(updateNode, "TestUpdate".getBytes());
                data = client.getData().forPath(updateNode);
                System.out.println(new String(data, Charset.defaultCharset()));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(client);
        }
    }

    public static void updateNodeAsync() {
        //创建客户端
        CuratorFramework client = ClientFactory.createSimple(ZK_ADDRESS);
        try {
            //启动客户端实例,连接服务器
            client.start();

            String updateNode = "/zookeeper/test/sequential-node";
            Stat stat = client.checkExists().forPath(updateNode);
            if (stat != null) {
                byte[] data = client.getData().forPath(updateNode);
                System.out.println(new String(data, Charset.defaultCharset()));
                client.setData()
                        .inBackground(new BackgroundCallback() {
                            @Override
                            public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                                System.out.println("update async");
                                System.out.println(curatorEvent.getResultCode());
                                System.out.println("update async");
                            }
                        })
                        .forPath(updateNode, "TestAsync2".getBytes());
                Thread.sleep(2000);
                data = client.getData().forPath(updateNode);
                System.out.println(new String(data, Charset.defaultCharset()));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(client);
        }
    }

    public static void main(String[] args) {
//        checkNode();
//        createNode();
//        createSequentialNode();
        //createEphemeralSequentialNode();
        //readNode();
        //updateNode();
        updateNodeAsync();
        }
}
