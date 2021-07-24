import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

public class Test1 {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        // 1. 连接
        ZooKeeper zooKeeper = new ZooKeeper("49.234.56.194:3182", 2000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println("路径：" + watchedEvent.getPath());
                System.out.println("类型：" + watchedEvent.getType());
            }
        });

        // 2. 创建
        // String path = zooKeeper.create("/zhangJava12", "zhangjava1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        // System.out.println("path = " + path);

        // 3. 创建子节点
        // String path1 = zooKeeper.create("/zhangJava1/child", "zhangjava1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        // System.out.println("path1 = " + path1);

        // 4. 获取节点值：
        byte[] data = zooKeeper.getData("/zhangJava12", true, null);
        System.out.println(new String(data));

        // 5. 获取子节点
        List<String> children = zooKeeper.getChildren("/zhangJava1", true);
        for (String child : children) {
            System.out.println("child = " + child);
        }

        //6. 修改  版本号：-1匹配任何版本号
        // zooKeeper.setData("/zhangJava12","update112222".getBytes(),4);
        // byte[] dataq = zooKeeper.getData("/zhangJava12", true, null);
        // System.out.println(new String(dataq));
        //
        // Stat stat = zooKeeper.setData("/zhangJava12", "update11222222221".getBytes(), -1);
        // System.out.println("stat = " + stat);
        // byte[] dataq1 = zooKeeper.getData("/zhangJava12", true, null);
        // System.out.println(new String(dataq1));

        // 7 判断某个节点是否存在
        // Stat exists = zooKeeper.exists("/zhangJava1/child0000000001", false);
        // System.out.println("exists = " + exists);

        //8 删除节点

        for (String child : children) {
            zooKeeper.delete("/zhangJava1/"+child, -1);
        }
    }
}
