package org.lamp.javacore.tutorial.juc;

import java.time.Instant;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadPoolMain {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);

		IntStream.rangeClosed(1, 100).parallel().forEach(i -> worker(executor, i));
	}

	private static void worker(ScheduledThreadPoolExecutor executor, int i) {
		executor.scheduleAtFixedRate(() -> {
			System.out.println(Instant.now() + "-"+Thread.currentThread().getName() + "-" + i);
		}, 0, 5, TimeUnit.MILLISECONDS);
	}
}
