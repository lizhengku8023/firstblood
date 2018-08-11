package com.example.demotest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleThreadLocal<T> {
    Map<Thread, T> threadTMap = new ConcurrentHashMap<Thread, T>();

    public void setValue(T value){
        threadTMap.put(Thread.currentThread(),value);
    }

    public T get(){
        Thread thread = Thread.currentThread();
        T t = threadTMap.get(thread);
        if (t == null && threadTMap.containsKey(thread)){
            t = initialValue();
            threadTMap.put(thread,t);
        }
        return t;
    }

    private T initialValue() {
        return null;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
