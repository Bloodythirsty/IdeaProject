package utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CommonThreadExecutor.java
 *
 * 公用线程池<p>
 *
 * @author Nico Wang.
 */
// @Slf4j
public class CommonThreadExecutor {

    private CommonThreadExecutor() {
    }

    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(0);

    private static Thread newThread(Runnable runnable) {
        Thread t = new Thread(runnable);
        t.setName("CommonThreadExecutor_" + POOL_NUMBER.addAndGet(1));
        return t;
    }

    /**
     * 核心线程数
     */
    private static final int MACHINE_CORE_NUM = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = MACHINE_CORE_NUM;
    private static final long KEEP_ALIVE_TIME = 6000;
    private static final int MAX_POOL_SIZE = 100 * MACHINE_CORE_NUM;

    private static final ExecutorService POOL =
            new ThreadPoolExecutor(
                    CORE_POOL_SIZE,
                    MAX_POOL_SIZE,
                    KEEP_ALIVE_TIME,
                    TimeUnit.MICROSECONDS,
                    new ArrayBlockingQueue<>(MACHINE_CORE_NUM),
                    CommonThreadExecutor::newThread
            );


    public static <T> Future<T> submit(Callable<T> task) {
        return POOL.submit(task);
    }

    public static Future<?> submit(Runnable task) {
        return POOL.submit(task);
    }



}
