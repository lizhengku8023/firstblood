package com.example.proxy.cglib;

/**
 * 	Cglib的动态代理
 * JDK代理的缺点：必须让目标对象实现接口，才能使用JDK代理。
 * 	可以对没有实现接口的类产生代理。产生了子类对这个类进行增强。
 */
public class LinManDao {
    public void save(){
        System.out.println("保存联系人...");
    }
    public void find(){
        System.out.println("查询联系人...");
    }
    public void update(){
        System.out.println("修改联系人...");
    }
    public void delete(){
        System.out.println("删除联系人...");
    }
}
