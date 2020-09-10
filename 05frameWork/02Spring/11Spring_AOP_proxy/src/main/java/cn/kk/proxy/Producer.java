package cn.kk.proxy;

public class Producer implements IProducer{
    public void sell(float money){
        System.out.println("出售电脑"+"拿到"+money);
    }
    public void afterSell(float Money){
        System.out.println("售后");
    }
}
