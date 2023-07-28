package org.lamp.javacore.tutorial.jmx;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorMXBeanImpl implements ThreadPoolExecutorMXBean {
	private ThreadPoolExecutor executor;

	public ThreadPoolExecutorMXBeanImpl(ExecutorService executor) {
		this.executor = (ThreadPoolExecutor) executor;
	}

	public int getActiveCount() {
		return executor.getActiveCount();
	}

	public long getCompletedTaskCount() {
		return executor.getCompletedTaskCount();
	}

	public int getCorePoolSize() {
		return executor.getCorePoolSize();
	}

	public void setCorePoolSize(int corePoolSize) {
		executor.setCorePoolSize(corePoolSize);
	}

	public int getLargestPoolSize() {
		return executor.getLargestPoolSize();
	}

	public int getMaximumPoolSize() {
		return executor.getMaximumPoolSize();
	}

	public int getPoolSize() {
		return executor.getPoolSize();
	}

	public long getTaskCount() {
		return executor.getTaskCount();
	}

	public boolean isShutdown() {
		return executor.isShutdown();
	}

	public boolean isTerminated() {
		return executor.isTerminated();
	}

	public boolean isTerminating() {
		return executor.isTerminating();
	}

	public boolean awaitTermination(long timeout, TimeUnit unit)
		throws InterruptedException {
		return executor.awaitTermination(timeout, unit);
	}

	public void execute(Runnable command) {
		executor.execute(command);
	}

	public void shutdown() {
		executor.shutdown();
	}

	public List<Runnable> shutdownNow() {
		return executor.shutdownNow();
	}
}
