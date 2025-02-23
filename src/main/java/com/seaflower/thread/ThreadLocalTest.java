package com.seaflower.thread;

public class ThreadLocalTest {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();


    static void print(String str) {
        System.out.println(str + threadLocal.get());
    }

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("threadOne");
                threadLocal2.set("threadOne-Local2");
                print("threadOne");
                System.out.println("threadOne remove after" + ":" + threadLocal.get());
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("threadTwo");
                print("threadTwo");
                System.out.println("threadTwo remove after" + ":" + threadLocal.get());
            }
        });

        threadOne.start();
        threadTwo.start();
    }
}
