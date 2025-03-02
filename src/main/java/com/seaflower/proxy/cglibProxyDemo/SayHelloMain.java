package com.seaflower.proxy.cglibProxyDemo;

public class SayHelloMain {
    public static void main(String[] args) {
        /**
         * 这个在 Java 9 版本会报错，这个报错是由于 Java 模块系统（Java Module System）引起的。
         * 具体来说，这是因为在 Java 9 及更高版本中，某些内部 API 被封装在模块中，默认情况下不对外部代码开放
         * 可以添加以下的 jvm 参数：
         * --add-opens java.base/java.lang=ALL-UNNAMED
         */
        SayHelloService sayHelloService = (SayHelloService) CglibProxyFactory.getProxy(SayHelloService.class);
        sayHelloService.sayHello();

    }
}
