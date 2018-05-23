package eu.rtakacs.executor;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ScheduledThreadPoolTest {

	public static void main(String[] args) throws InterruptedException {
		
		ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
		System.out.println("Current time = " + LocalDateTime.now());
		System.out.println();
		
		for(int i=0;i<3; i++) {
			Thread.sleep(1000);
			WorkerThread worker = new WorkerThread("do heavy processing");
			service.schedule(worker, 3, TimeUnit.SECONDS);
			
		}
		Thread.currentThread().sleep(10000);
		
		service.shutdown();
		while(!service.isTerminated()) {
			
		}
		
		System.out.println();
		System.out.println("Finished all threads!");
		System.out.println();
		
		System.out.println("Recurrent task, automatically stops after 30 seconds.");
		service = Executors.newScheduledThreadPool(5);
		ScheduledFuture<?> future = service.scheduleWithFixedDelay(new WorkerThread("recurrent task"), 1, 3, TimeUnit.SECONDS);
		
		
		Runnable run = new Runnable(){
			ScheduledFuture fut = future;
			public void run(){
				fut.cancel(false);
			}
		};
		
		Callable cal = new Callable<String>(){ 
			public String call() {
				future.cancel(false);
				return "Cancelled";
			} 
		};
		
		service.schedule(run, 30, TimeUnit.SECONDS);
		
//		Thread.sleep(30000);
//		service.shutdown();
//		while(!service.isTerminated()) {
//			
//		}
//		System.out.println();
//		System.out.println("Finished all threads!");
//		System.out.println();
	}
	

}


class WorkerThread implements Runnable{
	
	private String command;
	
	public WorkerThread(String command) {
		this.command = command;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start time = "+ LocalDateTime.now());
		processCommand();
		System.out.println(Thread.currentThread().getName() + " End   time = " + LocalDateTime.now());
	}
	
	private void processCommand() {
		try {
			System.out.println(this.command);
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}