package com.kk.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Minute5Task {

    @Scheduled(cron = "0 0/1 * * * ?")
    public void twoHourScanner(){
        System.out.println("twoHourScanner = " + new Date());
    }

    @Scheduled(cron = "0 30 15 * * ?")
    public void dayScanner(){
        System.out.println("dayScanner(); = " + new Date());
    }
}
