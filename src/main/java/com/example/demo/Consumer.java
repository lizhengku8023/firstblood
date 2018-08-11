package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @JmsListener(destination = "itcast")
    public void readMessage(String message){
        System.out.println("接收到"+message);
    }
}
