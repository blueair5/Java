package com.seaflower.proxy.cglibProxyDemo;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz); // 设置被代理类
        enhancer.setCallback(new SayHelloInceptor()); // 设置方法拦截器
        return enhancer.create();
    }
}
