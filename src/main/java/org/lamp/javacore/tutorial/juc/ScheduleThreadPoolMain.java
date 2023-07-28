package org.lamp.javacore.tutorial.juc;

import java.time.Instant;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * if some work has got exception which not handled by the worker self, then it will block the whole schedule plan for the later process
 */
public class ScheduleThreadPoolMain {

	private static final AtomicInteger COUNTER= new AtomicInteger(0);
	public static void main(String[] args) {

		ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);
		scheduledThreadPoolExecutor.scheduleAtFixedRate(() ->{
			int i = COUNTER.incrementAndGet();
			System.out.println(Instant.now() + "-------hello world------" + i );

			if (i % 5 ==0) {
				System.err.println("got error, and the later schedule will not execute in the later");
				throw new NullPointerException("got error");
			}
			System.out.println(Instant.now() + "-------bye------done:" + i );

		}, 5, 1, TimeUnit.SECONDS);
	}


}
