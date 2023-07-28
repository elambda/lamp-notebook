package org.lamp.javacore.tutorial.jmx;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public interface ThreadPoolExecutorMXBean {
    int getActiveCount();
    long getCompletedTaskCount();
    int getCorePoolSize();
    void setCorePoolSize(int corePoolSize);
    int getLargestPoolSize();
    int getMaximumPoolSize();
    int getPoolSize();
    long getTaskCount();
    boolean isShutdown();
    boolean isTerminated();
    boolean isTerminating();

    boolean awaitTermination(long timeout, TimeUnit unit)
            throws InterruptedException;
//    void execute(Runnable command);
    void shutdown();
//    List<Runnable> shutdownNow();
}

