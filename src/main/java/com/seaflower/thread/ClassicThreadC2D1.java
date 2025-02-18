package com.seaflower.thread;

/**
 * Chapter2: Demo 1
 */
public class ClassicThreadC2D1 {
    // 传统的异步线程的写法: Runnable
    private void classicRunnableThread() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("methodA");  // java Runnable 的匿名类
        });


//        Thread threadRunnable = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });

        thread.run();

        System.out.println("methodB");

        // 等待线程执行完毕，然后一起返回
        thread.join();
        System.out.println("all completed");
    }

    // 实现 Thread 类的写法
    private void classicThread() throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("methodA");
            }
        };
        thread.start();

        System.out.println("methodB");

        // 等待线程执行完毕，然后一起返回
        thread.join();
        System.out.println("all completed");
    }

    /*
     * 上述的传统的写法有以下的缺点：
     * 1. 每当执行异步任务的时候，会直接创建一个线程来执行。创建线程和销毁线程都是有损耗的。而且没有线程线程的个数。
     *    如果使用不当，可能会把系统的线程用尽。
     * 2. 而且使用传统的写法，线程没有返回值，如果需要返回值，则上面的写法就不行了。需要 JDK 中的 Future 的写法了。
     *
     */

    public static void main(String[] args) {

    }
}
