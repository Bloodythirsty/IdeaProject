package cn.kk.cjlib;

import cn.kk.proxy.IProducer;

public class Producer{
    public void sell(float money){
        System.out.println("出售电脑"+"拿到"+money);
    }
    public void afterSell(float Money){
        System.out.println("售后");
    }
}
