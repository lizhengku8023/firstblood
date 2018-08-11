package com.example.demotest;

public class DoubleSingleton {
    private static volatile DoubleSingleton instance;
    public static  DoubleSingleton getInstance(){
        if (instance == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DoubleSingleton.class){
                if (instance == null){
                    instance = new DoubleSingleton();
                }
            }
        }
        return instance;
    }
}
