package com.example.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    static {
        //创建一个固定长度的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ExecutorService threadPool1 = Executors.newCachedThreadPool();
        ExecutorService threadPool3 = Executors.newSingleThreadExecutor();

    }
}
