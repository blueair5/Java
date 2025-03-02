package com.seaflower.proxy.jdkproxydemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 自己的 InvocationHandler
 */
@Data
public class IntroducationInvocationHandler implements InvocationHandler {
    // 要代理的对象
    private final Object target;

    public IntroducationInvocationHandler (Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在方法调用之前，添加自己的操作
        System.out.println("bosssoft -> three part");
        // 调用方法
        method.invoke(target, args);
        return null;
    }
}
