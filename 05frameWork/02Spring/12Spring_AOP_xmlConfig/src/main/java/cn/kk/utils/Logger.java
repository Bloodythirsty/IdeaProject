package cn.kk.utils;
/*
        用于记录日志的类
 */
public class Logger {

    /*
            打印日志，并在切入点方法（业务层方法）执行之前执行
     */
    public void printLog(){
        System.out.println("log记录日志");
    }
}
