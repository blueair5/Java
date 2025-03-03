package com.seaflower.proxy.jdkproxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.function.Function;

/**
 * 获取代理对象的工厂类
 */
public class JdkProxyFactory {

    // 这个是我们 introducation 的 Handler 的实现, 从这看，这个 Handler 除非能够被复用，否则每个都得写一个
    public static Object getProxy(Object target, Function<Object, InvocationHandler> function) {
        return java.lang.reflect.Proxy.newProxyInstance(target.getClass().getClassLoader(), // 目标类的类加载器
                target.getClass().getInterfaces(), // 代理类需要实现的接口
                function.apply(target)); // 代理对象自定义的 InvocationHandler
    }
}
