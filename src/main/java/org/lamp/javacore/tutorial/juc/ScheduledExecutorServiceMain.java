package org.lamp.javacore.tutorial.juc;

import java.time.Instant;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceMain {

	public static void main(String[] args) throws InterruptedException {
//		ExecutorCompletionService
		CompletableFuture.supplyAsync(() -> "Hello");
//		CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS).execute(() -> System.out.println("delayedExecutord:" + Instant.now()));


		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

		showStaticOnIntervalNextExecutionDependsOnPrev();
		executorService.scheduleAtFixedRate(callableTask(), 1, 2, TimeUnit.SECONDS);


//		System.out.println("START=============>>");
//		timerPeriod();
//		System.out.println("END=============>>");

//		Thread.currentThread().join();
	}

	private static void timerPeriod() {
		Timer timer = new Timer("Timer");
		long delay = 5000L;
		TimerTask task = new TimerTask() {
			public void run() {
					callableTask();
			}
		};

		timer.schedule(task, delay);
	}

	private static void showStaticOnIntervalNextExecutionDependsOnPrev() {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
		System.out.println(Thread.currentThread().getName() + "-hello-round:" + 0 + "====" + Instant.now());

		executorService.scheduleWithFixedDelay(callableTask(), 1000, 5000, TimeUnit.MILLISECONDS);
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
