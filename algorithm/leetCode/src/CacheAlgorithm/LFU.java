package CacheAlgorithm;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author zhangkangkang
 * @date 2021/08/05 17:27
 */
public class LFU {
    public static void main(String[] args) {

        System.out.println("加载当前类的加载器:" + LFU.class.getClassLoader());
        System.out.println("加载应用程序类加载器的加载器"
                    + LFU.class.getClassLoader().getClass().getClassLoader());
        System.out.println("String类的启动类加载器" + String.class.getClassLoader());


        LFUCache lfuCache = new LFUCache(3);
        lfuCache.put(1,1);
        lfuCache.print();
        lfuCache.put(2,2);
        lfuCache.print();
        lfuCache.put(3,3);
        lfuCache.print();
        lfuCache.put(1,1);
        lfuCache.put(1,1);
        lfuCache.put(1,1);
        lfuCache.put(1,1);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        lfuCache.put(2,2);
        lfuCache.put(2,2);
        lfuCache.put(3,3);
        lfuCache.print();
        lfuCache.put(4,4);
        lfuCache.print();
        int i = lfuCache.get(2);
    }
}

class LFUCache{

    // key 到 vale 的映射 : 需要0（1）时间复杂度取出来
    HashMap<Integer,Integer> key2Value;
    // key 到 freq 的映射 ： 更新key的freq的时候需要快速知道freq
    HashMap<Integer,Integer> key2Freq;
    // freq 到 keys列表 的映射 ： 因为最小的freq对应有多个key，但要删除最旧的那个，用linkedHashSet，遍历的第一个就是最旧的
    HashMap<Integer, LinkedHashSet<Integer>> fre2Keys;

    // 记录最小频次：删除时找最小频次的key，遍历太费时间
    private int minFreq;
    // 记录最大容量
    private int maxCap;

    public LFUCache(int maxCap){
        this.maxCap = maxCap;
        this.minFreq = 0;
        key2Value = new HashMap<>();
        key2Freq = new HashMap<>();
        fre2Keys = new HashMap<>();
    }

    public void print(){
        System.out.println("===========");
        for (Map.Entry<Integer, Integer> entry : key2Value.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public int get(int key){
        if(!key2Value.containsKey(key)) return -1;
        increaseFreq(key);
        return key2Value.get(key);
    }

    public void put(int key,int value){
        if(key2Value.containsKey(key)){
            key2Value.put(key,value);
            increaseFreq(key);
            return ;
        }

        if(key2Value.size() >= maxCap){
            removeMinFreqKey();
        }

        // 插入三个表
        key2Value.put(key,value);
        key2Freq.put(key,1);
        fre2Keys.putIfAbsent(1,new LinkedHashSet<>());
        fre2Keys.get(1).add(key);
        // 更新最小频率表
        minFreq = 1;
    }

    private void removeMinFreqKey() {
        // 找到最小频率的keys，删除第一个
        LinkedHashSet<Integer> keysList = fre2Keys.get(minFreq);
        Integer oldestKey = keysList.iterator().next();
        keysList.remove(oldestKey);
        if(keysList.isEmpty()){
            fre2Keys.remove(minFreq);       // 此处不用更新minFreq，put的时候调用完此函数会给minFreq赋值
        }

        //更新 k2f  k2v
        key2Value.remove(oldestKey);
        key2Freq.remove(oldestKey);
    }

    private void increaseFreq(int key) {
        Integer oldFreq = key2Freq.get(key);
        int newFreq = oldFreq + 1;
        // 更新key对应fre
        key2Freq.put(key, newFreq);
        // 删除freq对应的keys
        fre2Keys.get(oldFreq).remove(key);
        if(fre2Keys.get(oldFreq).isEmpty()){
            fre2Keys.remove(oldFreq);
            if(oldFreq == minFreq){         // put的时候用到increaseFreq，因此要更新minFreq
                minFreq = newFreq;
            }
        }
        // 更新freq对应的keys
        fre2Keys.putIfAbsent(newFreq,new LinkedHashSet<>());
        fre2Keys.get(newFreq).add(key);
    }
}


