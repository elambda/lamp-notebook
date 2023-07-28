package org.lamp.javacore.tutorial.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class ThreadPoolExecutorJMXMain {

	public static void main(String[] args) throws Exception {
		// Get the MBean server
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

		// Create and register the Hello MBean
		ObjectName name = new ObjectName("org.lamp:type=ThreadPoolExecutor");
		int initialPoolSize = 2;
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(initialPoolSize);
		ThreadPoolExecutorMXBean threadPoolExecutorMXBean = new ThreadPoolExecutorMXBeanImpl(executor);
		mbs.registerMBean(threadPoolExecutorMXBean, name);

		executor.scheduleWithFixedDelay(() -> getIntConsumer(executor).accept(0), 5, 1, TimeUnit.SECONDS);

		IntConsumer action = getIntConsumer(executor);
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			int timeout = new Random().nextInt(100, 1000);
			TimeUnit.MILLISECONDS.sleep(timeout);
			action.accept(i);
		}
		// Wait for user input
		System.out.println("Press enter to exit...");
		System.in.read();
	}

	private static IntConsumer getIntConsumer(ExecutorService executorService) {
		return i ->
			executorService.submit(() -> {
				int timeout = new Random().nextInt(0, 10);
				System.out.printf("%s - %s - %s - sleep:%d\r\n", Instant.now(), Thread.currentThread().getName(), i, timeout);
				try {
					TimeUnit.SECONDS.sleep(timeout);
					System.out.printf("%s - %s - %s - sleep:%d DONE!\r\n", Instant.now(), Thread.currentThread().getName(), i, timeout);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			});
	}
}
