package eu.rtakacs.forkjoin;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinPoolExample {

	public static void main(String[] args) {
		
		ForkJoinPool pool = ForkJoinPool.commonPool();
		
		Callable<String> c = new Callable<String>(){

			@Override
			public String call() throws Exception {
				
				Thread.sleep(5000);
				return "Hello world from ForkJoinPool";
			}
			
		};
		
		Callable<String> c2 = () -> {return "Hello world from lambda callable!";};
		
		
		ForkJoinTask<String> task = pool.submit(c);
		ForkJoinTask<String> task2 = pool.submit(c2);
		for(int i =0;i<10; i++){
			pool.submit(c);
		}
		
		
		System.out.println("ActiveThreadCount = " + pool.getActiveThreadCount());
		System.out.println("Parallelism = " + pool.getParallelism());
		System.out.println("PoolSize = " + pool.getPoolSize());
		System.out.println("QueuedSubmissionCount = " + pool.getQueuedSubmissionCount());
		System.out.println("QueuedTaskCount = " + pool.getQueuedTaskCount());
		System.out.println("RunningThreadCount = " + pool.getRunningThreadCount());
		System.out.println("StealCount = " + pool.getStealCount());
		System.out.println("CommonPoolParallelism = " + pool.getCommonPoolParallelism());
		System.out.println("isQuiescent = " + pool.isQuiescent());
		System.out.println("isShutdown = " + pool.isShutdown());
		System.out.println("isTerminated = " + pool.isTerminated());
		System.out.println("isTerminating = " + pool.isTerminating());
//		System.out.println("ActiveThreadCount = " + pool.);
//		System.out.println("ActiveThreadCount = " + pool);
//		System.out.println("ActiveThreadCount = " + pool);
//		System.out.println("ActiveThreadCount = " + pool);
		
		System.out.println();
		try {
			System.out.println("ForkJoinTask1 = " + task.get());
			System.out.println("ForkJoinTask2 = " + task2.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		pool.shutdownNow();
		System.out.println("isShutdown = " + pool.isShutdown());
		System.out.println("isTerminated = " + pool.isTerminated());
		System.out.println("isTerminating = " + pool.isTerminating());
	}

}
