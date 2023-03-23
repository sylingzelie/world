package com.sy.world;

import com.sy.world.entity.User;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

public class MyJob implements Job {

    Integer i = 1;

    @Override
    @Async
    public void execute(JobExecutionContext context) throws JobExecutionException {
        CountDownLatch countDownLatch = (CountDownLatch) context.getJobDetail().getJobDataMap().get("countDownLatch");
        User user = (User) context.getJobDetail().getJobDataMap().get("user");
        System.out.println("任务被执行了。。。" + user.getAge());
        user.setAge(user.getAge() + 1);
        context.getJobDetail().getJobDataMap().put("user",user);
        try {
            if (Objects.equals(user.getAge(), 4)) {
                countDownLatch.countDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main1(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        System.out.println(Thread.currentThread().getName());
        // 1.创建调度器 Scheduler
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        // 2.创建JobDetail实例，并与MyJob类绑定(Job执行内容)
        User user = new User();
        user.setUsername("test");
        user.setAge(1);
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("1",2);
        jobDataMap.put("countDownLatch",countDownLatch);
        jobDataMap.put("user",user);
        JobDetail job = JobBuilder.newJob(MyJob.class)
                .setJobData(jobDataMap)
                .withIdentity("job1", "group1")
                .build();
        // 3.构建Trigger实例,每隔30s执行一次
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(1)
                        .withRepeatCount(5))
                .build();
        // 4.执行，开启调度器
        scheduler.scheduleJob(job, trigger);
        scheduler.start();

        countDownLatch.await();
        System.out.println("11111111111111111111");

        //主线程睡眠1分钟，然后关闭调度器

        User user1 = (User) scheduler.getJobDetail(JobKey.jobKey("job1","group1")).getJobDataMap().get("user");
        scheduler.shutdown();
        System.out.println(System.currentTimeMillis());
    }
}