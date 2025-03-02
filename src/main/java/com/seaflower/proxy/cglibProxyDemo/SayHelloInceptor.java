package com.seaflower.proxy.cglibProxyDemo;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class SayHelloInceptor implements MethodInterceptor {
    /**
     *
     * @param o 被代理对象
     * @param method 被拦截的方法
     * @param args
     * @param methodProxy 用于调用原始方法
     * @return
     * @throws Throwable
     * cglib 会拦截代理类的所有方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 添加自己的操作
        System.out.println("bosssoft-part3");
        // 调用原来的方法
        Object object = methodProxy.invokeSuper(o, args);
        return null;
    }
}
