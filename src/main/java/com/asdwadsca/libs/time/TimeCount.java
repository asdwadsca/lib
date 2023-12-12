package com.asdwadsca.libs.time;

import java.util.concurrent.CountDownLatch;

/**
 * 该类为倒计时工具
 */
public class TimeCount extends Thread{
    private static String thread_state = null;
    public static void count(int user_input) throws InterruptedException{
        CountDownLatch countDownLatch = new CountDownLatch(user_input);
        for (int i = user_input; i >= 0 && !Thread.currentThread().isInterrupted(); i--) {
            int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "执行");
                countDownLatch.countDown();
                System.out.println("剩余时间:" + finalI);
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("线程已被中断");
                }
                thread_state = Thread.currentThread().getState().toString();
            }).start();
            Thread.sleep(1000);
        }
        System.out.println("Thread State:" + thread_state);
        countDownLatch.await();
    }
}
