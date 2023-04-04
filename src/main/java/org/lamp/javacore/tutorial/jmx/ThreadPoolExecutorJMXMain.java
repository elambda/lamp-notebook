package org.lamp.javacore.tutorial.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadPoolExecutorExample {
	public static void main(String[] args) throws Exception {
		// create a new thread pool executor with 5 core threads and 10 max threads
		ExecutorService executor = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

		// register the executor with the JMX platform server
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName("org.lamp:type=ExecutorService");
		mbs.registerMBean(executor, name);

		IntStream.range(1,100).parallel().forEach(i -> callableTask());
//		executor.scheduleWithFixedDelay(callableTask(), 1000, 5000, TimeUnit.MILLISECONDS);

		// update the core pool size of the executor via JMX
		mbs.invoke(name, "setCorePoolSize", new Object[]{10}, new String[]{"int"});

		Thread.currentThread().join(50000);
		executor.shutdown();
	}

	private static Runnable callableTask() {
		return () -> {
			Random random = new Random();
			int data = random.nextInt(0, 10);
			System.out.println(Thread.currentThread().getName() + "-hello-round:" + data + "====" + Instant.now());
			try {
				TimeUnit.SECONDS.sleep(data);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		};
	}
}
