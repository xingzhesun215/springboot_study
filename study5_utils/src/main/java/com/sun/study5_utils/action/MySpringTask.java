package com.sun.study5_utils.action;

import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * 定时任务操作
 * 定时任务还有更加更加专业的依赖来实现 Quartz
 */
@Log
@Component
public class MySpringTask {


    @Scheduled(fixedRate = 2000)
    public void fixedRateMethod() throws Exception {
//        log.warning("2 second run fixedRateMethod" + new Date());
        Thread.sleep(1000);
    }


    @Scheduled(fixedDelay = 2000)
    public void fixedDelayMethod() throws Exception {
//        log.warning("2 second run fixedDelay" + new Date());
        Thread.sleep(1000);
    }


    /**
     * Cron 表达式并不难理解，从左到右一共 6 个位置，分别代表秒、时、分、日、月、星期，以秒为例：
     *
     * 如果该位置上是 0 ，表示在第 0 秒执行；
     * 如果该位置上是 * ，表示每秒都会执行；
     * 如果该位置上是 ? ，表示该位置的取值不影响定时任务，由于月份中的日和星期可能会发生意义冲突，所以日、 星期中需要有一个配置为 ? 。
     * 按照上面的理解，cron = "0 * * * * ?" 表示在每分钟的 00 秒执行、cron = "0 0 0 * * ?" 表示在每天的 00:00:00 执行。
     */

    /**
     * 在每分钟的00秒执行
     */
    @Scheduled(cron = "0 * * * * ?")
    public void jump() throws InterruptedException {
        System.out.println("心跳检测:" + new Date());
    }

    /**
     * 在每天的00:00:00执行
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void stock() throws InterruptedException {
        System.out.println(":" + new Date());
    }
}
