package eu.rtakacs.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	public void beebForMinute() {
		final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(() -> System.out.println("beep"), 0, 10, TimeUnit.SECONDS);
		scheduler.schedule(() -> beeperHandle.cancel(true), 30, TimeUnit.SECONDS);
		scheduler.schedule(() -> scheduler.shutdown(), 33, TimeUnit.SECONDS);
	}
	
	public static void main(String[] args) {
		new ScheduledThreadPoolExample().beebForMinute();

	}

}
