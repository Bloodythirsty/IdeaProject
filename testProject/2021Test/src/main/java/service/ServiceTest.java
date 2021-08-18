package service;

import model.User;
import org.springframework.stereotype.Component;
import utils.CommonThreadExecutor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhangkangkang created on 2021/3/12 10:50 上午
 */
@Component
public class ServiceTest {

    public void task() throws InterruptedException {
        doTask();
        System.out.println("task");
        Thread.sleep(10000);
        System.out.println(" task 1 ");
    }

    private void doTask(){
        System.out.println(" do task before ");
        CommonThreadExecutor.submit(()->{
            try {
                Thread.sleep(1000);
                System.out.println("doTask");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void distinct(List<User> users){
        users = users.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getUserId() + ";" + o.getUserName()))),
                ArrayList::new));
    }

}
