package pack.SpringBeanLife;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangkangkang
 * @date 2021/08/18 18:25
 */
public class CacheTest {
    public static void main(String[] args) {
        Cache<Object, Object> build = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).expireAfterAccess(3, TimeUnit.MINUTES).build();
    }
}
