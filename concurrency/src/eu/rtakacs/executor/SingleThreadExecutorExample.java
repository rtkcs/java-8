package eu.rtakacs.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ExampleCallable implements Callable<String>{
	public String call() throws Exception{
		Thread.sleep(5000);
		return "ExampleCallable Done";
	}
}

public class SingleThreadExecutorExample {

	public static void main(String[] args) {
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<String> future = es.submit(new ExampleCallable());
//		es.shutdownNow();
		
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		es.shutdownNow();
	}
}
