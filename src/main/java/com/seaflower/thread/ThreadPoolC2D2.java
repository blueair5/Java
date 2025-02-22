package com.seaflower.thread;

import java.util.concurrent.*;

/**
 * 线程池的写法
 */
public class ThreadPoolC2D2 {
    // 获取可用的处理器数量
    private final static int AVALIABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    /*
     * 1. 设置线程池的核心线程数是物理机的 cpu 个数。
     * 2. 最大线程数是当前物理机 cpu 核心数的 2 倍。
     * 3. 线程池的阻塞队列的大小是 5
     * 4. 拒绝策略
     */
    private final static ThreadPoolExecutor POOL_EXECUTOR =
            new ThreadPoolExecutor(AVALIABLE_PROCESSORS, AVALIABLE_PROCESSORS * 2, 1, TimeUnit.MINUTES,
                    new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());

    public static String methodString() {
        return "Hello, return";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 注意，输出结果可能不是 hello, return 是最后一个
        System.out.println("-------------------- 普通线程池，没有返回值 --------------------");
        POOL_EXECUTOR.execute(() -> {
            System.out.println(1);
        });

        POOL_EXECUTOR.execute(() -> {
            System.out.println(2);
        });

        System.out.println("-------------------- 有返回值的类型 --------------------");
        // 上面的例子是没有返回值的情况
        Future<?> resultA = POOL_EXECUTOR.submit(ThreadPoolC2D2::methodString);

        // get() 会阻塞，等待结果, 在阻塞的过程中，main 就不能看其他的事情了
        System.out.println(resultA.get());

    }

}
