package com.example.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private LinManDao linManDao;

    public CglibProxy(LinManDao linManDao){
        this.linManDao = linManDao;
    }

    public LinManDao createProxy(){
        // 创建Cglib核心类:
        Enhancer enhancer = new Enhancer();
// 类加载器
        enhancer.setClassLoader(CglibProxy.class.getClassLoader());
        // 设置父类:
        enhancer.setSuperclass(linManDao.getClass());
        // 设置回调:
        enhancer.setCallback(this);
        // 生成代理
        LinManDao proxy = (LinManDao) enhancer.create();
        return proxy;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        if("delete".equals(method.getName())){
            Object obj=methodProxy.invokeSuper(o, objects);
            System.out.println("========");
            return obj;
        }

        return methodProxy.invokeSuper(o, objects);
    }
}
