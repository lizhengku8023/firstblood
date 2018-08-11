package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 */
public class ProxyTest implements InvocationHandler {
    private Object realClass;

    public ProxyTest(Object realClass){
        this.realClass = realClass;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String name = method.getName();
        if ("run".equals(name)){
            System.out.println("过滤了");
            Object invoke = method.invoke(realClass, args);
            System.out.println("过滤之后");
            return invoke+"过滤器";
        }
        return method.invoke(realClass,args);
    }

    public Object createProxy(){
        Object proxyInstance = Proxy.newProxyInstance(this.getClass().getClassLoader(), realClass.getClass().getInterfaces(), this);
        return proxyInstance;
    }

    public static void main(String[] args) {

        Father proxy = (Father) new ProxyTest(new Son()).createProxy();
        String run = proxy.run();
        System.out.println(run);
    }


}
