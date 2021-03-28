package niuKe;

import org.junit.Test;

import java.util.*;

public class LRU {

    @Test
    public void test(){
        int[][] op = {{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int k = 3;
        int[] lru = LRU(op, k);
        for (int i : lru) {
            System.out.println("i = " + i);
        }
    }


    int cap;
    LinkedList<Node> list;
    Map<Integer,Node> map;
/*
输入
[[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
输出
[1,-1]
 */
    public int[] LRU (int[][] operators, int k) {
        // write code here
        this.cap = k;
        list = new LinkedList<>();
        map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();    //存放get值，最终转为int[]
        for (int[] operator : operators) {
            if (operator[0]==2){
                int value = getNode(operator[1]);
                list.add(value);
            }else{
                setNode(new Node(operator[1],operator[2]));
            }
        }
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }



    private void setNode(Node node) {
        if (map.containsKey(node.key)){
            //已经存在，更新map，更新链表
            map.put(node.key,node);
            list.remove(node);
            list.addFirst(node);
        }else {
            if (list.size() < cap){
                //直接加入map和俩表
                map.put(node.key,node);
                list.addFirst(node);
            }else{
                //删除链表最后数据，并将新节点加入头
                Node rem = list.removeLast();
                list.addFirst(node);
                //删除map原数据，加入新数据（防止一个hash上排成链表）
                map.remove(rem.key);
                map.put(node.key,node);

            }
        }
    }

    private int getNode(int key) {
        Node node;
        if(!map.containsKey(key)){
            return -1;
        }else {
            node = map.get(key);
            //调整链表顺序
            list.remove(node);
            list.addFirst(node);
        }
        return node.val;
    }
}


class Node{
    public int key,val;
    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     Node node = (Node) o;
    //     return key == node.key &&
    //             val == node.val;
    // }
    //
    // @Override
    // public int hashCode() {
    //     return Objects.hash(key, val);
    // }
}
