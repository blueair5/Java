package com.seaflower.proxy.cglibProxyDemo;

import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 定义一个函数式的接口，用于创建 MethodInterceptor 对象
 */
@FunctionalInterface
public interface MethodInterceptorFactory {
    MethodInterceptor create();

}
