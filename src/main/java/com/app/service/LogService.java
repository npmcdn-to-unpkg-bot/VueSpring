package com.app.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by mosl on 16/9/7.
 */
@Service
public class LogService {

    private static Logger logger = Logger.getLogger(LogService.class);
    private final PoolWorker[] threads = new PoolWorker[2];// 用数组实现线程池
    private final LinkedList queue = new LinkedList();// 任务队列

    public LogService() {
        for (int i = 0; i < 2; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();// 启动所有工作线程
        }
        System.out.print("init========>");
    }

    public void addLog(){
        Mytask r[] = new Mytask[20];// 20个任务
        for (int i = 0; i < 20; i++) {
            r[i] = new Mytask();
            execute(r[i]);
        }
    }

    public void execute(Runnable r) {// 执行任务
        synchronized (queue) {
            queue.addLast(r);
            queue.notify();
        }
    }

    private class PoolWorker extends Thread {// 工作线程类
        public void run() {
            Runnable r;
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {// 如果任务队列中没有任务，等待
                        try {
                            queue.wait();
                        } catch (InterruptedException ignored) {
                        }
                    }
                    r = (Runnable) queue.removeFirst();// 有任务时，取出任务
                }
                try {
                    r.run();// 执行任务
                } catch (RuntimeException e) {
                }
            }
        }
    }


    class Mytask implements Runnable {// 任务接口

        public void run() {
            String name = Thread.currentThread().getName();
            try {
                logger.info("==========>");
                Thread.sleep(100);// 模拟任务执行的时间
            } catch (InterruptedException e) {
            }
            System.out.println(name + " executed OK");
        }
    }

}
