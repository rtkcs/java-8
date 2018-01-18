package eu.rtakacs.cf;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {
	
	public static void main(String[] args){
		
		//
		//---- example before java 8 - Future
		//
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<Double> future = executor.submit(new Callable<Double>(){
			public Double call(){
				return doSomeLongComputation();
			}
		});
		Double result = null;
		try {
			result = future.get(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		System.out.println("CompletableFuture result = " + result);
	}
	
	
	
	public static Double doSomeLongComputation() {
		 try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 42.0;
	}
	

}
