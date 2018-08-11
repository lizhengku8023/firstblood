package com.example.proxy;

public class Son implements Father {
    @Override
    public String run() {
        System.out.println("儿子在跑");
        return "erzi1";
    }
}
