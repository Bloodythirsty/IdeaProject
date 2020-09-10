package cn.kk.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/*
        用于记录日志的类
 */
public class Logger {

    /*
            1. 前置通知
            打印日志，并在切入点方法（业务层方法）执行之前执行
     */
    public void beforePrintLog(){
        System.out.println("before记录日志");
    }

    /*
            2. 后置通知
     */
    public void afterPrintLog(){
        System.out.println("afterReturning记录日志");
    }

    /*
            3. 异常通知
     */
    public void exceptionPrintLog(){
        System.out.println("afterThrowing记录日志");
    }

    /*
            4. 最终通知
     */
    public void finalPrintLog(){
        System.out.println("after记录日志");
    }

    /*
            5. 环绕通知：是Spring提供的可以在代码中手动控制增强方法何时执行的方法。
                1. 问题：配置了环绕通知后，切入点方法没有执行，只执行了环绕通知
                2. 分析：对比动态代理中的环绕通知。发现动态代理中的环绕通知有明确的切入点方法调用，而我们的没有
                3. 解决：
                    1. Spring提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法相当于明确调用切入点方法。
                    2. 该接口可以作为环绕通知的方法参数，在程序执行时，Spring为我们提供接口的实现类
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();      //得到方法执行所需参数

            System.out.println("环绕通知..................前置");

            rtValue = pjp.proceed(args);        //明确调用业务点方法

            System.out.println("环绕通知..................后置");

            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知..................异常");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("环绕通知..................最终");
        }
    }
}
