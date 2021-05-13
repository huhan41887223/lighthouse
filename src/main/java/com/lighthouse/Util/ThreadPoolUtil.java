package com.lighthouse.Util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtil<T,R> {

    private static final ThreadPoolUtil dispose = new ThreadPoolUtil();

    private ThreadPoolUtil(){}

    public static ThreadPoolUtil getDispose() {
        return dispose;
    }

    public static ExecutorService getFixedThreadPool(Integer threadNum){
            return new ThreadPoolExecutor(threadNum, threadNum, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }




}
