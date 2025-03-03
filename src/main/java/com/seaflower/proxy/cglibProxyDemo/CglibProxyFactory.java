package com.seaflower.proxy.cglibProxyDemo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.function.Function;

public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz, MethodInterceptorFactory function) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz); // 设置被代理类
        enhancer.setCallback(function.create()); // 设置方法拦截器
        return enhancer.create();
    }
}
