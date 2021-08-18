package test;

import utils.CommonThreadExecutor;

public class TestAsyn {
    public static void main(String[] args) {
        System.out.println("begin");
        CommonThreadExecutor.submit(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(10);
                    if (i==50) throw new RuntimeException("50");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(" =done ");
    }
}
