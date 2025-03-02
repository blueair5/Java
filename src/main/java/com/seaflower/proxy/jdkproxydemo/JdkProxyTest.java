package com.seaflower.proxy.jdkproxydemo;

public class JdkProxyTest {
    public static void main(String[] args) {
        // 目标对象
        IntroducationService target = new IntroducationService();
        // 获取代理对象
        IntruducationInterface proxy = (IntruducationInterface) JdkProxyFactory.getProxy(target);
        // 执行代理对象的方法
        proxy.sayHi();
    }
}
