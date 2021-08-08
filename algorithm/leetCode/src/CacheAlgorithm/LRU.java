package CacheAlgorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.print();
        lruCache.put(2,2);
        lruCache.print();
        lruCache.put(3,3);
        lruCache.print();
        lruCache.put(1,1);
        lruCache.print();
        lruCache.put(4,4);
        lruCache.print();

    }

}

class LRUCache{
    private int capacity;
    private Map<Integer,Integer> cache ;

    public LRUCache(int capacity){
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }

    private void makeRecently(int key){

        int val = cache.get(key);
        // 删除重新插入
        cache.remove(key);
        cache.put(key,val);


    }

    public void print(){
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println(" ==== " );
    }


    public int get(int key){
        //不存在，返回-1
        if (!cache.containsKey(key)) return -1;
        //存在，调整，返回
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key,int val){
        // 存在，修改value，调整
        if(cache.containsKey(key)){
            cache.put(key,val);
            makeRecently(key);
            return ;
        }
        // 不存在，判断容量
        if(capacity <= cache.size()){
            // 容量满，删除链表头部
            int oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
        }
        cache.put(key,val);
    }

}
