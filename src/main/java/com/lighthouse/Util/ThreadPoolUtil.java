package com.lighthouse.Util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class ThreadPoolUtil<T,R> {

    private static final ThreadPoolUtil dispose = new ThreadPoolUtil();

    private ThreadPoolUtil(){}

    public static ThreadPoolUtil getDispose() {
        return dispose;
    }

    public static ExecutorService getFixedThreadPool(Integer threadNum){
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("线程I型%D").setDaemon(true).build();
            return new ThreadPoolExecutor(threadNum, threadNum, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }




}
